package game003;

import java.util.Objects;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    
    Main playgame = new Main();
    playgame.start();
  }

  public void start() {
    
    System.out.println("ゲームをはじめますか：[y/n]");
    Scanner txt1 = new Scanner(System.in); // 入力
    String gamestart = txt1.nextLine(); // 入力を変数に代入

    if (Objects.equals(gamestart,"y")) { // ゲーム開始
      Game game = new Game();
      game.board.printBoard();
      while (game.winner == 3) {
        game.play();
      }
      
      if(game.winner == 1) {//勝敗表示
        System.out.println("oの勝ち");
      }else if(game.winner == 2) {
        System.out.println("xの勝ち");
      }
      
      txt1.close();
      
    } else if (Objects.equals(gamestart,"n")) { // ゲーム終了
      System.out.println("end");
      System.exit(0);
      
    } else { // 0か1以外が入力されたので終了
      System.out.println("yかnで入力してください");
      System.exit(0);
    }
  }
}
