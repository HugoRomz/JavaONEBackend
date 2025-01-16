import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){

        Scanner lectura = new Scanner(System.in);
        System.out.println("Escribe el limite para la tarjeta: ");
        double limite = lectura.nextDouble();
        Tarjeta tarjeta = new Tarjeta(limite);


        int salir = 1;
        while (salir != 0){
            System.out.println("Escribe la descripción");
            lectura.nextLine();
            String descripcion = lectura.nextLine();

            System.out.println("Escribe el valor:");
            double valor = Double.valueOf(lectura.next());

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.hacerCompra(compra);

            if (compraRealizada){
                System.out.println("Compra hecha");
                System.out.println("Escribe 0 para salir ó 1 para continuar");
                salir = lectura.nextInt();
            }else {
                System.out.println("Saldo insuficiente!");
                salir = 0;
            }
        }
        System.out.println("================================");
        System.out.println("LISTA DE COMPRAS: \n");
        Collections.sort(tarjeta.getListaCompras());
        for (Compra compra : tarjeta.getListaCompras()){
            System.out.println("--------------------------");
            System.out.println(compra.getDescripcion()+ " - $" +compra.getValor());
        }

        System.out.println("\nSaldo:" + tarjeta.getSaldo());
    }
}
