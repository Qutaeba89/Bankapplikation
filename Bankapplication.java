import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bankapplication {

    public static void main(String[] args) {
        /**
         * Jag användade här double för att man kan sätta in 0.5 eller 2.5 kr till example då trorr jag är det viktig.
         * choice var det int bara för att user ska inmäta bara 1 eller 2 inte 2.4
         */

        Scanner input = new Scanner(System.in);
        int choice;
        double saldo = 0;
        double pengar;

        /**
         * 
         * Här ropade methods meny
         * 
         */
        List<String> meny = menyVal(); // Create the menu once


        /** 
         * Här skapade while loop för kolla user inmätning och kolla om inmäting är stämmar med if och else.
         * jag använded for för att loopa meny varje gång första i är number den ändra är meny lista .
         * anändade jag här också if och esle för att jag kan använda mer än ett conditon i if .
         * 
         */
        while (true) {

            System.out.print("Välj ett alternativ (1-4): \n");

            for (int i = 0; i < meny.size(); i++) {
                System.out.println((i + 1) + ". " + meny.get(i));
            }
            
            System.out.println("Här är menyn, vad vill du göra:");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // Consume newline
            } else {
                System.out.println("Ogiltig inmatning. Vänligen ange ett giltigt nummer.");
                input.next(); // Clear the invalid input
                continue;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Ogiltigt val, välj ett alternativ från menyn.");
                continue;
            }
/**
 * Här användade jag switch för att jag ropa meny med 1 , 2, 3 ,4.
 * switch är bra och enkelt att läsa om någn annan ska läsa kode.
 * switch ta bara ett condition 
 */
            switch (choice) {
                case 1:
                    System.out.println("Här är saldo på ditt konto " + saldo + "kr\n");
                    break;
                case 2:
                    System.out.println("Hur mycket pengar ska du sätta in? ");
                    if (input.hasNextDouble()) {
                        pengar = input.nextDouble();
                        saldo += pengar;
                    } else {
                        System.out.println("Ogiltig inmatning. Vänligen ange ett giltigt nummer.");
                        input.next(); // Clear the invalid input
                    }
                    break;
                case 3:
                    System.out.println("Hur mycket pengar vill du ta ut? ");
                    if (input.hasNextDouble()) {
                        pengar = input.nextDouble();
                        if (saldo - pengar < 0) {
                            System.out.println("Det finns inte tillräckligt med pengar för att göra valt uttag.");
                        } else {
                            saldo -= pengar;
                        }
                    } else {
                        System.out.println("Ogiltig inmatning. Vänligen ange ett giltigt nummer.");
                        input.next(); // Clear the invalid input
                    }
                    break;
                case 4:
                    System.out.println("Programmet avslutas");
                    input.close();
                    return; // Exit the program
            }
        }
    }
    /**
     * 
     * @return
     */

    public static List<String> menyVal() {
        List<String> meny = new ArrayList<>();
        meny.add("Se saldo");
        meny.add("Sätt in pengar");
        meny.add("Ta ut pengar");
        meny.add("Avsluta\n");
        return meny;
    }
    /**
     * Här en method som skafa meny 
     */
}