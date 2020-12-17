import java.io.PrintStream;
import java.util.Scanner;

public class cryptRSA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream out = System.out;
        RSA rsa = new RSA();
        String text;
        text = scanner.nextLine();
        scanner.close();
        byte[] encrypted = rsa.encrypt(text.getBytes());
        out.println("Encrypted - " + encrypted);
        byte[] decrypted = rsa.decrypt(encrypted);
        out.println("Decrypted - " + new String(decrypted));
    }
}