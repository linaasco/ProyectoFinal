import java.util.Scanner;
import  java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int intrandomNumber,n,min=0,max=100, contador = 0;

        Random random = new Random();
        intrandomNumber=random.nextInt(100)+1;

        do{
            System.out.println("Ingrese su número entre "+min+" y "+max);
            n=sc.nextInt();

            contador++;

            if(n<=min||n>=max) {
                System.out.println("PERDIO");
                break;
            }
            if(n==intrandomNumber)
                System.out.println("Felicitaciones");
            else {
                if(n>intrandomNumber) {
                    max=n;
                    System.out.println("EL NÚMERO ES MENOR");
                }
                else {
                    min=n;
                    System.out.println("EL NÚMERO ES MAYOR");
                }
            }
            System.out.println("Intentos: "+contador);
        }while(n!=intrandomNumber&&n>=min&&n<=max);
        if(n==intrandomNumber)
            System.out.println("Felicitaciones ");
    }
}