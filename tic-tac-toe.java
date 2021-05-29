import java.util.*;

public class Main
{
    //1. add board array and initialise to 0
    //2. print board to terminal
    //3. gather user inputs
    //4. create infinite game loop
    //5. check win condition

    public static int[][] board = new int[3][3];
    public static int col, row;
    public static int player;
    public static String[] players;
    public static int game_state;

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

    public static int   check_draw() {
        int players_draw = 1;

        for (int row = 0; row < board.length; row++) 
	        for (int col = 0; col < board[row].length; col++) 
	            if (board[row][col] == 0)
	                players_draw = 0;
        return (players_draw);
    }
    public static int   check_win(int p_player) {
        int player_won = 0;
        // loop horizontally
        for (int row = 0; row < board.length; row++)
            if (board[row][0] == p_player && board[row][1] == p_player && board[row][2] == p_player)
                return (1);
        // loop vertically
        for (int col = 0; col < board.length; col++)
            if (board[0][col] == p_player && board[1][col] == p_player && board[2][col] == p_player)
                return (1);
        // check diagnally
        if (board[0][0] == p_player && board[1][1] == p_player && board[2][2] == p_player)
            return (1);
        if (board[0][2] == p_player && board[1][1] == p_player && board[2][0] == p_player)
            return (1);
        return (player_won);
    }
    public static int  win_condition() {
        // check for win loss else is a draw if all filled
        if (check_win(1) == 1)
            return (1);
        if (check_win(2) == 1)
            return (2);
        if (check_draw() == 1)
            return (3);
        return (0);
    }

	public static void main(String[] args) {
        String l_row;
        String l_col;

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  

        player = 1;
        players = new String[] { "X","O" };
        game_state = 0;// 0:continue    1:player X win  2:player O win  3:draw
        init_board();

        while (game_state == 0) {
            print_board();
            System.out.print("Player " + players[player - 1] + ", please enter a row (0, 1 or 2): ");  
            l_row = sc.nextLine();              //reads string   
            System.out.print("Player " + players[player - 1] + ", please enter a column (0, 1 or 2): ");  
            l_col = sc.nextLine();              //reads string   

            row = Integer.parseInt(l_row);
            col = Integer.parseInt(l_col);
            if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
                if (board[row][col] == 0) {
                    board[row][col] = player;
                    player += 1;
                    if (player == 3)
                        player = 1;
                }
            }
            game_state = win_condition();
        }
        if (game_state == 1)
                System.out.println("player X wins!");
        if (game_state == 2)
                System.out.println("player O wins!");
        if (game_state == 3)
                System.out.println("draw!");

	}
}
