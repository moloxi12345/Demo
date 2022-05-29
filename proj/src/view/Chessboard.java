package view;


import model.*;
import controller.ClickController;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * 这个类表示面板上的棋盘组件对象
 */
public class Chessboard extends JComponent {
    /**
     * CHESSBOARD_SIZE： 棋盘是8 * 8的
     * <br>
     * BACKGROUND_COLORS: 棋盘的两种背景颜色
     * <br>
     * chessListener：棋盘监听棋子的行动
     * <br>
     * chessboard: 表示8 * 8的棋盘
     * <br>
     * currentColor: 当前行棋方
     */
    private static final int CHESSBOARD_SIZE = 8;

    private final ChessComponent[][] chessComponents = new ChessComponent[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
    private ChessColor currentColor = ChessColor.WHITE;
    //all chessComponents in this chessboard are shared only one model controller
    private final ClickController clickController = new ClickController(this);
    private final int CHESS_SIZE;
    private JLabel colorLabel;


    public Chessboard(int width, int height) {
        setLayout(null); // Use absolute layout.
        setSize(width, height);
        CHESS_SIZE = width / 8;
        System.out.printf("chessboard size = %d, chess size = %d\n", width, CHESS_SIZE);

        initiateEmptyChessboard();

        // FIXME: Initialize chessboard for testing only.//在这里初始化棋盘（填棋子）
        for (int i = 0; i < CHESSBOARD_SIZE; i++) {
            initPawnOnBoard(1, i, ChessColor.BLACK);
            initPawnOnBoard(CHESSBOARD_SIZE - 2, i, ChessColor.WHITE);
        }
        initRookOnBoard(0, 0, ChessColor.BLACK);
        initRookOnBoard(0, CHESSBOARD_SIZE - 1, ChessColor.BLACK);
        initRookOnBoard(CHESSBOARD_SIZE - 1, 0, ChessColor.WHITE);
        initRookOnBoard(CHESSBOARD_SIZE - 1, CHESSBOARD_SIZE - 1, ChessColor.WHITE);
        initKnightOnBoard(0, 1, ChessColor.BLACK);
        initKnightOnBoard(0, 6, ChessColor.BLACK);
        initKnightOnBoard(CHESSBOARD_SIZE - 1, 1, ChessColor.WHITE);
        initKnightOnBoard(CHESSBOARD_SIZE - 1, 6, ChessColor.WHITE);
        initBishopOnBoard(0, 2, ChessColor.BLACK);
        initBishopOnBoard(0, 5, ChessColor.BLACK);
        initBishopOnBoard(CHESSBOARD_SIZE - 1, 2, ChessColor.WHITE);
        initBishopOnBoard(CHESSBOARD_SIZE - 1, 5, ChessColor.WHITE);
        initQueenOnBoard(0, 3, ChessColor.BLACK);
        initQueenOnBoard(CHESSBOARD_SIZE - 1, 3, ChessColor.WHITE);
        initKingOnBoard(0, 4, ChessColor.BLACK);
        initKingOnBoard(CHESSBOARD_SIZE - 1, 4, ChessColor.WHITE);

    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessColor getCurrentColor() {
        return currentColor;
    }

    public void putChessOnBoard(ChessComponent chessComponent) {//填棋子
        int row = chessComponent.getChessboardPoint().getX(), col = chessComponent.getChessboardPoint().getY();

        if (chessComponents[row][col] != null) {
            remove(chessComponents[row][col]);
        }
        add(chessComponents[row][col] = chessComponent);
    }

    public void swapChessComponents(ChessComponent chess1, ChessComponent chess2) {
        // Note that chess1 has higher priority, 'destroys' chess2 if exists.
        if (!(chess2 instanceof EmptySlotComponent)) {
            remove(chess2);
            add(chess2 = new EmptySlotComponent(chess2.getChessboardPoint(), chess2.getLocation(), clickController, CHESS_SIZE));
        }
        chess1.swapLocation(chess2);
        int row1 = chess1.getChessboardPoint().getX(), col1 = chess1.getChessboardPoint().getY();
        chessComponents[row1][col1] = chess1;
        int row2 = chess2.getChessboardPoint().getX(), col2 = chess2.getChessboardPoint().getY();
        chessComponents[row2][col2] = chess2;

        chess1.repaint();
        chess2.repaint();
    }

    public void initiateEmptyChessboard() {
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                putChessOnBoard(new EmptySlotComponent(new ChessboardPoint(i, j), calculatePoint(i, j), clickController, CHESS_SIZE));
            }
        }
    }

    public void swapColor() {
        currentColor = currentColor == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
        colorLabel.setText(String.valueOf(currentColor));
    }

