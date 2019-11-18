package game003.marubatu;

public class Board {
  private char[][] board;// �Ֆ�
  public Board() {
    board = new char[3][3];
    for(int x = 0; x<board.length;x++) {
      for(int y = 0;y<board[0].length;y++ ) {
        board[x][y]=' ';
      }
    }
  }

  public Board(char initMark) {
    board = new char[3][3];
    for(int x = 0; x<board.length;x++) {
      for(int y = 0;y<board[0].length;y++ ) {
        board[x][y] = initMark;
      }
    }
  }
  
  public void printBoard() {// �Ֆʂ��o��
    System.out.println(" 0 1 2  ");
    System.out.println("��������������");
    System.out.println("��" + board[0][0] + "��" + board[0][1] + "��" + board[0][2] + "��" + " 0");
    System.out.println("��������������");
    System.out.println("��" + board[1][0] + "��" + board[1][1] + "��" + board[1][2] + "��" + " 1");
    System.out.println("��������������");
    System.out.println("��" + board[2][0] + "��" + board[2][1] + "��" + board[2][2] + "��" + " 2");
    System.out.println("��������������");

  }

  public boolean markSlot(int x, int y, char mark) {// �}�X�ɓ���

    if (x < 0 ||board.length <= x)
      return false;
    if (y < 0 || board[0].length <= y)
      return false;

    board[x][y] = mark;
    return true;
  }

  public char getMark(int x, int y){
    if (x < 0 ||board.length <= x)throw new IllegalArgumentException();
    if (y < 0 || board[0].length <= y)throw new IllegalArgumentException();

    return board[x][y];
  }



}
