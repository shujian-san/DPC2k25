import java.util.Scanner;

public class Day16 {
    // Function to calculate GCD
    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    // Function to calculate LCM
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input two integers
        long N = sc.nextLong();
        long M = sc.nextLong();
        
        // Calculate and print LCM
        System.out.println(lcm(N, M));
        
        sc.close();
    }
}
