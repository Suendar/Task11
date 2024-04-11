 1. What are the four access modifiers available in Java and what is their significance in terms of class, method, and variable accessibility?

    
In Java, there are four access modifiers:
Public:         This modifier allows unrestricted access to the class, method, or variable from any other class or package.
Protected:      This modifier allows access to the class, method, or variable from within the same package or by subclasses, even if they are in different packages.
                Default (no modifier): If no access modifier is specified, then by default, the class, method, or variable is accessible only within the same package.
Private:        This modifier restricts access to the class, method, or variable only within the same class. It cannot be accessed from outside the class.
                These access modifiers control the accessibility of classes, methods, and variables as follows:
Class Access:   Public classes can be accessed from anywhere. Default and protected classes can be accessed only within the same package. Private classes cannot be 
                accessed from outside the class they are declared in.
Method Access:  Public methods can be accessed from anywhere. Protected and default methods can be accessed only within the same package. Private methods can only be 
                accessed within the same class.
Variable Access:Public variables can be accessed from anywhere. Protected and default variables can be accessed only within the same package or by subclasses. 
                Private variables can only be accessed within the same class.

2. What is the difference between Exception and error?
 
In Java, both exceptions and errors are subclasses of the Throwable class, but they serve different purposes:
Exception: Exceptions are events that occur during the execution of a program that disrupts the normal flow of instructions. They are often caused by external factors, such as user input errors, file I/O errors, or network connection problems. Exceptions are recoverable and can be handled by the program using try-catch blocks or by declaring them in method signatures using the throws keyword. Examples of exceptions include NullPointerException, IOException, and NumberFormatException.
Error: Errors, on the other hand, are exceptional conditions that are typically beyond the control of the application and usually cannot be handled by the program. Errors are often caused by system-level issues, such as running out of memory (OutOfMemoryError), stack overflow (StackOverflowError), or hardware failures. Unlike exceptions, errors are not meant to be caught or handled by the application, as attempting to recover from them may lead to unpredictable behavior. Errors are usually considered fatal and may cause the application to terminate abruptly.


3.What is the difference between checked Exception and unchecked Exception?
 
The difference between checked and unchecked exceptions in Java lies primarily in how the compiler enforces handling or declaration of these exceptions:

Checked Exceptions:

Checked exceptions are the exceptions that are checked at compile time by the compiler.
Any method that may throw a checked exception must declare this exception using the throws keyword in its method signature, or handle the exception using a try-catch block.
Examples of checked exceptions include IOException, ClassNotFoundException, and SQLException.
The programmer is forced to either handle these exceptions or explicitly propagate them up the call stack using the throws clause.

Unchecked Exceptions (Runtime Exceptions):

Unchecked exceptions are the exceptions that are not checked at compile time by the compiler.
These exceptions occur at runtime and are not required to be declared or handled explicitly.
Unchecked exceptions are usually caused by programming errors or unexpected conditions that the programmer may not anticipate or recover from.
Examples of unchecked exceptions include NullPointerException, ArrayIndexOutOfBoundsException, and ArithmeticException.
While it's not mandatory to handle or declare unchecked exceptions, it's still a good practice to handle them if possible to ensure robustness and graceful degradation of the application.

4.Write a Java program that reads user input for two integers and performs division. Handle the exception that is thrown when the second number is zero, and display an error message to the user.

   
import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
             
            System.out.print("Enter the first integer: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second integer: ");
            int num2 = scanner.nextInt();

             
            double result = divide(num1, num2);

            
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
             
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
             
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
             
            scanner.close();
        }
    }

     
    public static double divide(int num1, int num2) {
        if (num2 == 0) {
             
            throw new ArithmeticException("Division by zero");
        }
        return (double) num1 / num2;
    }
}

5.Write the code of ArrayIndexOutOfBoundsException & StringIndexOutOfBoundsException?

public class IndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5};
        try {
            // Trying to access an index beyond the length of the array
            int element = arr[6];  
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }

        
        String str = "Hello";
        try {
             
            char character = str.charAt(10); 
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }
}

6.You are building a login system for a website using Java. If the user enters an incorrect password, you want to display a message informing them of the error. How would you use exception handling to handle this situation?

 class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}

 class LoginService {
    private static final String CORRECT_PASSWORD = "correctPassword"; // Change this to the correct password

     public void login(String enteredPassword) throws IncorrectPasswordException {
        if (!enteredPassword.equals(CORRECT_PASSWORD)) {
            throw new IncorrectPasswordException("Incorrect password. Please try again.");
        }
        System.out.println("Login successful!"); // If password is correct
    }
}

 public class Main {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        String enteredPassword = "incorrectPassword"; // Change this to the password entered by the user

        try {
            loginService.login(enteredPassword);
        } catch (IncorrectPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}

7.Create a custom exception in Java called "InvalidAgeException" that is thrown when the user enters an age less than 18. Implement exception handling in a Java program to catch the "InvalidAgeException" and display an error message

 class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

 public class Main {
     public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        int age = 15;  
        try {
            validateAge(age);
            System.out.println("Age is valid.");  
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

8.Implement exception handling in a Java program that reads data from a file. If the file does not exist, throw a "FileNotFoundException" and display an error message to the user.


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
 
        String filePath = "path/to/your/file.txt";

        try {
            
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }

 
            scanner.close();
        } catch (FileNotFoundException e) {
             
            System.out.println("Error: File not found.");
            e.printStackTrace();  
        }
    }
}


