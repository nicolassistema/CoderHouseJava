import java.util.Scanner;

public class EjercicioEnClase {

    public static void main(String[] args) {


        String inputString;


        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un mes: ");
        inputString = sc.nextLine();

        System.out.println("El string ingresado es: " + inputString);
        sc.close();
        int numeroMes;

        switch (inputString.toLowerCase()) {
            case "enero":
                numeroMes = 1;
                break;
            case "febrero":
                numeroMes = 2;
                break;
            case "merzo":
                numeroMes = 3;
                break;
            case "abril":
                numeroMes = 4;
                break;
            case "mayo":
                numeroMes = 5;
                break;
            case "junio":
                numeroMes = 6;
                break;
            case "julio":
                numeroMes = 7;
                break;
            case "agosto":
                numeroMes = 8;
                break;
            case "septiembre":
                numeroMes = 9;
                break;
            case "octubre":
                numeroMes = 10;
                break;
            case "noviembre":
                numeroMes = 11;
                break;

            default:
                numeroMes = 12;
        }
        System.out.println("El numero para el mes " + inputString + ", es: " + numeroMes);
    }



    }
