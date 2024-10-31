import java.util.Random;
import java.util.Scanner;

public class JuegodeAdivinacion {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numAleatorio = new Random().nextInt(100);
        int intentos = 5;

        for (int i = 1; i <= intentos; i++) {
            System.out.println("Dame un numero entre 0 y 100:");
            int res = teclado.nextInt();

            if (res == numAleatorio){
                System.out.println("Felicidades, ganaste!");
                break;
            }else if (res < numAleatorio){
                System.out.println("El numero es mayor a: " + res);
            }else {
                System.out.println("El numero es menor a: " + res);
            }

        }
            System.out.println("Fallaste, game over");
            System.out.println("El numero ganador era: " + numAleatorio);

    }
}
