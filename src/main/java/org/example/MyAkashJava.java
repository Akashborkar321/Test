package org.example;

public class MyAkashJava {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        TestHighCpuUtilization testHighCpuUtilization = new TestHighCpuUtilization();
        TestHighCpuUtilization.EmailSender emailSender = new TestHighCpuUtilization.EmailSender();
        emailSender.setName("Akash Thread");
        emailSender.start();
        System.out.println("Thread name: " + emailSender.getName());  // This will print "Akash Thread"

        // Ensure main thread gives CPU time to other threads
        int i = 1;
        System.out.println("I am about to start");

        // Loop to simulate more CPU consumption in the main thread too
        while (i <= 5) {
            System.out.println("Hello " + i++);
            try {
                Thread.sleep(500); // Sleep to allow other threads to run
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Optionally join with the emailSender thread to ensure the program doesn't exit early
        try {
            emailSender.join(); // Wait for the emailSender thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}
