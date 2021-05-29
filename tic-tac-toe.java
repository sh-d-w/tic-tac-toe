import java.util.*;

public class Main
{
    //1. add board array and initialise to 0
    //2. print board to terminal
    //3. gather user inputs
    //4. check win condition
    //5. put in infinite loop

    public static int[][] board = new int[3][3];
    public static int col, row;
    public static int player;
    public static String[] players;

    public static void  print_board() {
        System.out.println("-------------");
        for (int row = 0; row < board.length; row++) {
	        for (int col = 0; col < board[row].length; col++) {
                System.out.print("| ");
    	        if (board[row][col] == 0)
                    System.out.print(" ");
                else if (board[row][col] == 1)
                    System.out.print("X");
                else if (board[row][col] == 2)
                    System.out.print("O");
                System.out.print(" ");
	        }
            System.out.println("|");
	        System.out.println("-------------");
        }
    }

    public static void  init_board() {
        for (int row = 0; row < board.length; row++)
	        for (int col = 0; col < board[row].length; col++)
    	        board[row][col] = 0;
    }

	public static void main(String[] args) {
        String l_row;
        String l_col;

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  

        player = 1;
        players = new String[] { "X","O" };
        init_board();
		print_board();
        System.out.print("Player " + players[player - 1] + ", please enter a row (0, 1 or 2): ");  
        l_row = sc.nextLine();              //reads string   
        System.out.print("Player " + players[player - 1] + ", please enter a column (0, 1 or 2): ");  
        l_col = sc.nextLine();              //reads string   

        row = Integer.parseInt(l_row);
        col = Integer.parseInt(l_col);

        System.out.println("Hello world!" + l_col + " " + l_row);  

	}
}
