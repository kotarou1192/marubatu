package game003;

import java.util.Objects;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    
    Main playgame = new Main();
    playgame.start();
  }

  public void start() {
    
    System.out.println("�Q�[�����͂��߂܂����F[y/n]");
    Scanner txt1 = new Scanner(System.in); // ����
    String gamestart = txt1.nextLine(); // ���͂�ϐ��ɑ��

    if (Objects.equals(gamestart,"y")) { // �Q�[���J�n
      Game game = new Game();
      game.board.printBoard();
      while (game.winner == 3) {
        game.play();
      }
      
      if(game.winner == 1) {//���s�\��
        System.out.println("o�̏���");
      }else if(game.winner == 2) {
        System.out.println("x�̏���");
      }
      
      txt1.close();
      
    } else if (Objects.equals(gamestart,"n")) { // �Q�[���I��
      System.out.println("end");
      System.exit(0);
      
    } else { // 0��1�ȊO�����͂��ꂽ�̂ŏI��
      System.out.println("y��n�œ��͂��Ă�������");
      System.exit(0);
    }
  }
}
