package game003;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
  private int x, y;// �Ղ̍��W
  private int turn = 1;// �^�[���̏��(���o1�A���x�[1�j
  private int gameturn = 1;//�^�[��
  int winner = 3;//1 o�̏���, 2 x�̏���, 3 �܂�
  Board board = new Board();

  public int play() {

    System.out.println("�^�[��" + gameturn + "�F�ł}�X��0,1,2���g���ē��͂��Ă��������B�����̊Ԃɂ͋󔒂����Ă��������B[y x]");
    try {
      @SuppressWarnings("resource")
      Scanner scn = new Scanner(System.in); // ����
      x = scn.nextInt();
      y = scn.nextInt();
      
      while (!board.markSlot(x, y, turn)) {
        System.out.println("������x");
        scn = new Scanner(System.in); // ����
        x = scn.nextInt();
        y = scn.nextInt();
      }
      
      judgeGame(board.Board,turn);
      if(winner == 3) {
        turn = -turn;
        gameturn++;
      }
      board.printBoard();
     
    } catch (InputMismatchException e) {
      System.out.println("���͂��ꂽ�������s���ł�");
    }
    
    return winner;
    
  }

  private void judgeGame(char chr[][], int turn) {

    // �c�̔���
    for (int x = 0; x < 3; x++) {
      if (chr[x][0] != ' ' & chr[x][0] == chr[x][1] & chr[x][1] == chr[x][2]) {
        if (turn == 1) {// o���Ō�ɑł���
          winner = 1;
        } else {// o���Ō�ł͂Ȃ�
          winner = 2;
        }
      }
    }

    // ���̔���
    for (int y = 0; y < 3; y++) {
      if (chr[0][y] != ' ' & chr[0][y] == chr[1][y] & chr[1][y] == chr[2][y]) {
        if (turn == 1) {// o���Ō�ɑł���
          winner = 1;
        } else {// o���Ō�ł͂Ȃ�
          winner = 2;
        }
      }
    }

    // �΂߂̔���
    if (chr[0][0] != ' ' & chr[0][0] == chr[1][1] & chr[1][1] == chr[2][2]) {
      if (turn == 1) {// o���Ō�ɑł���
        winner = 1;
      } else {// o���Ō�ł͂Ȃ�
        winner = 2;
      }
    }

    // �΂߂̔��肻��2
    if (chr[0][2] != ' ' & chr[0][2] == chr[1][1] & chr[1][1] == chr[2][0]) {
      if (turn == 1) {// o���Ō�ɑł���
        winner = 1;
      } else {// o���Ō�ł͂Ȃ�
        winner = 2;
      }
    }

  }
}
