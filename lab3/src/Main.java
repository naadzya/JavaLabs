package src;

import src.Stone.Stone;
import src.Gemstone.Gemstone;
import src.SemiGemstone.SemiGemstone;
import src.Jewerly.Jewerly;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these options:");
        System.out.println("1 - Create a Jewerly");
        System.out.println("2 - Get list of all available gemstones");
        System.out.println("3 - Get list of all available semi-gemstones");
        System.out.println("4 - Quit");
        System.out.print("Your choise: ");

        selection = input.nextInt();
        return selection;
    }

    public static Gemstone createGemstone() {
        Scanner inputName = new Scanner(System.in);
        Scanner inputMass = new Scanner(System.in);
        Scanner inputCost = new Scanner(System.in);
        Scanner inputValue = new Scanner(System.in);
        Scanner inputTransparency = new Scanner(System.in);
        
        String name;
        double mass = 0, cost = 0;
        int value = 0, transparency = 0;

        System.out.print("Enter gemestone's name: ");
        name = inputName.next();

        boolean isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter gemestone's mass in carats: ");
            try {
                mass = inputMass.nextDouble();
                isCorrect = true;
            }
            catch(InputMismatchException e) {
                System.out.println("Wrong mass, try again.");
                inputMass.nextLine();
                isCorrect = false;
            }
        }
        
        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter gemestone's cost in dollars: ");
            try {
                cost = inputCost.nextDouble();
                isCorrect = true;
            }
            catch(InputMismatchException e) {
                System.out.println("Wrong cost, try again.");
                inputCost.nextLine();
                isCorrect = false;
            }
        }

        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter gemestone's value, which is an integer between 0 and 10: ");
            try {
                value = inputValue.nextInt();
                isCorrect = true;
            }
            catch(InputMismatchException e) {
                System.out.println("Wrong value, try again.");
                inputValue.nextLine();
                isCorrect = false;
            }
        }
       
        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter gemestone's transparency, which is an integer which is an integer between 0 and 100: ");
            try {
                transparency = inputTransparency.nextInt();
                isCorrect = true;
            }
            catch(InputMismatchException e) {
                System.out.println("Wrong transparency, try again.");
                inputTransparency.nextLine();
                isCorrect = false;
            }
        }

        Gemstone result = new Gemstone(name, mass, cost, value, transparency);
        return result;
    }

    public static void main(String[] args) {
        int userChoice = menu();
        while (userChoice != 4) {
            switch(userChoice) {
                case 1:
                    System.out.println(createGemstone().toString());
                    break;
                case 2:
                    System.out.println("All available gemstones: " + 
                                       "Diamond, " + 
                                       "Ruby, " + 
                                       "BlueSapphire, " +
                                       "Emerald");
                    break;
                case 3:
                    System.out.println("All available semi-gemstones: " + 
                                       "Alexandrite, " +
                                       "Agate, " +
                                       "Amethyst, " +
                                       "Aquamarine, " +
                                       "Garnet, " +
                                       "LapisLazuli, " +
                                       "Moonstone, " +
                                       "Opal, " +
                                       "Pearl, " +
                                       "Peridot, " +
                                       "RoseQuartz, " +
                                       "Spinel, " +
                                       "Tanzanite, " +
                                       "Tourmaline, " +
                                       "Turquoise, " +
                                       "Zircon"); 
                    break;
                default:
                    System.out.println("Wrong input. Try again");
            }
            
            System.out.println("-------------------------");
            userChoice = menu();
        }
        System.out.println("Bye!");
    }
}
