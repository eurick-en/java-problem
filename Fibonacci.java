import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();

        int a = 0, b = 1, temp;
        boolean pertence = false;

        while (a <= numero) {
            if (a == numero) {
                pertence = true;
                break;
            }
            temp = a + b;
            a = b;
            b = temp;
        }

        if (pertence) {
            System.out.println(numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(numero + " não pertence à sequência de Fibonacci.");
        }
    }
}
