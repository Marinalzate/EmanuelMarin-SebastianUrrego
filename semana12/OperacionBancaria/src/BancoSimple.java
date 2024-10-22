import java.util.Scanner;

public class BancoSimple {

    static String[] nombres = {"Juan Pérez", "María González", "Carlos López"};
    static double[] saldos = {1500.00, 800.00, 1200.00};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1: 
                    int cuentaDeposito = seleccionarCuenta();
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = scanner.nextDouble();
                    depositar(cuentaDeposito, cantidadDeposito);
                    break;
                case 2: 
                    int cuentaRetiro = seleccionarCuenta();
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    retirar(cuentaRetiro, cantidadRetiro);
                    break;
                case 3: 
                    int cuentaConsulta = seleccionarCuenta();
                    consultarSaldo(cuentaConsulta);
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el Banco Simple!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }


    public static void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Salir");
        System.out.println("----------------");
    }


    public static int seleccionarCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una cuenta:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(i + ". " + nombres[i]);
        }
        int indice = scanner.nextInt();
        while (indice < 0 || indice >= nombres.length) {
            System.out.println("Índice inválido. Intente de nuevo:");
            indice = scanner.nextInt();
        }
        return indice;
    }


    public static void depositar(int indice, double cantidad) {
        saldos[indice] += cantidad;
        System.out.println("Depósito exitoso. Nuevo saldo: " + saldos[indice]);
    }


    public static void retirar(int indice, double cantidad) {
        if (saldos[indice] >= cantidad) {
            saldos[indice] -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldos[indice]);
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }


    public static void consultarSaldo(int indice) {
        System.out.println("El saldo de " + nombres[indice] + " es: " + saldos[indice]);
    }
}
