package game003.marubatu;

import java.util.Objects;

public class Board {
    private final char DEFAULT_MARK;
    private char[][] board;// ”Õ–Ê


    public Board() {
        this(' ');
    }

    public Board(char initMark) {
        board = new char[3][3];
        DEFAULT_MARK = initMark;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                board[x][y] = DEFAULT_MARK;
            }
        }
    }

    public void printBoard() {// ”Õ–Ê‚ðo—Í
        System.out.println(" 0 1 2  ");
        System.out.println("„¬„ª„±„ª„±„ª„­");
        System.out.println("„«" + board[0][0] + "„«" + board[0][1] + "„«" + board[0][2] + "„«" + " 0");
        System.out.println("„°„ª„´„ª„´„ª„²");
        System.out.println("„«" + board[1][0] + "„«" + board[1][1] + "„«" + board[1][2] + "„«" + " 1");
        System.out.println("„°„ª„´„ª„´„ª„²");
        System.out.println("„«" + board[2][0] + "„«" + board[2][1] + "„«" + board[2][2] + "„«" + " 2");
        System.out.println("„¯„ª„³„ª„³„ª„®");

    }

    public boolean markSlot(int x, int y, char mark) {// ƒ}ƒX‚É“ü—Í

        if (x < 0 || board.length <= x)
            return false;
        if (y < 0 || board[0].length <= y)
            return false;

        board[x][y] = mark;
        return true;
    }

    public char getMark(int x, int y) {
        if (x < 0 || board.length <= x) throw new IllegalArgumentException();
        if (y < 0 || board[0].length <= y) throw new IllegalArgumentException();

        return board[x][y];
    }

    public TurnResult judge() {

        // c‚Ì”»’è
        for (int x = 0; x < board.length; x++) {
            if (board[x][0] != DEFAULT_MARK && board[x][0] == board[x][1] && board[x][1] == board[x][2]) {
                return TurnResult.resultWitchWinner(board[x][2]);
            }
        }

        // ‰¡‚Ì”»’è
        for (int y = 0; y < board[0].length; y++) {
            if (board[0][y] != DEFAULT_MARK && board[0][y] == board[1][y] && board[1][y] == board[2][y]) {
                return TurnResult.resultWitchWinner(board[2][y]);
            }
        }

        // ŽÎ‚ß‚Ì”»’è
        if (board[0][0] != DEFAULT_MARK && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return TurnResult.resultWitchWinner(board[1][1]);
        }

        // ŽÎ‚ß‚Ì”»’è‚»‚Ì2
        if (board[0][2] != DEFAULT_MARK && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return TurnResult.resultWitchWinner(board[1][1]);
        }

        //ˆø‚«•ª‚¯”»’è
        if(board[0][0] != DEFAULT_MARK && DEFAULT_MARK != board[0][1] && DEFAULT_MARK != board[0][2] && DEFAULT_MARK != board[1][0] && DEFAULT_MARK != board[1][1] && DEFAULT_MARK != board[1][2]&& DEFAULT_MARK != board[2][0] && DEFAULT_MARK != board[2][1] && DEFAULT_MARK != board[2][2]){
            return TurnResult.resultDraw();
        }
        return TurnResult.resultNotFinished();
    }


}
