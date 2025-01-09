import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String original = scanner.nextLine();

        char[] caracteres = original.toCharArray();
        String invertida = "";

        for (int i = caracteres.length - 1; i >= 0; i--) {
            invertida += caracteres[i];
        }

        System.out.println("String invertida: " + invertida);
    }
}
