package game003.marubatu;

import java.util.Objects;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    
    Main playGame = new Main();
    System.out.println("�Q�[�����͂��߂܂����F[y/n]");
    while(!playGame.start());
  }

  public boolean start() {
    Scanner text = new Scanner(System.in); // ����
    String gameStart = text.nextLine(); // ���͂�ϐ��ɑ��

    if (Objects.equals(gameStart,"y")) { // �Q�[���J�n
      Game game = new Game();
      game.board.printBoard();
      game.start();
      return true;
      
    } else if (Objects.equals(gameStart,"n")) { // �Q�[���I��
      System.out.println("end");
      return true;
      
    } else { // 0��1�ȊO�����͂��ꂽ�̂ŏI��
      System.out.println("y��n�œ��͂��Ă�������");
      return false;
    }
  }
}
