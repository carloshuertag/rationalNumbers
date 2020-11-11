import java.util.Random;
import java.util.Scanner;

/**
 * Main class UserRational sets an application of Rational class.
 * @version 1, 29/10/20
 * @author Carlos Huerta García
 */

public class UserRational {

    /**
     * Runs an application of Rational class.
     * Displays a random operation with rational numbers.
     * @param args None
     */
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int numerator, denominator;
        char next = 'S';
        do {
            Rational rational1 = new Rational(random).reduced(), rational2 = new Rational(random).reduced(), result = new Rational();
            System.out.println("\nOperaciones con números racionales.\n\nSuma\nResta\nDivisión\nMultiplicación\n");
            System.out.println("\nDos números racionales aleatorios: "+ rational1 + ", " + rational2);
            switch(random.nextInt(4 - 1 + 1) + 1) {
                case 1:
                    result = rational1.addition(rational2).reduced();
                    System.out.println("Suma: " + rational1 + " + " + rational2 + " = ");
                    rational1.add(rational2);
                    break;
                case 2:
                    result = rational1.subtraction(rational2).reduced();
                    System.out.println("Resta: " + rational1 + " - " + rational2 + " = ");
                    rational1.sub(rational2);
                    break;
                case 3:
                    if(rational2.getNumerator() == 0){
                        System.out.println("División entre cero no válida");
                        continue;
                    }
                    result = rational1.division(rational2).reduced();
                    System.out.println("División " + rational1 + " / " + rational2 + " = ");
                    rational1.div(rational2);
                    break;
                case 4:
                    result = rational1.multiplication(rational2).reduced();
                    System.out.println("Multiplicación " + rational1 + " * " + rational2 + " = ");
                    rational1.mult(rational2);
                    break;
                default:
                    break;
            }
            do {
                System.out.println("\nIngrese el resultado obtenido reducido al máximo:\nNumerador: ");
                numerator = scanner.nextInt();
                System.out.println("Denominador: ");
                denominator = scanner.nextInt();
                rational2 = new Rational(numerator, denominator);
                if(rational2.equals(result)){
                    System.out.println("El resultado ingresado es correcto, ¡felicidades!\n\n¿Desea seguir practicando? (S/N)");
                    next = scanner.next().charAt(0);
                } 
                else {
                    if(rational2.equals(rational1))
                        System.out.println("El resultado ingresado es parcialmente correcto, \nreduce al máximo el resultado e intenta de nuevo.\nResultado correcto: " + result);
                    else
                        System.out.println("El resultado ingresado es incorrecto, \nrevisa con detenimiento los pasos intermedios de la operación e intenta de nuevo.\nResultado correcto: " + result);
                    next = 'N';
                }
            } while(next == 'N');
        } while(next == 'S' || next == 's');
        scanner.close();
    }
}
