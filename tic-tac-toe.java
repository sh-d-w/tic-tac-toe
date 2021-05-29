import java.util.*;

public class Main
{
    //1. add board array and initialise to 0
    //2. print board to terminal
    //3. gather user inputs
    //4. check win condition
    //5. put in infinite loop

    public static int[][] board = new int[3][3];

    public static void  init_board() {
        for (int row = 0; row < board.length; row++)
	        for (int col = 0; col < board[row].length; col++)
    	        board[row][col] = 0;
    }

	public static void main(String[] args) {

        init_board();

        System.out.println("Hello world!");  

	}
}
