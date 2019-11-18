package game003.marubatu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

  private final int turn_o = 1;//o�̃^�[��
  private final int turn_x = 2;//x�̃^�[��
  private final int turn_draw = 3;//���������̃^�[��

  private int x, y;// �Ղ̍��W
  private int stat = 1;// �^�[���̏��(���o1�A���x�[1�j
  private int turn = 1;//�^�[��
  int winner = turn_draw;//1 o�̏���, 2 x�̏���, 3 �܂�
  Board board = new Board();

  public int play() {

    System.out.println("�^�[��" + turn + "�F�ł}�X��0,1,2���g���ē��͂��Ă��������B�����̊Ԃɂ͋󔒂����Ă��������B[y x]");
    try {
      @SuppressWarnings("resource")
      Scanner scn = new Scanner(System.in); // ����
      x = scn.nextInt();
      y = scn.nextInt();
      
      while (!board.markSlot(x, y, stat)) {
        System.out.println("������x");
        scn = new Scanner(System.in); // ����
        x = scn.nextInt();
        y = scn.nextInt();
      }
      
      judgeGame(board.board, stat);
      if(winner == turn_draw) {
        stat = -stat;
        turn++;
      }
      board.printBoard();
     
    } catch (InputMismatchException e) {
      System.out.println("���͂��ꂽ�������s���ł�");
    }
    
    return winner;
    
  }

  private void judgeGame(char chr[][], int turn) {

    // �c�̔���
    for (int x = 0; x < chr.length; x++) {
      if (chr[x][0] != ' ' & chr[x][0] == chr[x][1] & chr[x][1] == chr[x][2]) {
        if (turn == turn_o) {// o���Ō�ɑł���
          winner = turn_o;
        } else {// o���Ō�ł͂Ȃ�
          winner = turn_x;
        }
      }
    }

    // ���̔���
    for (int y = 0; y < chr[0].length; y++) {
      if (chr[0][y] != ' ' & chr[0][y] == chr[1][y] & chr[1][y] == chr[2][y]) {
        if (turn == turn_o) {// o���Ō�ɑł���
          winner = turn_o;
        } else {// o���Ō�ł͂Ȃ�
          winner = turn_x;
        }
      }
    }

    // �΂߂̔���
    if (chr[0][0] != ' ' & chr[0][0] == chr[1][1] & chr[1][1] == chr[2][2]) {
      if (turn == turn_o) {// o���Ō�ɑł���
        winner = turn_o;
      } else {// o���Ō�ł͂Ȃ�
        winner = turn_x;
      }
    }

    // �΂߂̔��肻��2
    if (chr[0][2] != ' ' & chr[0][2] == chr[1][1] & chr[1][1] == chr[2][0]) {
      if (turn == turn_o) {// o���Ō�ɑł���
        winner = turn_o;
      } else {// o���Ō�ł͂Ȃ�
        winner = turn_x;
      }
    }

  }
}
