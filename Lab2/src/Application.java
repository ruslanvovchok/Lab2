
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        double operand = scanner.nextDouble();
        calculator(operand);
    }

    private static void calculator(double operand) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose operation (+, -, *, /, invert, exit):");
        String operation = scanner.next();

        if (operation.equals("exit")) {
            System.out.println("Result: " + operand);
            return;
        }

        double operand2 = 0;
        if (!operation.equals("invert")) {
            System.out.println("Enter next number:");
            operand2 = scanner.nextDouble();
        }

        double result = performOperation(operand, operand2, operation);
        System.out.println("Current result: " + result);
        calculator(result);
    }

    private static double performOperation(double operand1, double operand2, String operation) {
        switch (operation) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    System.out.println("Error: divide on zero!");
                    return operand1;
                }
                return operand1 / operand2;
            case "invert":
                return -operand1;
            default:
                System.out.println("Uknown operation. Please, try again.");
                return operand1;
        }
    }
}
