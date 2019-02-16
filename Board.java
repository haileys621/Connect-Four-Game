
/** Implements a ConnectFour board */
public class Board {
  static final int ROWS = 6; // The number of rows on the board.
  static final int COLUMNS = 7; // The number of columns on the board.

  // board is the instance variable that stores the actual board, a 2-array of chars.
  // The possible characters stored in the board include:
  //  ' ' - Empty Space
  //  'R' - Red checker
  //  'Y' - Yellow checker
  private char[][] board;

  /** Constructor of a Board object.
    *
    * Instantiates the 'board' variable and initializes all of the cells to ' '.
    */
  public Board() {
    board = new char[ROWS][COLUMNS];
    for(int i = 0; i < ROWS; i++){
      for(int j = 0; j < COLUMNS; j++){
        board[i][j] = ' ';
      }
    }
  }

  /** Writes the current board to System.out, per the format in the assignment PDF. */
  
  public void draw() {  
    for(int i = 0; i < ROWS; i++){
      System.out.print("|");
      for(int j = 0; j < COLUMNS; j++){
        System.out.print(board[i][j] + "|");
      }
      System.out.println();
    }
  }

  /** Attempts to drop the specified checker in the specified column.  If the checker is
    * successfully dropped, the method adds the checker to the board variable and returns true.
    * If the specified column is full, the method returns false.
    */
  public boolean dropChecker(int column, char checker) {
    int i = 5;
    while(i >= 0 && board[i][column] != ' '){
      i--;
    }
    if(i >= 0){
      board[i][column] = checker;
      return true;
    }
    else{
      return false;
    }
  }

  /** Determines if the game has a winner.  The method returns true if either user
    * has four in a row in any direction.
    **/
  public boolean checkWinner() {
    int count = 0;
    for(int i = 0; i < ROWS; i++){
      for(int j = 0; j < COLUMNS-3; j++){
        if(board[i][j] != ' ' && board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2] && board[i][j+2] == board[i][j+3]){
          return true;
        }
      }
    }
    
    for(int i = 0; i < COLUMNS; i++){
      for(int j = 0; j < ROWS-3; j++){
        if(board[j][i] != ' ' && board[j][i] == board[j+1][i] && board[j+1][i] == board[j+2][i] && board[j+2][i] == board[j+3][i]){
          return true;
        }
      }
    }
    
    for(int i = 0; i < ROWS-3; i++){
      for(int j = 0; j < COLUMNS-3; j++){
        if(board[i][j] != ' ' && board[i][j] == board[i+1][j+1] && board[i+1][j+1] == board[i+2][j+2] && board[i+2][j+2] == board[i+3][j+3]){
          return true;
        }
      }
    }
    
    for(int i = 0; i < ROWS-3; i++){
      for(int j = COLUMNS-1; j > COLUMNS-5; j--){
        if(board[i][j] != ' ' && board[i][j] == board[i+1][j-1] && board[i+1][j-1] == board[i+2][j-2] && board[i+2][j-2] == board[i+3][j-3]){
          return true;
        }
      }
    }
        
    return false;
  }

  /** Determines if the game is a draw.
    * This method assumes the user already checked if there is a winner via a call to
    * checkWinner. This method returns true if there are no more blank squares. */
  public boolean checkDraw() {
    for(int i = 0; i < ROWS; i++){
      for(int j = 0; j < COLUMNS; j++){
        if(board[i][j] == ' '){
          return false;
        }
      }
    }
    return true;
  }
}
