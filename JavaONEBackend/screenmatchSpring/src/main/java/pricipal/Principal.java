package pricipal;

import com.aluracursos.screenmatch.model.*;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos()
            ;
    private final String URL_BASE = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=ce527d81";

    private List<DatosSerie> datosSeries = new ArrayList<>();
    private SerieRepository repositorio;
    private List<Serie> series;

    private Optional<Serie> serieBuscada;

    public Principal(SerieRepository repository) {
        this.repositorio = repository;
    }


    public void muestrarMenu(){

        var  opcion = -1;

        while (opcion != 0){
            var menu = """
                    1.- Buscar Series
                    2.- Buscar Episodios
                    3.- Mostrar Series buscadas
                    4.- Buscar Serie por Titulo
                    5.- Top 5 series
                    6.- Buscar por categoria
                    7 - Filtrar series
                    8.- Buscar episodios por nombre
                    9.- Top 5 episodios por serie
                    0.- Salir""";

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodiosPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriesPorTitulo();
                    break;
                case 5:
                    buscarTop5Series();
                    break;
                case 6:
                    buscarPorCategoria();
                    break;
                case 7:
                    filtrarSeriesPorTemporadaYEvaluacion();
                    break;
                case 8:
                    buscarEpisodioPorNombre();
                    break;
                case 9:
                    buscarTop5Episodios();
                    break;

                case 0:
                    System.out.println("Cerrando...");

                default:
                    System.out.println("Opcion invalida");

            }

        }
    }

    private void buscarTop5Episodios() {
        buscarSeriesPorTitulo();
        if (serieBuscada.isPresent()){
            Serie serie = serieBuscada.get();
            List<Episodio> topEpisodios = repositorio.top5Episodios(serie);

            topEpisodios.forEach(episodio ->
                    System.out.printf("Serie %s - Temporada: %s - Episodio: %s - Titulo: %s - Evaluacion: %s\n",
                            episodio.getSerie().getTitulo(),episodio.getTemporada(), episodio.getNumeroEpisodio(),episodio.getTitulo(), episodio.getEvalacion()));
        }
    }

    private void buscarEpisodioPorNombre() {
        System.out.println("Dame el nombre del episodio que quieres: ");
        var nombreEpisodio = teclado.nextLine();

        List<Episodio> episodiosEcontrados = repositorio.episodiosPorNombre(nombreEpisodio);

        episodiosEcontrados.forEach(episodio ->
                System.out.printf("Serie %s Temporada: %s Episodio: %s Evaluacion: %s\n",
                        episodio.getSerie().getTitulo(),episodio.getTemporada(), episodio.getTitulo(), episodio.getEvalacion()));
    }

    public void filtrarSeriesPorTemporadaYEvaluacion(){
        System.out.println("¿Filtrar series con cuántas temporadas? ");
        var totalTemporadas = teclado.nextInt();
        teclado.nextLine();
        System.out.println("¿Com evaluación apartir de cuál valor? ");
        var evaluacion = teclado.nextDouble();
        teclado.nextLine();
        List<Serie> filtroSeries = repositorio.seriesPorTemporadaYEvaluacion(totalTemporadas,evaluacion);
        System.out.println("*** Series filtradas ***");
        filtroSeries.forEach(serie -> System.out.println("Serie:"+  serie.getTitulo()+ "Eval:"+  serie.getEvaluacion()));
    }

    private void buscarPorCategoria() {
        System.out.println("Escribe el genero de la serie");
        var genero = teclado.nextLine();
        var categoria = Categoria.fromEspaniol(genero);
        List<Serie> seriePorCategoria = repositorio.findByGenero(categoria);
        System.out.println("Las series de la categoria: "+ genero);
        seriePorCategoria.forEach(System.out::println);
    }

    private void buscarTop5Series() {
        List<Serie> top5Series = repositorio.findTop5ByOrderByEvaluacionDesc();

        top5Series.forEach(serie -> System.out.println("Serie:"+  serie.getTitulo()+ "Eval:"+  serie.getEvaluacion()));

    }

    private void buscarSeriesPorTitulo() {
        System.out.println("Escibre el nombre de la serie");
        var nombreSerie = teclado.nextLine();

        serieBuscada = repositorio.findByTituloContainsIgnoreCase(nombreSerie);

        if (serieBuscada.isPresent()){
            System.out.println("La serie buscada es: " + serieBuscada.get());
        }else {
            System.out.println("Serie no encontrada");
        }
    }

    private DatosSerie getDatosSerie(){
        System.out.println("Escribe el nombre de la serie que quieres buscar");
        var nombreSerie = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+")+ API_KEY);
        System.out.println(json);

        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        return datos;
    }


    private void buscarEpisodiosPorSerie(){
        mostrarSeriesBuscadas();
        System.out.println("Escibre el nombre de la serie para ver sus episodios");
        var nombreSerie = teclado.nextLine();

        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
                .findFirst();

        if (serie.isPresent()){
            var serieBuscada = serie.get();
            List<DatosTemporada> temporadas = new ArrayList<>();
            for (int i = 1; i <= serieBuscada.getTotalTemporadas(); i++) {
                var json = consumoAPI.obtenerDatos(URL_BASE + serieBuscada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DatosTemporada datosTemporada = conversor.obtenerDatos(json, DatosTemporada.class);
                temporadas.add(datosTemporada);
            }
            temporadas.forEach(System.out::println);
            List<Episodio> episodios = temporadas.stream()
                    .flatMap(datosTemporada -> datosTemporada.episodios().stream().map(e-> new Episodio(datosTemporada.numero(), e)))
                    .collect(Collectors.toList());
            serieBuscada.setEpisodios(episodios);
            repositorio.save(serieBuscada);
        }else {
            System.out.println("Serie no encontrada");
        }




    }

    private void buscarSerieWeb(){
        DatosSerie datos = getDatosSerie();
//        datosSeries.add(datos);
        Serie serie = new Serie(datos);
        repositorio.save(serie);
        System.out.println(datos);
    }

    private void mostrarSeriesBuscadas() {
        series = repositorio.findAll();
//
//        series = datosSeries.stream()
//                .map(s-> new Serie(s))
//                .collect(Collectors.toList());


        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }


}
