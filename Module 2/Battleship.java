import java.util.Scanner;

public class Battleship {
    private static Scanner input;

    public static void main(String[] args) {
        int[][] field;
        String result = "not found";
        int numberOfShips = 5;
        input = new Scanner(System.in);
        System.out.println("Welcome To Battleship!");
        for (int i = 0; i < numberOfShips; i++) {
            System.out.printf("Insert the position for your #%i ship:", i);
            if (input.nextInt() > 5) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
            field[i][0] = input.nextInt();
            field[i][1] = input.nextInt();
        }












        String selected = input.next().toUpperCase();
        for (String selection : operations) {
            if (selection.equals("A") || selection.equals("S") || selection.equals("M") || selection.equals("D") || selection.equals("P")) {
                result = "found";
                System.out.print("Operation found succesfully.");
                break;
            }
            else {
                System.out.print(selected + ">  Operation not found. Please insert a valid one.");
                break;
            }

        }
        if (result == "found") {
            double variable1;
            double variable2;
            String word1;
            String word2;
            if (selected.equals("A")) {
                System.out.print("\nType in the first element: ");
                variable1 = input.nextInt();
                System.out.print("Type in the second element: ");
                variable2 = input.nextInt();
                double sum = variable1 + variable2;
                System.out.print("The sum for the elements typed is: " + sum);
            }
            if (selected.equals("M")) {
                System.out.print("\nType in the first element: ");
                variable1 = input.nextInt();
                System.out.print("Type in the second element:");
                variable2 = input.nextInt();
                double multiply = variable1 * variable2;
                System.out.print("The multiplication for the elements typed is: " + multiply);
            }
            if (selected.equals("S")) {
                System.out.print("\nType in the first element: ");
                variable1 = input.nextInt();
                System.out.print("Type in the second element:");
                variable2 = input.nextInt();
                double subtract = variable1 - variable2;
                System.out.print("The subtraction for the elements typed is: " + subtract);
            }
            if (selected.equals("D")) {
                System.out.print("\nType in the first element: ");
                variable1 = input.nextInt();
                System.out.print("Type in the second element:");
                variable2 = input.nextInt();
                if (variable2 == 0) {
                    System.out.print("This division can't be performed, since the dividend is 0.");
                }
                else {
                    double division = variable1 / variable2;
                    System.out.print("The division for the elements typed is: " + division);
                }
            }
            if (selected.equals("P")) {
                System.out.print("\nType in the first word: ");
                word1 = input.next();
                System.out.print("Type in the second word: ");
                word2 = input.next();
                if (word1.toLowerCase().compareTo(word2.toLowerCase()) == 0) {
                    System.out.print("The words are the same.");
                }
                else if (word1.toLowerCase().compareTo(word2.toLowerCase()) > 0) {
                    System.out.print(word1 + " is greater than " + word2);
                }
                else {
                    System.out.print(word1 + " is lesser than " + word2);
                }
            }        
        }
        else {
            System.out.print("\nYou did not submit a valid operation");
        }
    }
}
