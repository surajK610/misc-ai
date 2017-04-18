/**
 * Created by suraj on 4/15/17.
 */
import java.util.*;
public class Tic_Tac_Toe {

    public char[] board = new char[9];
    char player1 = 'X';
    char player2 = 'O';


    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        Tic_Tac_Toe board = new Tic_Tac_Toe();

        boolean won = false;

        while(!won)
        {
            System.out.println(board);
            System.out.println("Player1, what is your move(1-9)?");
            int move1 = scan.nextInt();
            board.addMove(move1 - 1, 1);
            if (board.checkIfWon() != 10){
                won = true;
                break;
            }


            System.out.println(board);
            System.out.println("Player2, what is your move(1-9)?");
            int move2 = scan.nextInt();
            board.addMove(move2 - 1, 2);
            if (board.checkIfWon() != 10)
            {
                won = true;
            }
        }
             System.out.println(board);

            if(board.checkIfWon() == 1)
                System.out.println("X wins!");
            else if(board.checkIfWon() == -1)
                System.out.println("O wins!");
            else
                System.out.println("It is a draw.");



    }

    public int checkIfWon()
    {
        String boardS = getString();
        boolean Xwin = false;
        boolean Owin = false;

        for (int i = 0; i < 7; i+=3) {
            Xwin = (checkRowCol(board[i], board[i+1], board[i+2]) && board[0] == 'X');
            if (Xwin) break;
        }
        if (!Xwin)
        {
            for (int i = 0; i < 3; i++) {
                Xwin = (checkRowCol(board[i], board[i + 3], board[i + 6]) && board[0] == 'X');
                if (Xwin) break;
            }
        }
        if (!Xwin)
        {
            Xwin = (checkRowCol(board[0], board[4], board[8]) && board[0] == 'X');
        }
        if (!Xwin)
        {
            Xwin = (checkRowCol(board[2], board[4], board[6]) && board[2] == 'X');
        }

        if (Xwin)
            return 1;

        for (int i = 0; i < 7; i+=3) {
            Owin = (checkRowCol(board[i], board[i+1], board[i+2]));
            if (Owin) break;
        }
        if (!Owin)
        {
            for (int i = 0; i < 3; i++) {
                Owin = checkRowCol(board[i], board[i + 3], board[i + 6]);
                if (Owin) break;
            }
        }
        if (!Owin)
        {
            Owin = checkRowCol(board[0], board[4], board[8]);
        }
        if (!Owin)
        {
            Owin = checkRowCol(board[2], board[4], board[6]);
        }
        if (Owin)
            return -1;

        char zero = (char)0;
        String z = "";
        z += zero;
        if(!boardS.contains(z))
            return 0;

        return 10;

    }

    private boolean checkRowCol(char c1, char c2, char c3)
    {
        return ((c1 != 0) && (c1 == c2) && (c2 == c3));
    }


    public void addMove(int loc, int player)
    {
        Scanner scan = new Scanner(System.in);
        if(board[loc] == 0)
        {
            if (player == 1)
                board[loc] = player1;
            else if (player == 2)
                board[loc] = player2;
        }
        else
        {
            System.out.println("Invalid Input");

            System.out.println("What is your move(1-9)?");
            int move1 = scan.nextInt();
            addMove(move1 - 1, player);
        }
    }


    public String getString()
    {
        String result = "";
        for(int i = 0; i < board.length; i ++)
            result += board[i];
        return result;
    }

    public String toString()
    {
        String result = "";
        for(int i = 0; i < board.length; i ++)
        {
            if (i > 0 && i % 3 ==0)
                result += "|\n|";
            else if(i % 3 == 0)
                result += "|";
            result += board[i] + " ";
        }
        result += "|";
        return result;
    }

}

 /*   If the game is over, return the score from X's perspective.
        Otherwise get a list of new game states for every possible move
        Create a scores list
        For each of these states add the minimax result of that state to the scores list
        If it's X's turn, return the maximum score from the scores list
        If it's O's turn, return the minimum score from the scores list */