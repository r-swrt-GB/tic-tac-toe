import java.util.Scanner;

public class TickTackToe
{
    
    
    public String displayGrid(String[] playedMoves)
    {
        String[] gridFramework = {"      _1_ _2_ _3_","A -> |_" + playedMoves[0] + "_|_" + playedMoves[1] + "_|_" + playedMoves[2] + "_|","B -> |_" + playedMoves[3] + "_|_" + playedMoves[4] + "_|_" + playedMoves[5] + "_|","C -> |_" + playedMoves[6] + "_|_" + playedMoves[7] + "_|_" + playedMoves[8] + "_|"};
        String contructedGrid = gridFramework[0] + "\n" + gridFramework[1] + "\n" + gridFramework[2] + "\n" + gridFramework[3];
        return contructedGrid;
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
        
        randomHeadsOrTails = (int) (Math.random() * 2);
        
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
    
    public static void main (String[] args)
    {
        TickTackToe tickTacToe = new TickTackToe();
        String[] playedMoves = {"_","_","_","_","_","_","_","_","_"};
        String grid;
        boolean userTurn = false;
        Scanner scanner = new Scanner(System.in);
        
        grid = tickTacToe.displayGrid(playedMoves);
                
        System.out.println("Welcome to Tic-Tac-Toe!!!");
        System.out.println("\nInstructions: " + "\nWhen prompted, enter the letter of the row followed by the number of the column: B2");
        System.out.println("GAME TIME!!!");
        System.out.println("\n" + grid);
        
        userTurn = tickTacToe.flipCoin();
                
        
                              
                              
    }
}
