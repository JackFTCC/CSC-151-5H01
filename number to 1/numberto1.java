import java.util.Scanner;


public class numberto1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        int n;
        int choice;

    do{
        System.out.print("Enter a number: ");
        n = k.nextInt();
        int nOriginal = n;

        do {
        if (n % 2 != 0){
            System.out.println(n + " * 3 + 1 = " + ((n*3)+1));
            n = (n*3) + 1;
        }
        else {
            System.out.println(n + " ÷ 2 = " + n/2);
            n = n/2;
        }
    } while(n != 1);
    System.out.println( "The number " + nOriginal + " has been equaled to 1!");
    System.out.println( "");
    System.out.println( "Would you like to run this again? 1 for yes 2 for no");
    choice = k.nextInt();
    }while(choice == 1);
    k.close();
    
}
    
}

