public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido(a) a Screen Match");
        System.out.println("Película: Matrix");

        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaDeLaPelicula = 8.9;

        double media = (8.2 + 6.0 + 9.0) / 3;
        System.out.println(media);

        String sinopsis = """
                Matrix es una buena pelicula,
                La mejor del fin del milenio
                Fue lanzada en:""" + fechaDeLanzamiento;
        System.out.println(sinopsis);

       /* String nombre = "Maria";
        int edad = 30;
        double valor = 55.9999;
        System.out.println(String.format("Mi nombre es %s, tengo %d años y hoy gasté %.2f dolares", nombre, edad, valor));
       */


        //CASTING

        int clasificacion =(int) (media / 2);
        System.out.println(clasificacion);

        double temperatura = 37.8;
        int temperaturaFahren = (int)((temperatura * 1.8) + 32);
        System.out.println(temperaturaFahren);
    }
}