package src;

import src.Stone.Stone;
import src.Gemstone.*;
import src.SemiGemstone.*;
import src.Jewerly.Jewerly;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {
    public static int defaultMenu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these options:");
        System.out.println("0 - Quit");
        System.out.println("1 - Create a Jewerly");
        System.out.println("2 - Get list of all available gemstones");
        System.out.println("3 - Get list of all available semi-gemstones");
        System.out.print("Your choise: ");

        selection = input.nextInt();
        return selection;
    }

    public static int jewerlyEditMenu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these options:");
        System.out.println("1 - Sort jewerly by the value of its stones");
        System.out.println("2 - Get the names of all the stones in the jewerly that correspond to specific range of tranparency");
        System.out.println("3 - Get the names of all the stones in the jewerly");
        System.out.println("4 - Go to the main menu");
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
        
        String name = "";
        double mass = 0, cost = 0;
        int value = 0, transparency = 0;
        boolean isCorrect = false;
        
        while (! isCorrect) {
            System.out.print("Enter gemestone's name: ");
            name = inputName.next();
            try { 
                GemstonesNames.valueOf(name);
                isCorrect = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Sorry, this gemstone is currently now available.\n" +
                                   "All available gemstones: " + 
                                   "Diamond, " + 
                                   "Ruby, " + 
                                   "BlueSapphire, " +
                                   "Emerald");
                inputName.nextLine();
            }
        }

        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter gemestone's mass in carats: ");
            try {
                mass = inputMass.nextDouble();
                if (mass <= 0) {
                    throw new IllegalArgumentException();
                }
                isCorrect = true;
            }
            catch(InputMismatchException | IllegalArgumentException e) {
                System.out.println("Wrong mass, try again.");
                inputMass.nextLine();
            }
        }
        
        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter gemestone's cost in dollars: ");
            try {
                cost = inputCost.nextDouble();
                if (cost <= 0) {
                    throw new IllegalArgumentException();
                }
                isCorrect = true;
            }
            catch(InputMismatchException | IllegalArgumentException e) {
                System.out.println("Wrong cost, try again.");
                inputCost.nextLine();
            }
        }

        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter gemestone's value, which is an integer between 0 and 10: ");
            try {
                value = inputValue.nextInt();
                if (value < 0 || value > 10) {
                    throw new IllegalArgumentException();
                }
                isCorrect = true;
            }
            catch(InputMismatchException | IllegalArgumentException e) {
                System.out.println("Wrong value, try again.");
                inputValue.nextLine();
            }
        }
       
        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter gemestone's transparency, which is an integer which is an integer between 0 and 100: ");
            try {
                transparency = inputTransparency.nextInt();
                if (transparency < 0 || transparency > 100) {
                    throw new IllegalArgumentException();
                }
                isCorrect = true;
            }
            catch(InputMismatchException | IllegalArgumentException e) {
                System.out.println("Wrong transparency, try again.");
                inputTransparency.nextLine();
            }
        }

        Gemstone result = new Gemstone(name, mass, cost, value, transparency);
        return result;
    }

    public static SemiGemstone createSemiGemstone() {
        Scanner inputName = new Scanner(System.in);
        Scanner inputMass = new Scanner(System.in);
        Scanner inputCost = new Scanner(System.in);
        Scanner inputValue = new Scanner(System.in);
        Scanner inputTransparency = new Scanner(System.in);
        
        String name = "";
        double mass = 0, cost = 0;
        int value = 0, transparency = 0;
        boolean isCorrect = false;
        
        while (! isCorrect) {
            System.out.print("Enter semi-gemestone's name: ");
            name = inputName.next();
            try { 
                SemiGemstonesNames.valueOf(name);
                isCorrect = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Sorry, this semi-gemstone isn't currently" +
                                   " available.\nAll available semi-gemstones: " +
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
                inputName.nextLine();
            }
        }

        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter semi-gemestone's mass in carats: ");
            try {
                mass = inputMass.nextDouble();
                if (mass <= 0) {
                    throw new IllegalArgumentException();
                }
                isCorrect = true;
            }
            catch(InputMismatchException | IllegalArgumentException e) {
                System.out.println("Wrong mass, try again.");
                inputMass.nextLine();
            }
        }
        
        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter semi-gemestone's cost in dollars: ");
            try {
                cost = inputCost.nextDouble();
                if (cost <= 0) {
                    throw new IllegalArgumentException();
                }
                isCorrect = true;
            }
            catch(InputMismatchException | IllegalArgumentException e) {
                System.out.println("Wrong cost, try again.");
                inputCost.nextLine();
            }
        }

        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter semi-gemestone's value, which is an integer between 0 and 10: ");
            try {
                value = inputValue.nextInt();
                if (value < 0 || value > 10) {
                    throw new IllegalArgumentException();
                }
                isCorrect = true;
            }
            catch(InputMismatchException | IllegalArgumentException e) {
                System.out.println("Wrong value, try again.");
                inputValue.nextLine();
            }
        }
       
        isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter semi-gemestone's transparency, which is an integer which is an integer between 0 and 100: ");
            try {
                transparency = inputTransparency.nextInt();
                if (transparency < 0 || transparency > 100) {
                    throw new IllegalArgumentException();
                }
                isCorrect = true;
            }
            catch(InputMismatchException | IllegalArgumentException e) {
                System.out.println("Wrong transparency, try again.");
                inputTransparency.nextLine();
            }
        }

        SemiGemstone result = new SemiGemstone(name, mass, cost, value, transparency);
        return result;
    }

    public static Jewerly createJewerly() {
        Scanner inputBrand = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);

        System.out.print("Enter the name of the brand: ");
        String brand = inputBrand.next();
        int numberOfStones = 0;

        Stone[] stones = {};

        boolean isCorrect = false;
        while (! isCorrect) {
            System.out.print("Enter the number of stones in the jewerly: ");
            try {
                numberOfStones = inputNumber.nextInt();
                if (numberOfStones <= 0) {
                    throw new InputMismatchException();
                }
                isCorrect = true;
            }
            catch(InputMismatchException e) {
                System.out.println("Wrong number of stones. Try again.");
                inputNumber.nextLine();
            }
        }

        Scanner inputIsGemstone = new Scanner(System.in);
        String input;
        for (int i = 0; i < numberOfStones; i++) {
            System.out.print("Is it a Gemstone [y/n]: ");
            input = inputIsGemstone.next();
            Stone[] temp = new Stone[stones.length + 1];
            if (stones.length == 0) {
                if (!input.equals("n") && !input.equals("N") && 
                    !input.equals("No") && !input.equals("no")) {
                        stones = new Stone[] {createGemstone()};
                    }
                else {
                    stones = new Stone[] {createSemiGemstone()};
                }
            }
            else {
                for (int j = 0; j < stones.length; j++) {
                    temp[j] = stones[j];
                    if (!input.equals("n") && !input.equals("N") && 
                        !input.equals("No") && !input.equals("no")) {
                            temp[stones.length] = createGemstone();
                    }
                    else {
                        temp[stones.length] = createSemiGemstone();
                    }
                }
                stones = temp;
            }
        }
        return new Jewerly(stones, brand);
    }


    public static void main(String[] args) {
        Jewerly jewerly = null;
        int userChoice = defaultMenu();
        while (userChoice != 0) {
            if (jewerly == null) {  // if jewerly isn't initialized
                switch(userChoice) {
                    case 1:
                        jewerly = createJewerly();
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
                    case 0:
                        break;
                    default:
                        System.out.println("Wrong input. Try again");
                }
                if (jewerly == null) {
                    userChoice = defaultMenu();
                }
                else {
                    userChoice = jewerlyEditMenu();
                }
            }
            else {
                boolean isCorrect = false;
                Scanner input = new Scanner(System.in);
                int lboundary = 0, rboundary = 0;
                switch(userChoice) {
                    case 1:
                        System.out.println("Stones before sorting: " + Arrays.toString(jewerly.getStones()));
                        jewerly.sortStonesByValue();
                        System.out.println("Stones after sorting: " + Arrays.toString(jewerly.getStones()));
                        userChoice = jewerlyEditMenu();
                        break;
                    case 2:
                        isCorrect = false;
                        while (! isCorrect) {
                            System.out.print("Enter the left boundary of the range: ");
                            try {
                                lboundary = input.nextInt();
                                if (lboundary < 0 || lboundary > 100) {
                                    throw new IllegalArgumentException();
                                }
                                isCorrect = true;
                            }
                            catch(InputMismatchException | IllegalArgumentException e) {
                                System.out.println("Wrong value, try again.");
                                input.nextLine();
                            }
                        }
                        isCorrect = false;
                        input.nextLine();
                        while (! isCorrect) {
                            System.out.print("Enter the right boundary of the range: ");
                            try {
                                rboundary = input.nextInt();
                                if (rboundary < 0 || rboundary > 100 || rboundary < lboundary) {
                                    throw new IllegalArgumentException();
                                }
                                isCorrect = true;
                            }
                            catch(InputMismatchException | IllegalArgumentException e) {
                                System.out.println("Wrong value, try again.");
                                input.nextLine();
                            }
                        }
                        System.out.println(Arrays.toString(jewerly.getTransparentStones(lboundary, rboundary))); 
                        userChoice = jewerlyEditMenu();
                        break;
                    case 3:
                        System.out.println(Arrays.toString(jewerly.getStones())); 
                        userChoice = jewerlyEditMenu();
                        break;
                    case 4:
                        jewerly = null;
                        userChoice = defaultMenu();
                        break;
                    default:
                        System.out.println("Wrong input. Try again");
                        userChoice = jewerlyEditMenu();
                }
            }
        }
        System.out.println("Bye!");
    }
}
