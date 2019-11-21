package game003.marubatu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private final int Turn_O = 1;//o�̃^�[��
    private final char Player1_Mark = 'o';
    private final char Player2_Mark = 'x';
    Board board = new Board();
    private int currentTurn = 1;// ���݂̃^�[��(���o 1�A���x �[1�j
    private char mark;
    private int turn = 1;//�^�[��

    public void start() {
        while (!play());
    }

    private boolean play() {//1�^�[���i�߁A�Q�[�����I����true�A���s�Ȃ�false
        TurnResult result = board.judge();
        if(result.isDraw()){
            System.out.println("��������");
            return true;
        }
        try {
            System.out.println("�^�[��" + turn + "�F�ł}�X��0,1,2���g���ē��͂��Ă��������B�����̊Ԃɂ͋󔒂����Ă��������B[y x]");
            @SuppressWarnings("resource")
            Scanner scn = new Scanner(System.in); // ����
            int x = scn.nextInt();
            int y = scn.nextInt();

            if (currentTurn == Turn_O) {
                mark = Player1_Mark;
            } else {
                mark = Player2_Mark;
            }
            while (!board.markSlot(x, y, mark)) {
                System.out.println("������x");
                scn = new Scanner(System.in); // ����
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
                System.out.println("���҂�" + result.getMarkOfWinner());
                return true;
            }
        } catch (InputMismatchException e) {
            System.out.println("���͂��ꂽ�������s���ł�");
            return false;
        }
    }

    private int nextPlayer(int currentPlayer) {
        return -currentPlayer;
    }
}
