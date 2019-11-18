package game003.marubatu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

  private final int turn_o = 1;//oのターン
  private final int turn_x = 2;//xのターン
  private final int turn_draw = 3;//引き分けのターン

  private int x, y;// 盤の座標
  private int stat = 1;// ターンの状態(先手o1、後手xー1）
  private int turn = 1;//ターン
  int winner = turn_draw;//1 oの勝ち, 2 xの勝ち, 3 まだ
  Board board = new Board();

  public int play() {

    System.out.println("ターン" + turn + "：打つマスを0,1,2を使って入力してください。数字の間には空白を入れてください。[y x]");
    try {
      @SuppressWarnings("resource")
      Scanner scn = new Scanner(System.in); // 入力
      x = scn.nextInt();
      y = scn.nextInt();
      
      while (!board.markSlot(x, y, stat)) {
        System.out.println("もう一度");
        scn = new Scanner(System.in); // 入力
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
      System.out.println("入力された文字が不正です");
    }
    
    return winner;
    
  }

  private void judgeGame(char chr[][], int turn) {

    // 縦の判定
    for (int x = 0; x < chr.length; x++) {
      if (chr[x][0] != ' ' & chr[x][0] == chr[x][1] & chr[x][1] == chr[x][2]) {
        if (turn == turn_o) {// oが最後に打った
          winner = turn_o;
        } else {// oが最後ではない
          winner = turn_x;
        }
      }
    }

    // 横の判定
    for (int y = 0; y < chr[0].length; y++) {
      if (chr[0][y] != ' ' & chr[0][y] == chr[1][y] & chr[1][y] == chr[2][y]) {
        if (turn == turn_o) {// oが最後に打った
          winner = turn_o;
        } else {// oが最後ではない
          winner = turn_x;
        }
      }
    }

    // 斜めの判定
    if (chr[0][0] != ' ' & chr[0][0] == chr[1][1] & chr[1][1] == chr[2][2]) {
      if (turn == turn_o) {// oが最後に打った
        winner = turn_o;
      } else {// oが最後ではない
        winner = turn_x;
      }
    }

    // 斜めの判定その2
    if (chr[0][2] != ' ' & chr[0][2] == chr[1][1] & chr[1][1] == chr[2][0]) {
      if (turn == turn_o) {// oが最後に打った
        winner = turn_o;
      } else {// oが最後ではない
        winner = turn_x;
      }
    }

  }
}
