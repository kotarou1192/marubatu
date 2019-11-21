package game003.marubatu;

public class TurnResult {
    private static final char UNDEFINED_MARK_OF_WINNER = ' ';

    private boolean isFinished;
    private boolean isDraw;
    private char markOfWinner;

    private TurnResult(boolean isFinished, boolean isDraw, char markOfWinner) {
        this.isFinished = isFinished;
        this.isDraw = isDraw;
        this.markOfWinner = markOfWinner;
    }

    public static TurnResult resultNotFinished() {
        return new TurnResult(false, false, UNDEFINED_MARK_OF_WINNER);
    }

    public static TurnResult resultDraw() {
        return new TurnResult(true, true, UNDEFINED_MARK_OF_WINNER);
    }

    public static TurnResult resultWitchWinner(char markOfWinner) {
        return new TurnResult(true, false, markOfWinner);
    }

    public boolean isFinished() {//勝負は終わりかどうか
        return this.isFinished;
    }

    public boolean isDraw() {//引き分けかどうか
        return this.isDraw;
    }

    public char getMarkOfWinner() {//勝者のマークを取得する
        if (!isFinished || isDraw)
            throw new IllegalStateException("isFinished: " + isFinished + " expected: true isDraw: " + isDraw + " expected: false");
        return this.markOfWinner;
    }
}
