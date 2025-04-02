import java.util.Scanner;


public class numberto1 {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        int n;

        System.out.print("Enter a number: ");
        n = k.nextInt();

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
    System.out.println("N is = to 1!");
        k.close();
    }
    
}

