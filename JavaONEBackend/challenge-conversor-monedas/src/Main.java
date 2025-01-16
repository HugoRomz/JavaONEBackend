import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsultarMoneda cambioDivisa = new ConsultarMoneda();
        Scanner teclado = new Scanner(System.in);
        int opcion;
        var valorConversion = 0.0;
        boolean salir = false;

        while (!salir){
            mostrarMenu();
            System.out.print("Elija una opción válida: \n");

            if (teclado.hasNextInt()){
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Igresa el monto a cambiar");
                        valorConversion = Double.valueOf(teclado.nextLine());
                        cambioDivisa.cambioMoneda("USD", "MXN", valorConversion);
                        System.out.println(cambioDivisa);
                        break;
                    case 2:
                        System.out.println("Igresa el monto a cambiar");
                        valorConversion = Double.valueOf(teclado.nextLine());
                        cambioDivisa.cambioMoneda("MXN", "USD", valorConversion);
                        System.out.println(cambioDivisa);
                        break;
                    case 3:
                        System.out.println("Igresa el monto a cambiar");
                        valorConversion = Double.valueOf(teclado.nextLine());
                        cambioDivisa.cambioMoneda("USD", "BRL", valorConversion);
                        System.out.println(cambioDivisa);
                        break;
                    case 4:
                        System.out.println("Igresa el monto a cambiar");
                        valorConversion = Double.valueOf(teclado.nextLine());
                        cambioDivisa.cambioMoneda("BRL", "USD", valorConversion);
                        System.out.println(cambioDivisa);
                        break;
                    case 5:
                        System.out.println("Igresa el monto a cambiar");
                        valorConversion = Double.valueOf(teclado.nextLine());
                        cambioDivisa.cambioMoneda("USD", "CLP", valorConversion);
                        System.out.println(cambioDivisa);
                        break;
                    case 6:
                        System.out.println("Igresa el monto a cambiar");
                        valorConversion = Double.valueOf(teclado.nextLine());
                        cambioDivisa.cambioMoneda("CLP", "USD", valorConversion);
                        System.out.println(cambioDivisa);
                        break;
                    case 7:
                        List<String> historial = cambioDivisa.consultarHistorial();
                        for (String record : historial){
                            System.out.println(record);
                        }
                        break;
                    case 8:
                        System.out.println("¡Hasta luego!");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elija una opción entre 1 y 8.");
                }
            }else {
                System.out.println("No válido, ingrese correctamente el numero según la opción deseada.");
                teclado.nextLine();
            }
        }
        teclado.close();


    }

    private static void mostrarMenu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|   Sea bienvenido/a al Conversor de monedas :3   |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| 1) | Dólar[USD] => Peso Mexicano[MXN]           |");
        System.out.println("| 2) | Peso Mexicano[MXN] => Dólar[USD]           |");
        System.out.println("| 3) | Dólar[USD] => Real Brasileño[BRL]          |");
        System.out.println("| 4) | Real Brasileño[BRL] => Dólar[USD]          |");
        System.out.println("| 5) | Dólar[USD] => Peso Chileno[CLP]            |");
        System.out.println("| 6) | Peso Chileno[CLP] => Dólar[USD]            |");
        System.out.println("| 7) | Consultar Historial                        |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| 8) Salir                                        |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}