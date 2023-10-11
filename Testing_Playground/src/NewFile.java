import java.util.Scanner;
public class SoftwareSales
{
    public static void main(String[] args)
    {
        String userInput;
        String userOutput;
        double packagePrice=99;
        int userNumberOfPackages;
        double discount;
        double subTotal;
        double total;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter number of packages purchased:");
        userNumberOfPackages = keyboard.nextInt();
        if(userNumberOfPackages<10)
        {
            subTotal=packagePrice*userNumberOfPackages;
            discount=0;
            total=subTotal-discount;
        }
        else if(userNumberOfPackages<20)
        {
            subTotal=packagePrice*userNumberOfPackages;
            discount=((double)20/100)*subTotal;
            total=subTotal-discount;
        }
        else if(userNumberOfPackages<50)
        {
            subTotal=packagePrice*userNumberOfPackages;
            discount=((double)30/100)*subTotal;
            total=subTotal-discount;
        }
        else if(userNumberOfPackages<100)
        {
            subTotal=packagePrice*userNumberOfPackages;
            discount=((double)40/100)*subTotal;
            total=subTotal-discount;
        }
        else
        {
            subTotal=packagePrice*userNumberOfPackages;
            discount=((double)50/100)*subTotal;
            total=subTotal-discount;
        }
        userOutput=String.format(" Your discount is: $%.2f\nYour total is: $%.2f\n", discount, total);
        System.out.print(userOutput);
}
}


