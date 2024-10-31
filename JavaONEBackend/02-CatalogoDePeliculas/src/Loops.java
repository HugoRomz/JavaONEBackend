import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        double nota = 0;
        double mediaEval = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Dame la nota que la das a la pelicula Matrix");
            nota = teclado.nextDouble();

            mediaEval = mediaEval + nota;
        }

        System.out.println(mediaEval / 3);

    }
}
