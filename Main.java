package game003.marubatu;

import java.util.Objects;
import java.util.Scanner;

public class Main {

  private final int draw = 3;
  private final int win_o = 1;
  private final int win_x = 2;


  public static void main(String[] args) {
    
    Main playgame = new Main();
    playgame.start();
  }

  public void start() {
    
    System.out.println("ゲームをはじめますか：[y/n]");
    Scanner txt1 = new Scanner(System.in); // 入力
    String gameStart = txt1.nextLine(); // 入力を変数に代入

    if (Objects.equals(gameStart,"y")) { // ゲーム開始
      Game game = new Game();
      game.board.printBoard();
      while (game.winner == draw) {
        game.play();
      }
      
      if(game.winner == win_o) {//勝敗表示
        System.out.println("oの勝ち");
      }else if(game.winner == win_x) {
        System.out.println("xの勝ち");
      }
      
      txt1.close();
      
    } else if (Objects.equals(gameStart,"n")) { // ゲーム終了
      System.out.println("end");
      System.exit(0);
      
    } else { // 0か1以外が入力されたので終了
      System.out.println("yかnで入力してください");
      System.exit(0);
    }
  }
}
