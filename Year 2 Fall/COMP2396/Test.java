import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Get input from the user
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // Split into three params
        String[] params = input.split(" ");
        // parse integer from string
        int i = Integer.parseInt(params[0]);
        // Get first char of param
        char firstChar = params[0].charAt(0);
        double d = -12.2;
        // print the double 
        System.out.println(d);
        // compare strings
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println(s1.equals(s2));
        scanner.close();
        // for loop
        for (int j = 0; j < 10; j++) {
            System.out.println(j);
        }
        // min of two numbers
        int a = 10;
        int b = 20;
        int min = Math.min(a, b);
        System.out.println(min);
    }
}