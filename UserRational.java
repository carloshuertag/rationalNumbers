import java.util.Random;
import java.util.Scanner;

public class UserRational {
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int op, numerator, denominator;
        char next = 'S';
        do {
            Rational rational1 = new Rational(random), rational2 = new Rational(random), result = null;
            System.out.println("\nOperaciones con números racionales.\n\nSuma\nResta\nDivisión\nMultiplicación\n");
            rational1.reduce();
            rational2.reduce();
            System.out.println("\nDos números racionales aleatorios: "+ rational1 + ", " + rational2);
            op = random.nextInt(4 - 1 + 1) + 1;
            switch(op) {
                case 1:
                    result = rational1.addition(rational2);
                    System.out.println("Suma: " + rational1 + " + " + rational2 + " = ");
                    break;
                case 2:
                    result = rational1.subtraction(rational2);
                    System.out.println("Resta: " + rational1 + " - " + rational2 + " = ");
                    break;
                case 3:
                    result = rational1.division(rational2);
                    System.out.println("División " + rational1 + " / " + rational2 + " = ");
                    break;
                case 4:
                    result = rational1.multiplication(rational2);
                    System.out.println("Multiplicación " + rational1 + " * " + rational2 + " = ");
                    break;
                default:
                    break;
            }
            result.reduce();
            do {
                System.out.println("\nIngrese el resultado obtenido reducido al máximo:\nNumerador: ");
                numerator = scanner.nextInt();
                System.out.println("Denominador: ");
                denominator = scanner.nextInt();
                rational1 = new Rational(numerator, denominator);
                if(rational1.equals(result)){
                    System.out.println("El resultado ingresado es correcto, ¡felicidades!\n\n¿Desea seguir practicando? (S/N)");
                    next = scanner.next().charAt(0);
                } 
                else {
                    System.out.println("El resultado ingresado es incorrecto, \nrevisa con detenimiento los pasos intermedios para la operación e intenta de nuevo.");
                    next = 'N';
                }
            } while(next == 'N');
        } while(next == 'S' || next == 's');
        scanner.close();
    }
}
