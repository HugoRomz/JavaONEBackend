public class Desiciones {
    public static void main(String[] args) {
        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaDeLaPelicula = 8.9;
        String tipoPlan = "plus";

        if (fechaDeLanzamiento >= 2022){
            System.out.println("Péliculas más populares");
        }else {
            System.out.println("Péliculas Retro que aún podemos verla");
        }

        if (incluidoEnElPlan && tipoPlan.equals("plus")){
            System.out.println("Disfrute de su pelicula");
        }else {
            System.out.println("No tiene el plan plus");
        }
    }
}
