import java.util.Scanner;

public class TicTacToe
{
    
    
    public void displayGrid(String[] playedMoves)
    {
        String[] gridFramework = {"      _1_ _2_ _3_","A -> |_" + playedMoves[0] + "_|_" + playedMoves[1] + "_|_" + playedMoves[2] + "_|","B -> |_" + playedMoves[3] + "_|_" + playedMoves[4] + "_|_" + playedMoves[5] + "_|","C -> |_" + playedMoves[6] + "_|_" + playedMoves[7] + "_|_" + playedMoves[8] + "_|"};
        String contructedGrid = gridFramework[0] + "\n" + gridFramework[1] + "\n" + gridFramework[2] + "\n" + gridFramework[3];
        System.out.println(contructedGrid);
    }
    
    public boolean flipCoin()
    {
        Scanner scan = new Scanner(System.in);
        String headsOrTails = "";
        int userHTChoice = -1;
        int randomHeadsOrTails;
        
        System.out.print("\n" + "Heads or Tails (h/t): ");
        headsOrTails = (scan.nextLine()).toUpperCase();
        
       
        
        while (!headsOrTails.equals("H") && !headsOrTails.equals("T"))
            {
                System.out.println("Invalid selection. Please try again.");
                System.out.print("\n" + "Heads or Tails (h/t): ");
                headsOrTails = scan.nextLine();
            }
        
        switch (headsOrTails.toUpperCase())
        {
            case ("H"):
                {
                        userHTChoice = 1;
                        break;
                }
            
            case ("T"):
                {
                        userHTChoice = 0;
                        break;
                }
        }
        
        randomHeadsOrTails = (int)(Math.random() * 2);
        
        if (randomHeadsOrTails == userHTChoice)
        {
            System.out.println("You won the toss! (:");
            return true;
        }
        else
        {
            System.out.println("You lost the toss! :(");
            return false;
        }
    }
    
    public int validateValue(String entryValue)
    {
        Scanner scan = new Scanner(System.in);
        int newValue = -1;
        
        while (entryValue.length() != 2)
            {
                System.out.println("\nInvalid coordinates");
                System.out.print("Enter coordinates (e.g. B1): ");
                entryValue = (scan.nextLine()).toUpperCase();
            }
        

        while (!(entryValue.charAt(0) == 'A') && !(entryValue.charAt(0) == 'B') && !(entryValue.charAt(0) == 'C'))
            {
                System.out.println("\nInvalid coordinates");
                System.out.print("Enter coordinates (e.g. B2): ");
                entryValue = (scan.nextLine()).toUpperCase();
            }

        while (!(entryValue.charAt(1) == '1') && !(entryValue.charAt(1) == '2') && !(entryValue.charAt(1) == '3'))
            {
                System.out.println("\nInvalid coordinates");
                System.out.print("Enter coordinates (e.g. B3): ");
                entryValue = (scan.nextLine()).toUpperCase();
            }
        
        switch (entryValue)
            {
                case "A1":
                {
                    newValue = 0;
                    break;
                }
                    
                case "A2":
                {
                    newValue = 1;
                    break;
                }
                    
                case "A3":
                {
                    newValue = 2;
                    break;
                }
                    
                case "B1":
                {
                    newValue = 3;
                    break;
                }
                    
                case "B2":
                {
                    newValue = 4;
                    break;
                }
                    
                case "B3":
                {
                    newValue = 5;
                    break;
                }
                    
                case "C1":
                {
                    newValue = 6;
                    break;
                }
                    
                case "C2":
                {
                    newValue = 7;
                    break;
                }
                    
                case "C3":
                {
                    newValue = 8;
                    break;
                }
            }
        
        return newValue;
    }
    
    public String[] userPlay(String[] playedMoves, String playerCharacter)
    {
        Scanner scan = new Scanner(System.in);
        int entryValue = -1;
        
        System.out.print("Enter coordinates (e.g. A1): ");
        String userCoordinates = (scan.nextLine()).toUpperCase();
        
        entryValue = validateValue(userCoordinates);

                while (!(playedMoves[entryValue].equals("_")))
                    {
                        System.out.println("\nCoordinates already taken");
                        System.out.print("Enter new coordinates (e.g. A2): ");
                        userCoordinates = (scan.nextLine()).toUpperCase();
                        
                        entryValue = validateValue(userCoordinates);
                    }
        
        playedMoves[entryValue] = playerCharacter;
        
        return playedMoves;
    }
    
    public String[] computerPlay(String[] playedMoves, String playerCharacter)
    {
        int generatedValue = -1;
        
        while (generatedValue == -1)
            {
                generatedValue = (int)(Math.random() * 9);
                while (!playedMoves[generatedValue].equals("_"))
                    {
                        generatedValue = (int)(Math.random() * 9);
                    }
                playedMoves[generatedValue] = playerCharacter;
            }
        
        
        
        return playedMoves;
    }
    
    public static void main (String[] args)
    {
        TicTacToe ticTacToe = new TicTacToe();
        String[] playedMoves = {"_","_","_","_","_","_","_","_","_"};
        boolean userTurn = false;
        Scanner scanner = new Scanner(System.in);
        boolean winner = false;
                        
        System.out.println("Welcome to Tic-Tac-Toe!!!");
        System.out.println("\nInstructions: " + "\nWhen prompted, enter the letter of the row followed by the number of the column: B2");
        System.out.println("GAME TIME!!!");
        
        ticTacToe.displayGrid(playedMoves);
        
        userTurn = ticTacToe.flipCoin();
                
        while (winner == false)
            {
                if (userTurn)
                    {
                      playedMoves = ticTacToe.userPlay(playedMoves, "X");
                    } else
                        {
                            playedMoves = ticTacToe.computerPlay(playedMoves, "O");
                        }
                userTurn = !userTurn;
                ticTacToe.displayGrid(playedMoves);
            }
                              
                              
    }
}
