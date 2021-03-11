import java.util.Scanner;

public class Battleship {
    private static final int MAX_TILES = 5;
    private static Scanner input;
    public static void main(String[] args) {
        
        int[][][] field = new int[5][2][2];
        String[][][] board = new String[5][5][2];
        //String result = "not found";
        input = new Scanner(System.in);
        System.out.println("Welcome To Battleship!");
        
        for (int player = 0; player <= 1; player++) {
            for (int i = 0; i < MAX_TILES; i++) {
                System.out.printf("Player " + (player + 1) + "> Insert the position for your #" + (i + 1) + " ship: ");
                field[i][0][player] = input.nextInt();
                field[i][1][player] = input.nextInt();
                if (field[i][0][player] < 1 | field[i][0][player] > 5 | field[i][1][player] < 1 | field[i][1][player] > 5) {
                    System.out.println("You inserted a invalid position. Values must be integers between 1 and 5.");
                    i--;
                }
                for (int j = 0; j < i; j++) {
                    if (field[j][0][player] == field[i][0][player] & field[j][1][player] == field[i][1][player]) {
                        System.out.println("This position is already taken by another ship! Please resubmit a valid location.");
                        i--;
                    }
                }
                board[field[i][0][player] - 1][field[i][1][player] - 1][player] = "@";
            }

            for (int i = 0; i < MAX_TILES; i++) {
                System.out.printf("Your ship number #"+ (i+1) + " is in ("+ field[i][0][player] + "," + field[i][1][player] + ").\n");
            }

            for (int i = 0; i < MAX_TILES; i++) {
                for (int j = 0; j < MAX_TILES; j++) {
                        if (board[i][j][player] != "@") {
                            board[i][j][player] = "-";
                        }
                    System.out.print(board[i][j][player]);
                }
                System.out.println();
            }
            passTurn(input);
        }
        System.out.println("Game will now begin!");

        int turn = 0;
        int count[] = new int[2];
        while (turn >= 0) {

            drawBoard((turn % 2), board);

            if(hitOrMiss((turn % 2), board)) {
                count[(turn % 2)]++;
            }
            drawBoard((turn % 2), board);

            if (count[(turn % 2)] == 5) {
                System.out.printf("\nPLAYER " + ((turn % 2) + 1) + " WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n");
                return;
            }

            System.out.printf("End of turn " + (turn + 1) + ".\n");
            turn++;
            passTurn(input);
        }
    }


    public static boolean hitOrMiss(int player, String[][][] gameBoard) {
        int opponent, x, y;
        opponent = (player + 1) % 2; 

        do {
            System.out.printf("Player " + (player + 1) + "> Insert a valid position for your attack:");
            x = input.nextInt() - 1;
            y = input.nextInt() - 1;
        } while (x < 0 |  x > 4 | y < 0 | y > 4);

        while (gameBoard[x][y][opponent] == "X" | gameBoard[x][y][opponent] == "O") {
            System.out.printf("Player " + (player + 1) + "> You have already attacked this location. Insert another postion to attack:");
            x = input.nextInt() - 1;
            y = input.nextInt() - 1;
        }

        if (gameBoard[x][y][opponent] == "@") {
            System.out.println("PLAYER " + (player + 1) + " HIT PLAYER " + (opponent + 1) + "'s SHIP!");
            gameBoard[x][y][opponent] = "X";
            return true;
        }
        System.out.println("PLAYER " + (player + 1) + " MISSED!");
        gameBoard[x][y][opponent] = "O";
        return false;
    }

    public static void drawBoard(int player, String[][][] gameBoard) {
        int opponent = (player + 1) % 2;
        for (int i = 0; i < MAX_TILES; i++) {
            for (int j = 0; j < MAX_TILES; j++) {
                if (gameBoard[i][j][opponent] == "@") {
                    System.out.print("-");
                }
                else {
                    System.out.printf(gameBoard[i][j][opponent]);
                }
            }
            System.out.println();
        }
        System.out.println("#####");
        for (int i = 0; i < MAX_TILES; i++) {
            for (int j = 0; j < MAX_TILES; j++) {
                    System.out.printf(gameBoard[i][j][player]);
                }
                System.out.println();
            }
        System.out.println();
    }

    public static void passTurn(Scanner input) {
        input.nextLine();
        System.out.print("Press Enter to pass your turn to the other player:");
        input.nextLine();
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}