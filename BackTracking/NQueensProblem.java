import java.util.ArrayList;

public class NQueensProblem {

  static int count = 0;

  public static void nQueens(char board[][], int row) {
    if (row == board.length) {
      printBoard(board);
      return;
    }
    for (int i = 0; i < board.length; i++) {
      if (isSafe(board, row, i)) {
        board[row][i] = 'Q';
        nQueens(board, row + 1);
        board[row][i] = '.';
      }
    }
  }

  public static boolean isSafe(char board[][], int row, int col) {
    // Vertically up
    for (int i = row - 1; i >= 0; i--) {
      if (board[i][col] == 'Q') {
        return false;
      }
    }

    // Diagonal Left
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    // Diagonal Right
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    return true;
  }

  public static void printBoard(char board[][]) {
    count++;
    System.out.println("----- Chess Board : " + count + " -----");
    for (int i = 0; i < board[0].length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int n = 4;
    char board[][] = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }
    nQueens(board, 0);
  }
}
