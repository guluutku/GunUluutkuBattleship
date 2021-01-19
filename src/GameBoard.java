import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Game can only be used in console
public class GameBoard {

    public GameBoard(int ID, int score){

        int gScore = score;
        int gameBoardLength = 1;
        char water = '-';
        char ship = 'S';
        char hit = '+';
        char miss = '0';
        int shipNumber = 1;
        int undetectedShipNumber = shipNumber;

        char[][] gameBoard = createGameBoard(gameBoardLength, water, ship, shipNumber);

        // calls print method
        printGameBoard(gameBoard, water, ship);

        // loops game until all of the ships found
        while (undetectedShipNumber > 0){
            int[] guessCoordinate = getUserCoordinates(gameBoardLength);
            char locationViewUpdate = evaluateGuessAndGetTheTarget(guessCoordinate, gameBoard, ship, water, hit, miss);

            // if user hit the target take out an unknown ship from the list
            if (locationViewUpdate == hit){
                undetectedShipNumber--;
                //when all ships found exit from the system
                if (undetectedShipNumber == 0){
                    gScore++;
                    System.out.println("Won the Game!");
                    new DB_Connection().updateScore(ID, score);
                    System.exit(0);
                }
            }

            gameBoard = updateGameBoard(gameBoard, guessCoordinate, locationViewUpdate);
            printGameBoard(gameBoard, water, ship);
        }

    }

    //updates game board when user gives a value
    private static char[][] updateGameBoard(char[][] gameBoard, int[] guessCoordinate, char locationViewUpdate) {

        int row = guessCoordinate[0];
        int col = guessCoordinate[1];

        gameBoard[row][col] = locationViewUpdate;

        return  gameBoard;

    }

    // acts from the given coordinates by user
    private static char evaluateGuessAndGetTheTarget(int[] guessCoordinate, char[][] gameBoard, char ship, char water, char hit, char miss) {

        int row = guessCoordinate[0];
        int col = guessCoordinate[1];
        char target = gameBoard[row][col];
        String message;

        if (target == ship){
            message = "Hit!";
            target = hit;
        } else if (target == water){
            message = "Missed!";
            target = miss;
        } else {
            message = "Already Hit!";
        }

        System.out.println(message);
        return  target;

    }

    // get coordinates from user
    private static int[] getUserCoordinates(int gameBoardLength) {

        int row;
        int col;

        do {
            System.out.print("Row: ");
            row = new Scanner(System.in).nextInt();
        } while (row < 0 || row > gameBoardLength + 1);

        do {
            System.out.println("Column: ");
            col = new Scanner(System.in).nextInt();
        } while (col < 0 || col > gameBoardLength + 1);

        return new int[]{row - 1, col - 1};

    }

    // prints game board
    private static void printGameBoard(char[][] gameBoard, char water, char ship) {

        int gameBoardLength = gameBoard.length;

        System.out.print("   ");

        for(int i = 0; i < gameBoardLength; i++){
            System.out.print(i + 1 + "  ");
        }

        System.out.println();
        for(int row = 0; row < gameBoardLength; row++){

            if(row==9){
                System.out.print(row + 1 + " ");
            } else{
                System.out.print(row + 1 + "  ");

            }

            for (int column = 0; column < gameBoardLength; column++){
                char position = gameBoard[row][column];

                if (position == ship){
                    System.out.print(water + "  ");
                } else {
                    System.out.print(position + "  ");
                }
            }

            System.out.println();
        }

        System.out.println();

    }

    // creates game board
    private static char[][] createGameBoard(int gameBoardLength, char water, char ship, int shipNumber){

        char[][] gameBoard = new char[gameBoardLength][gameBoardLength];

        for(char[] row : gameBoard){
            Arrays.fill(row, water);
        }

        return placeShips(gameBoard, shipNumber, water, ship);
    }

    // places ships to the game board
    private static char[][] placeShips(char[][] gameBoard, int shipNumber, char water, char ship) {

        int placedShips = 0;
        int gameBoardLength = gameBoard.length;

        while(placedShips < shipNumber){
            int[] location = generateShipCoordinates(gameBoardLength);
            char possiblePlacement = gameBoard[location[0]][location[1]];

            if(possiblePlacement == water){
                gameBoard[0][location[1]] = ship;
                placedShips++;
            }
        }

        return gameBoard;

    }

    // generates coordinates for the ships that placed
    private static int[] generateShipCoordinates(int gameBoardLength) {

        int[] coordinates = new int[2];

        for (int i = 0; i < coordinates.length; i++){
            coordinates[i] = new Random().nextInt(gameBoardLength);
        }
        return coordinates;

    }

}
