package game003.marubatu;

import java.util.Objects;
import java.util.Scanner;

public class Main {

  private final int Draw = 3;
  private final int Win_o = 1;
  private final int Win_x = 2;


  public static void main(String[] args) {
    
    Main playGame = new Main();
    playGame.start();
  }

  public void start() {
    
    System.out.println("�Q�[�����͂��߂܂����F[y/n]");
    Scanner txt1 = new Scanner(System.in); // ����
    String gameStart = txt1.nextLine(); // ���͂�ϐ��ɑ��

    if (Objects.equals(gameStart,"y")) { // �Q�[���J�n
      Game game = new Game();
      game.board.printBoard();
      while (game.winner == Draw) {
        game.play();
      }
      
      if(game.winner == Win_o) {//���s�\��
        System.out.println("o�̏���");
      }else if(game.winner == Win_x) {
        System.out.println("x�̏���");
      }
      
      txt1.close();
      
    } else if (Objects.equals(gameStart,"n")) { // �Q�[���I��
      System.out.println("end");
      System.exit(0);
      
    } else { // 0��1�ȊO�����͂��ꂽ�̂ŏI��
      System.out.println("y��n�œ��͂��Ă�������");
      System.exit(0);
    }
  }
}
