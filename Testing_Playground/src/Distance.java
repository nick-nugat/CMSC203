import java.util.Scanner;
public class Distance{
    public static void main(String[] args){
        int speed, time;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter vehicle speed (in mph): ");
        speed = input.nextInt();
        while (speed < 0){
            System.out.print("Enter vehicle speed (in mph): ");
            speed = input.nextInt();
        }
        System.out.print("Enter traveling time (in hours): ");
        time = input.nextInt();
        while (time < 1){
            System.out.print("Enter traveling time (in hours): ");
            time = input.nextInt();
        }

        for (int i = 1; i <= time; i++){
            System.out.println("After " + i + " hour(s) the distance is " + speed * i + " miles.");
        }
    }
}