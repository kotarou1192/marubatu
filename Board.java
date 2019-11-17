package game003;

public class Board {
  char[][] Board;// ”Õ–Ê
  public Board() {
    Board = new char[3][3];
    for(int x = 0; x<Board.length;x++) {
      for(int y = 0;y<Board[0].length;y++ ) {
        Board[x][y]=' ';
      }
    }
  }
  
  public void printBoard() {// ”Õ–Ê‚ðo—Í
    System.out.println(" 0 1 2  ");
    System.out.println("„¬„ª„±„ª„±„ª„­");
    System.out.println("„«" + Board[0][0] + "„«" + Board[0][1] + "„«" + Board[0][2] + "„«" + " 0");
    System.out.println("„°„ª„´„ª„´„ª„²");
    System.out.println("„«" + Board[1][0] + "„«" + Board[1][1] + "„«" + Board[1][2] + "„«" + " 1");
    System.out.println("„°„ª„´„ª„´„ª„²");
    System.out.println("„«" + Board[2][0] + "„«" + Board[2][1] + "„«" + Board[2][2] + "„«" + " 2");
    System.out.println("„¯„ª„³„ª„³„ª„®");

  }

  public boolean markSlot(int x, int y, int turn) {// ƒ}ƒX‚É“ü—Í

    if (x < 0 ||Board.length <= x)
      return false;
    if (y < 0 || Board[0].length <= y)
      return false;
    if (turn != 1 && turn != -1)
      return false;
    if (Board[x][y] != ' ')
      return false;

    char mark;
    if (turn == 1)
      mark = 'o';
    else
      mark = 'x';

    // mark = turn==1 ? 'o' : 'x';

    Board[x][y] = mark;
    return true;
  }
}
