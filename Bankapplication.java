import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bankapplication {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        int saldo = 0;
        int pengar;

        while (true) {
            System.out.println("Här är menyn, vad vill du göra:");
            List<String> meny = new ArrayList<>();
            meny.add("Se saldo");
            meny.add("Sätt in pengar");
            meny.add("Ta ut pengar");
            meny.add("Avsluta\n");
    
            for (int i = 0; i < meny.size(); i++) {
                System.out.println((i + 1) + ". " + meny.get(i));
            }

            System.out.print("Välj ett alternativ (1-4): \n");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // Consume newline
            } else {
                System.out.println("Ogiltig inmatning. Vänligen ange ett giltigt nummer.");
                input.next(); // Clear the invalid input
                continue;
            }
    
            if (choice == 4) {
                System.out.println("Programmet avslutas");
                break;
            } else if (choice < 1 || choice > 4) {
                System.out.println("Ogiltigt val, välj ett alternativ från menyn.");
                continue;
            }

            if (choice == 1) {
                System.out.println("Här är saldo på ditt konto " + saldo + "kr\n");
            } else if (choice == 2) {
                System.out.println("Hur mycket pengar ska du sätta in? ");
                if (input.hasNextInt()) {
                    pengar = input.nextInt();
                    saldo += pengar;
                } else {
                    System.out.println("Ogiltig inmatning. Vänligen ange ett giltigt nummer.");
                    input.next(); // Clear the invalid input
                }
            } else if (choice == 3) {
                System.out.println("Hur mycket pengar vill du ta ut? ");
                if (input.hasNextInt()) {
                    pengar = input.nextInt();
                    if (saldo - pengar < 0) {
                        System.out.println("Det inte finns tillräckligt med pengar för att göra valt uttag.");
                    } else {
                        saldo -= pengar;
                    }
                } else {
                    System.out.println("Ogiltig inmatning. Vänligen ange ett giltigt nummer.");
                    input.next(); // Clear the invalid input
                }
            }
        }
        input.close();
    }
}  

