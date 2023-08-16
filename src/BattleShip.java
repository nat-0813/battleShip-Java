import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//MAIN METHOD
public class BattleShip {
    public static void main(String[] args) {
        //CONFIG
        int gameBoardLength = 4;
        char water = '-';
        char ship = 's';
        char hit = 'X';
        char miss = 'O';
        int shipNumber = 3;

// CREATE BOARD
        char [][] gameBoard = createGameBoard (gameBoardLength, water, ship, shipNumber);

        //PRINT INITIAL BOARD
        printGameBoard(gameBoard, water, ship);

        //PLAY GAME
        int undetectedShipNumber = shipNumber;
        while(undetectedShipNumber > 0) {
            //GET GUESS
            int[] guessCoordinates = getUserCoordinates(gameBoardLength);
            //CHECK GUESS
            char locationViewUpdate = evaluateGuessAndGetTheTarget(guessCoordinates, gameBoard, ship, water, hit, miss);

            //UPDATE BOARD
            if (locationViewUpdate == hit) {
                undetectedShipNumber--;
            }
            gameBoard = updateGameBoard(gameBoard, guessCoordinates, locationViewUpdate);

            //PRINT BOARD
            printGameBoard(gameBoard, water, ship);
        }
        //END GAME
        System.out.println("You won!");
    }
    // UPDATE BOARD METHOD

    private static char[][] updateGameBoard(char[][] gameBoard, int[] guessCoordinates, char locationViewUpdate) {
        // Get guess row and col
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];

        // Update game board with guess result
        gameBoard[row][col] = locationViewUpdate;
        return gameBoard;
    }

    // EVALUATE GUESS METHOD
    private static char evaluateGuessAndGetTheTarget(int[] guessCoordinates, char[][] gameBoard, char ship, char water, char hit, char miss) {
        // Check guess and return result
        String message;
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];

        char target = gameBoard[row][col];
        if (target == ship) {
            message = "Hit!";
            target = hit;
        } else if (target == water) {
            message = "Miss!";
            target = miss;
        } else {
            message = "Already hit!";
        }
        System.out.println(message);
        return target;
    }
    // GET COORDINATES METHOD
    private static int[] getUserCoordinates(int gameBoardLength) {
        // Get row and col from user
        int row;
        int col;
        do {
            System.out.print("Row: ");
            row = new Scanner(System.in).nextInt();
        } while (row < 0 || row > gameBoardLength + 1);

        do {
            System.out.print("Column: ");
            col = new Scanner(System.in).nextInt();
        } while (col < 0 || col > gameBoardLength + 1);
        return new int[]{row - 1, col - 1};
    }
    // PRINT BOARD METHOD
    private static void printGameBoard(char[][] gameBoard, char water, char ship) {
        // Print current board state
        int gameBoardLength = gameBoard.length;
        System.out.print("  ");
        for (int i = 0; i < gameBoardLength; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int row = 0; row < gameBoardLength; row++) {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < gameBoardLength; col++) {
                char position = gameBoard[row][col];
                if (position == ship) {
                    System.out.print(water + " ");
                } else {
                    System.out.print(position + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    // CREATE BOARD METHOD
    private static char[][] createGameBoard(int gameBoardLength, char water, char ship, int shipNumber) {
        // Generate initial empty board
        char[][] gameBoard = new char [gameBoardLength][gameBoardLength];
        for (char [] row : gameBoard) {
            Arrays.fill(row, water);
            // Place random ships
        }

        return placeShips(gameBoard, shipNumber, water, ship);
    }
    // PLACE SHIPS METHOD
    private static char[][] placeShips(char[][] gameBoard, int shipNumber, char water, char ship) {
        // Randomly place ships on board
        int placedShips = 0;
        int gameBoardLength = gameBoard.length;
        while (placedShips < shipNumber) {
            int[] location = generateShipCoordinates(gameBoardLength);
            char possiblePlacement = gameBoard[location[0]][location [1]];
            if (possiblePlacement == water) {
                gameBoard[location[0]][location [1]] = ship;
                placedShips++;
            }
        }

        return gameBoard;
    }
    // GENERATE COORDINATES METHOD
    private static int[] generateShipCoordinates(int gameBoardLength) {
        // Generate random row and col
        int [] coordinates = new int[2];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = new Random().nextInt(gameBoardLength);
        }
        return coordinates;

    }
}
