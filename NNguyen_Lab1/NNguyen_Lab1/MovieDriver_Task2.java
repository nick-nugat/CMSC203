import java.util.Scanner;

public class MovieDriver_Task2 {
    public static void main(String[] args) {
        String title, rating, con;
        int ticketsSold;
        Scanner input = new Scanner(System.in);
        Movie m1 = new Movie();

        do {
            System.out.println("Please enter the title of a movie:");
            title = input.nextLine();
            m1.setTitle(title);
            System.out.println("Please enter the rating of the movie:");
            rating = input.nextLine();
            m1.setRating(rating);
            System.out.println("Please enter the number of tickets sold for this movie:");
            ticketsSold = input.nextInt();
            m1.setSoldTickets(ticketsSold);
            input.nextLine();
            System.out.println("Do you want to enter another movie? (y or n)");
            con = input.nextLine();
            if (con.equalsIgnoreCase("n")) break;
        } while (con.equalsIgnoreCase("y"));
        
        input.close();
        System.out.println(m1.toString());

    }    
}
