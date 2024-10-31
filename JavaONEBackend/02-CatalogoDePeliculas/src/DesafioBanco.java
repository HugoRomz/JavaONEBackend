import java.util.Scanner;

public class DesafioBanco {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String cliente = "Bruce Wayne";
        String tipoCuenta = "Corriente";
        double saldo = 100;
        int opcion = -1;
        do {
            System.out.println("*****************************************");
            System.out.println("|*   Escribe el numero de la opción:   *|");
            System.out.println("| 1 | Consultar saldo                   |");
            System.out.println("| 2 | Retirar                           |");
            System.out.println("| 3 | Depositar                         |");
            System.out.println("|---------------------------------------|");
            System.out.println("| 0 | Salir                             |");
            System.out.println("*****************************************");

            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("*****************************************");
                    System.out.println("|*         Datos de la cuenta.         *|");
                    System.out.println("| Propietario |" + cliente + "           ");
                    System.out.println("| Tipo        |" + tipoCuenta + "        ");
                    System.out.println("| Saldo       |" + saldo + "             ");
                    System.out.println("*****************************************");
                    break;
                case 2:
                    System.out.println("------------------------------------------");
                    System.out.println("Tu saldo actual es de: " + saldo );
                    System.out.println("Cual es la cantidad que deseas retirar?");
                    System.out.println("------------------------------------------");
                    double cantidadRetiro = teclado.nextDouble();
                    System.out.println("------------------------------------------");
                    if (cantidadRetiro > saldo){
                        System.out.println("Saldo Insuficiente");
                    System.out.println("------------------------------------------");
                    }else {
                        saldo -= cantidadRetiro;
                        System.out.println("Retiraste: " + cantidadRetiro + " de tu cuenta.");
                        System.out.println("Tu saldo actual es de: " + saldo );
                    System.out.println("------------------------------------------");
                    }

                    break;
                case 3:
                    System.out.println("------------------------------------------");
                    System.out.println("Tu saldo actual es de: " + saldo );
                    System.out.println("Cual es la cantidad que deseas depositar?");
                    System.out.println("------------------------------------------");
                    double cantidadDeposito = teclado.nextDouble();
                    System.out.println("------------------------------------------");
                    if (cantidadDeposito <= 5 ){
                        System.out.println("No puedes depositar menos de 5 pesos");
                        System.out.println("Porfavor digita una cantidad mayor");
                        System.out.println("------------------------------------------");
                    }else {
                        saldo += cantidadDeposito;
                        System.out.println("Depositaste: " + cantidadDeposito + " a tu cuenta.");
                        System.out.println("Tu saldo actual es de: " + saldo );
                        System.out.println("------------------------------------------");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo de la app");
                    break;
                default:
                    System.out.println("Ingreso no valido");
            }
        }while (opcion != 0);
        System.out.println("Hasta Pronto!");
    }

}
