import java.util.Scanner;

public class Prestamo {


    public static void main(String[] args) {
        double resutInteresAPagar;
        double capSoli = 10000;
        double intertes = 10;
        int mes = 5;

        Scanner sc = new Scanner(System.in);
        capSoli = sc.nextInt();
        sc.close();
        resutInteresAPagar = capSoli * intertes * mes;



        System.out.println("interes a pagar: " + resutInteresAPagar);

    }


}
