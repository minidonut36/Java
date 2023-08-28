import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Die D6 = new Die();
        Die D12 = new Die(12);

        Scanner sc = new Scanner(System.in);

        while (! D6.isTwice(D12) && ! D12.isTwice(D6)){
            System.out.println("Press return");

            if (sc.nextLine().equals("")) {
                D6.roll();
                D12.roll();

                System.out.println("D6: " + D6 + " D12: " + D12);
            }
        }

        System.out.println("We have won, and the program ends");
    }
}