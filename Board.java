package game003.marubatu;

public class Board {
    private final char DEFAULT_MARK;
    private char[][] board;// 盤面
    private char winnerMark;


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

    public void printBoard() {// 盤面を出力
        System.out.println(" 0 1 2  ");
        System.out.println("┏━┳━┳━┓");
        System.out.println("┃" + board[0][0] + "┃" + board[0][1] + "┃" + board[0][2] + "┃" + " 0");
        System.out.println("┣━╋━╋━┫");
        System.out.println("┃" + board[1][0] + "┃" + board[1][1] + "┃" + board[1][2] + "┃" + " 1");
        System.out.println("┣━╋━╋━┫");
        System.out.println("┃" + board[2][0] + "┃" + board[2][1] + "┃" + board[2][2] + "┃" + " 2");
        System.out.println("┗━┻━┻━┛");

    }

    public boolean markSlot(int x, int y, char mark) {// マスに入力

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

    public boolean referee() {//勝者がいればtrueいなければfalse
        return winnerMark != DEFAULT_MARK;
    }

    public char whoWin() {//judgeした後に勝者がいればマークを、いなければデフォルトマークを返す
        return winnerMark;
    }


    Board judge() {

        // 縦の判定
        for (int x = 0; x < board.length; x++) {
            if (board[x][0] != DEFAULT_MARK & board[x][0] == board[x][1] & board[x][1] == board[x][2]) {
                winnerMark = board[x][2];
                return this;
            }
        }

        // 横の判定
        for (int y = 0; y < board[0].length; y++) {
            if (board[0][y] != DEFAULT_MARK & board[0][y] == board[1][y] & board[1][y] == board[2][y]) {
                winnerMark = board[2][y];
                return this;
            }
        }

        // 斜めの判定
        if (board[0][0] != DEFAULT_MARK & board[0][0] == board[1][1] & board[1][1] == board[2][2]) {
            winnerMark = board[1][1];
            return this;
        }

        // 斜めの判定その2
        if (board[0][2] != DEFAULT_MARK & board[0][2] == board[1][1] & board[1][1] == board[2][0]) {
            winnerMark = board[1][1];
            return this;
        }
        winnerMark = DEFAULT_MARK;
        return this;
    }
}
