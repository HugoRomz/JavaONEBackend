import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();

        miPelicula.setNombre("Oppenheimer");
        miPelicula.setFechaDeLanzamiento(2023);
        miPelicula.setDuracionEnMinutos(180);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(8.3);
        miPelicula.evalua(8.9);
        miPelicula.evalua(9.4);

        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println("La media de nota de la pelicula es: "+ miPelicula.calculaMedia());

        Serie casaDragon = new Serie();
        casaDragon.setNombre("House of Dragon");
        casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporadas(2);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();

        Pelicula otraPelicula = new Pelicula();
        otraPelicula.setNombre("Interestellar");
        otraPelicula.setDuracionEnMinutos(120);
        otraPelicula.setFechaDeLanzamiento(2015);
        otraPelicula.muestraFichaTecnica();

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);

        System.out.println("Tiempo necesario para terminar tu lista: " + calculadora.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNombre("Los herederos del dragón");
        episodio.setNumero(1);
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(300);
        filtroRecomendacion.filtra(episodio);

        var peliculaDeRafa = new Pelicula();
        peliculaDeRafa.setNombre("1917");
        peliculaDeRafa.setDuracionEnMinutos(119);
        peliculaDeRafa.setFechaDeLanzamiento(2019);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeRafa);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());

        System.out.println(listaDePeliculas.toString());

        System.out.println("ToString de la pelicula: " + listaDePeliculas.get(0).toString());



    }
}
