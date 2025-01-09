package org.example;

public class TestHighCpuUtilization {

    static class EmailSender extends Thread {

        // Iterative Fibonacci method to prevent StackOverflowError
        public static long calculateFibonacci(int n) {
            long a = 0, b = 1, c;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return b;
        }

        @Override
        public void run() {
            System.out.println("Akash Thread started!");
            while (true) {
                calculateFibonacci(20000);  // Use a more manageable size for iterative Fibonacci
                System.out.println(Thread.currentThread().getName() + " is working"); // Log thread activity
            }
        }
    }
}
