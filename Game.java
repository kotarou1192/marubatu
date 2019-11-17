package game003;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
  private int x, y;// 盤の座標
  private int turn = 1;// ターンの状態(先手o1、後手xー1）
  private int gameturn = 1;//ターン
  int winner = 3;//1 oの勝ち, 2 xの勝ち, 3 まだ
  Board board = new Board();

  public int play() {

    System.out.println("ターン" + gameturn + "：打つマスを0,1,2を使って入力してください。数字の間には空白を入れてください。[y x]");
    try {
      @SuppressWarnings("resource")
      Scanner scn = new Scanner(System.in); // 入力
      x = scn.nextInt();
      y = scn.nextInt();
      
      while (!board.markSlot(x, y, turn)) {
        System.out.println("もう一度");
        scn = new Scanner(System.in); // 入力
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
      System.out.println("入力された文字が不正です");
    }
    
    return winner;
    
  }

  private void judgeGame(char chr[][], int turn) {

    // 縦の判定
    for (int x = 0; x < 3; x++) {
      if (chr[x][0] != ' ' & chr[x][0] == chr[x][1] & chr[x][1] == chr[x][2]) {
        if (turn == 1) {// oが最後に打った
          winner = 1;
        } else {// oが最後ではない
          winner = 2;
        }
      }
    }

    // 横の判定
    for (int y = 0; y < 3; y++) {
      if (chr[0][y] != ' ' & chr[0][y] == chr[1][y] & chr[1][y] == chr[2][y]) {
        if (turn == 1) {// oが最後に打った
          winner = 1;
        } else {// oが最後ではない
          winner = 2;
        }
      }
    }

    // 斜めの判定
    if (chr[0][0] != ' ' & chr[0][0] == chr[1][1] & chr[1][1] == chr[2][2]) {
      if (turn == 1) {// oが最後に打った
        winner = 1;
      } else {// oが最後ではない
        winner = 2;
      }
    }

    // 斜めの判定その2
    if (chr[0][2] != ' ' & chr[0][2] == chr[1][1] & chr[1][1] == chr[2][0]) {
      if (turn == 1) {// oが最後に打った
        winner = 1;
      } else {// oが最後ではない
        winner = 2;
      }
    }

  }
}
