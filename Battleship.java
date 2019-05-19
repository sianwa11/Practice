
import java.util.Random;
import java.util.Scanner;

//2D array game
public class Battleship {
    
    public static Scanner input = new Scanner(System.in);
    public static Random rand = new Random();
    public static String ocean[][] = new String[10][10];
    
    public static int userShips = 0;
    public static int computerShips = 0;
    public static int playerChoose = 0;
    public static int computerChoose = 0;
    
    //main method
    public static void main(String args[]){
        intro();
        printMap(ocean);
        deployShips(ocean);
        compShips(ocean);
        printMap2(ocean);
        playersTurn(ocean);
        computersTurn(ocean);
        victoryRoyale(ocean);
    }
    
    //displays the introduction
    public static void intro(){
        System.out.print("\n***Welcome to Battleship***");
        System.out.print("\nRight now the sea is Empty");
    }
    
    //showa the empty ocean
    public static void printMap(String ocean[][]){
        System.out.println("\n 0123456789");
        for(int row = 0; row < ocean.length; row++){
            System.out.print(row + "|");
            for(int col = 0; col < ocean.length; col++){
                if(ocean[row][col] == null){
                    System.out.print(" ");
                } else {
                    System.out.print(ocean[row][col]);
                }
            }
            System.out.print("|" + row + "\n");
        }
        System.out.println("  0123456789  ");
        System.out.println("UserShips: " + userShips + "| ComputerShips: " + computerShips );
        System.out.println("\n................................"  );
        
        
    }
    
    //user inputs different coordinates and it displays in ocean as @
    public static void deployShips(String ocean[][]){
       while(userShips < 5) {
            System.out.print("Enter X coordinate for your ship: ");
            int row = input.nextInt();
            System.out.print("Enter Y coordinate for your ship: ");
            int col = input.nextInt();
            
            if (row > 9 || col > 9){
                System.out.print("You've exceeded the limit");
            } else if (ocean[row][col] != null){
                System.out.print("This slot has already been taken");
            } else {
                ocean[row][col] = "@";
                userShips++;
                
            }
                
            }
                
       }
    
    //prints the ocean a second time
    public static void printMap2(String ocean[][]){
        if(userShips == 5){
            printMap(ocean);
        }
        if(computerShips == 5){
            compShips(ocean);
        }
        
    }
    
    
    //computer randomly generates coordinates and are displayed as x in ocean
    public static void compShips(String ocean[][]){
        while(computerShips < 5) {
            System.out.print("Computer is deploying ships\n");
            System.out.println("ship DEPLOYED");
            int row = rand.nextInt(10);
            int col = rand.nextInt(10);
            
            if (row > 9 || col > 9) {
                System.out.print("Exceeded limit");
                row = rand.nextInt(10);
                col = rand.nextInt(10);
            } else if (ocean[row][col] != null){
                System.out.print("Slot has been occupied\n");
            } else {
                ocean[row][col] = "x";
                computerShips++;
            }
        }
    }
    
    //player tries to guess coordinates
    public static void playersTurn(String ocean[][]){
        System.out.print("YOUR TURN\n");
        
        while(playerChoose >= 0 && computerShips > 0 && userShips > 0){
            System.out.print("Enter X coordinate ship: ");
            int row = input.nextInt();

            System.out.print("Enter Y coordinate ship: ");
            int col = input.nextInt();

            if(row > 9 || col > 9){
                System.out.print("\nExceeded limit");
            } else if(ocean[row][col] == "x"){
                System.out.print("\nBoom! You sunk the ship!");
                ocean[row][col] = "!";
                computerShips--;
            } else if(ocean[row][col] == "@"){
                System.out.print("\nOh no, you sunk your own ship :(");
                ocean[row][col] = "x";
                userShips--;
            } else {
                System.out.print("\nSorry, you missed");
                ocean[row][col] = "-";
            }
            playerChoose++;
            printMap(ocean);
            computersTurn(ocean);
        }
    }
    
    //computer tries to guess the coordinates
    public static void computersTurn(String ocean[][]){
        while(computerChoose >= 0 && computerShips > 0 && userShips > 0) {
            System.out.println("COMPUTER'S TURN");
            int row = rand.nextInt(10);
            int col = rand.nextInt(10);
            
            if (row > 9 || col > 9) {
                System.out.print("Ecxceeded limit");
                row = rand.nextInt(10);
                col = rand.nextInt(10);
            } else if (ocean[row][col] == "@") {
                System.out.print("\nComputer sunk one of your ships");
                ocean[row][col] = "x";
                userShips--;
            } else if (ocean[row][col] == "x") {
                System.out.print("\nThe computer sunk one of its own shipas");
                ocean[row][col] = "!";
                computerShips--;
            } else if (ocean[row][col] != "x" || ocean[row][col] != "@") {
                System.out.print("\nComputer missed");
            }
            computerChoose++;
            printMap(ocean);
            playersTurn(ocean);
        }
        }
    
    public static void victoryRoyale(String ocean[][]){
        if(computerShips == 0){
            System.out.print("\nYOU WIN!!");
    }
        if(userShips == 0){
            System.out.print("\nCOMPUTER WINS!!");
        }
       
    }
}
    
        
    
    

