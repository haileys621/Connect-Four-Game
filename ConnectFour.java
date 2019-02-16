import java.util.Scanner;

public class ConnectFour {
  // Player 0 is Red; Player 1 is Yellow
  // Use the following arrays to get a label or checker letter for the player.
  static String colorLabelCaps[] = { "Red", "Yellow" };
  static String colorLabel[] = { "red", "yellow" };
  static char colorChar[] = { 'R', 'Y' };
  
  public static void main(String[] args) {
    int player = 0;  // Player 0 is red; Player 1 is yellow.  
    
    Board board = new Board();
    Scanner input = new Scanner(System.in);
    board.draw();
    
    while (board.checkWinner() == false && board.checkDraw() == false) {
      System.out.println("Drop a " + colorLabel[player] + " disk at column (0-6): ");
      int playerColumn = input.nextInt();
      
      while(playerColumn > 6 || playerColumn < 0){
        System.out.println("Invalid column input - input a new column (0-6)");
        playerColumn = input.nextInt();
      }
      
      boolean n = board.dropChecker(playerColumn, colorChar[player]);
      
      while(n == false){
        System.out.println("Column is full - pick a different column");
        playerColumn = input.nextInt();
        
        while(playerColumn > 6 || playerColumn < 0){
          System.out.println("Invalid column input - input a new column (0-6)");
          playerColumn = input.nextInt();
        }
        
        n = board.dropChecker(playerColumn, colorChar[player]);
      }
      
      board.draw();
      if(player == 0){
        player++;
      }
      else{
        player--;
      }
    }
    if(board.checkWinner() == true){
      if(player == 0){
        System.out.println("Yellow wins!");
      }
      else{
        System.out.println("Red wins!");
      }
    }
    else if(board.checkDraw() == true
           ){
      System.out.println("This game is a draw");
    }
    
    
    //
    // TODO: Once the program gets here, the game has either been won or ended in a draw.
    //  Determine which case is true and print out the final board along with a message 
    //  to the user.
    // 
  }
}