    private void initPawnOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new PawnChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initRookOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new RookChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initKnightOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new KnightChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initBishopOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new BishopChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initQueenOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new QueenChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initKingOnBoard(int row, int col, ChessColor color) {
        ChessComponent chessComponent = new KingChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }


    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE, row * CHESS_SIZE);
    }

    public void loadGame(List<String> chessData) {
        if (chessData.size() != 10)//读档检测
            JOptionPane.showMessageDialog(this, "输入的棋盘并非 8*8", "你错误啦！", JOptionPane.WARNING_MESSAGE);
        for (int i = 0; i < 8; i++) {
            if (chessData.get(i).length() != 8) {
                JOptionPane.showMessageDialog(this, "输入的棋盘并非 8*8", "你错误啦！", JOptionPane.WARNING_MESSAGE);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < chessData.get(i).length(); j++) {
                char chess = chessData.get(i).toLowerCase(Locale.ROOT).charAt(j);
                if (chess != 'b' && chess != 'k' && chess != 'n' && chess != 'p' && chess != 'q' && chess != 'r' && chess != '_'){
                    JOptionPane.showMessageDialog(this, "棋子并非六种之一，棋子并非黑白棋子", "你错误啦！", JOptionPane.WARNING_MESSAGE);//这里接下来每遇到一次都会出来一次？
                }
            }
        }
        if (!Objects.equals(chessData.get(8), "w") && !Objects.equals(chessData.get(8), "b")){
            JOptionPane.showMessageDialog(this, "导入数据只有棋盘，没有下一步行棋的方的提示", "你错误啦！", JOptionPane.WARNING_MESSAGE);
        }
        if (!Objects.equals(chessData.get(9), "T") && !Objects.equals(chessData.get(8), "F")){
            JOptionPane.showMessageDialog(this, "支持存储文件是 txt,你导入的是"+ chessData.get(9), "你错误啦！", JOptionPane.WARNING_MESSAGE);
        }

        chessData.forEach(System.out::println);
        initiateEmptyChessboard();
        if (Objects.equals(String.valueOf(chessData.get(8)).toLowerCase(Locale.ROOT), "w"))
            currentColor = ChessColor.WHITE;
        else if (Objects.equals(String.valueOf(chessData.get(8)).toLowerCase(Locale.ROOT), "b"))
            currentColor = ChessColor.BLACK;
//        else { //弹出窗口，说错误
//
//        }
        for (int i = 0; i < chessData.size(); i++) {
            for (int j = 0; j < chessData.get(i).length(); j++) {
                switch (chessData.get(i).charAt(j)) {
                    case 'B' -> initBishopOnBoard(i, j, ChessColor.BLACK);
                    case 'K' -> initKingOnBoard(i, j, ChessColor.BLACK);
                    case 'N' -> initKnightOnBoard(i, j, ChessColor.BLACK);
                    case 'P' -> initPawnOnBoard(i, j, ChessColor.BLACK);
                    case 'Q' -> initQueenOnBoard(i, j, ChessColor.BLACK);
                    case 'R' -> initRookOnBoard(i, j, ChessColor.BLACK);
                    case 'b' -> initBishopOnBoard(i, j, ChessColor.WHITE);
                    case 'k' -> initKingOnBoard(i, j, ChessColor.WHITE);
                    case 'n' -> initKnightOnBoard(i, j, ChessColor.WHITE);
                    case 'p' -> initPawnOnBoard(i, j, ChessColor.WHITE);
                    case 'q' -> initQueenOnBoard(i, j, ChessColor.WHITE);
                    case 'r' -> initRookOnBoard(i, j, ChessColor.WHITE);
                }
            }
        }
        repaint();
    }

    public List<String> cunDangGame() {
        ArrayList<String> chessData = new ArrayList<>();
        for (int i = 0; i < chessComponents.length; i++) {
            StringBuilder strBuffer = new StringBuilder();
            for (int j = 0; j < chessComponents[i].length; j++) {
                if (chessComponents[i][j] instanceof EmptySlotComponent) strBuffer.append('_');
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                    strBuffer.append('B');
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                    strBuffer.append('K');
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                    strBuffer.append('N');
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                    strBuffer.append('P');
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                    strBuffer.append('Q');
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                    strBuffer.append('R');
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                    strBuffer.append('b');
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                    strBuffer.append('k');
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                    strBuffer.append('n');
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                    strBuffer.append('p');
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                    strBuffer.append('q');
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                    strBuffer.append('r');
            }
            strBuffer.append("\n");
            chessData.add(String.valueOf(strBuffer));
        }
        if (this.currentColor == ChessColor.WHITE) chessData.add(8, "w");
        if (this.currentColor == ChessColor.BLACK) chessData.add(8, "b");
        return chessData;
    }

    public void setColorLabel(JLabel colorLabel) {
        this.colorLabel = colorLabel;
    }
}