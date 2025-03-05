package assignment_codility;

import java.util.Scanner;

public class PasswordStrength {

    public static String checkPasswordStrength(String password) {
        if (password.length() < 8 ||!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")||!password.matches(".*[0-9].*")||!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return "Weak";
        }
        return "Strong";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password:");

        String password = scanner.nextLine();
        System.out.println(checkPasswordStrength(password));
    }
}

