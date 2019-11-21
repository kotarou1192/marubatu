package game003.marubatu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private final int Turn_O = 1;//oのターン
    private final char Player1_Mark = 'o';
    private final char Player2_Mark = 'x';
    Board board = new Board();
    private int currentTurn = 1;// 現在のターン(先手o 1、後手x ー1）
    private char mark;
    private int turn = 1;//ターン

    public void start() {
        while (!play());
    }

    private boolean play() {//1ターン進め、ゲームが終わればtrue、続行ならfalse
        TurnResult result = board.judge();
        if(result.isDraw()){
            System.out.println("引き分け");
            return true;
        }
        try {
            System.out.println("ターン" + turn + "：打つマスを0,1,2を使って入力してください。数字の間には空白を入れてください。[y x]");
            @SuppressWarnings("resource")
            Scanner scn = new Scanner(System.in); // 入力
            int x = scn.nextInt();
            int y = scn.nextInt();

            if (currentTurn == Turn_O) {
                mark = Player1_Mark;
            } else {
                mark = Player2_Mark;
            }
            while (!board.markSlot(x, y, mark)) {
                System.out.println("もう一度");
                scn = new Scanner(System.in); // 入力
                x = scn.nextInt();
                y = scn.nextInt();
            }
            if (!result.isFinished()) {
                currentTurn = nextPlayer(currentTurn);
                turn++;
                board.printBoard();
                return false;
            } else {
                board.printBoard();
                System.out.println("勝者は" + result.getMarkOfWinner());
                return true;
            }
        } catch (InputMismatchException e) {
            System.out.println("入力された文字が不正です");
            return false;
        }
    }

    private int nextPlayer(int currentPlayer) {
        return -currentPlayer;
    }
}
