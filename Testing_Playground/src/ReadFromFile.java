// Needed for the File class
import java.io.*;

/**

This program reads data from a file.

*/

public class ReadFromFile {
        public static void main(String[] args) throws IOException {
            // Scanner input = new Scanner(System.in);

            // System.out.println("Please enter the name of the file: " );
            // String fileName = input.nextLine();

            // File newFile = new File(fileName);
            // Scanner fileInput = new Scanner(newFile);

            // while (fileInput.hasNextLine())
            //             System.out.println(fileInput.nextLine());

            // fileInput.close();



            // System.out.print("Enter your name, last name, and age: ");
            // String contents = input.nextLine();
            // FileWriter writer = new FileWriter(newFile, true);
            // writer.write(" " + contents);

            // writer.close();
            // input.close();

            display();
            System.out.println();
            greeting("Nicholas Nguyen", 17);
            System.out.println(findInterestRate(-2, 2));
        }

        public static void display(){
            for (int i = 0; i < 10; i++)
                System.out.print("*");
        }

        public static void greeting(String name, int age){
            System.out.println("Hello " + name + ", you are " + age + " years old");
        }

        public static double findInterestRate(int year, double percentage){
            if (year < 0) return -1;
            else if (year < 1960) return 0.5;
            else if (year >= 1960 && year <= 2000) return 1.5;
            else return (2.5 - (2.5 * percentage/100));
        }
    }