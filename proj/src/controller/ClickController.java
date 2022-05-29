package controller;


import model.ChessColor;
import model.ChessComponent;
import model.KingChessComponent;
import view.Chessboard;

public class ClickController {
    private final Chessboard chessboard;
    private ChessComponent first;

    public ClickController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void onClick(ChessComponent chessComponent) {
        if (first == null) {
            if (handleFirst(chessComponent)) {
                chessComponent.setSelected(true);
                first = chessComponent;
                first.repaint();
            }
        } else {
            if (first == chessComponent) { // 再次点击取消选取
                chessComponent.setSelected(false);
                ChessComponent recordFirst = first;
                first = null;
                recordFirst.repaint();
            } else if (handleSecond(chessComponent)) {
                //repaint in swap chess method.
                chessboard.swapChessComponents(first, chessComponent);
                chessboard.swapColor();
                first.setSelected(false);
                first = null;

                int whiteCounter = 0;//判断游戏是否结束以及最终赢家
                int blackCounter = 0;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (chessboard.getChessComponents()[i][j] instanceof KingChessComponent && chessboard.getChessComponents()[i][j].getChessColor() == ChessColor.WHITE){
                            whiteCounter++;
                        }
                        if (chessboard.getChessComponents()[i][j] instanceof KingChessComponent && chessboard.getChessComponents()[i][j].getChessColor() == ChessColor.BLACK){
                            blackCounter++;
                        }
                    }
                }
                if (whiteCounter == 0) System.out.println("Black Win!!!!");
                if (blackCounter == 0) System.out.println("White Win!!!!");
            }
        }
    }

    /**
     * @param chessComponent 目标选取的棋子
     * @return 目标选取的棋子是否与棋盘记录的当前行棋方颜色相同
     */

    private boolean handleFirst(ChessComponent chessComponent) {
        return chessComponent.getChessColor() == chessboard.getCurrentColor();
    }

    /**
     * @param chessComponent first棋子目标移动到的棋子second
     * @return first棋子是否能够移动到second棋子位置
     */

    private boolean handleSecond(ChessComponent chessComponent) {
        return chessComponent.getChessColor() != chessboard.getCurrentColor() &&
                first.canMoveTo(chessboard.getChessComponents(), chessComponent.getChessboardPoint());
    }
}
