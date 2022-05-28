package model;

import controller.ClickController;
import view.ChessboardPoint;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PawnChessComponent extends ChessComponent {
    private static Image PAWN_WHITE;
    private static Image PAWN_BLACK;
    private Image pawnImage;

    public void loadResource() throws IOException {
        if (PAWN_WHITE == null) {
            PAWN_WHITE = ImageIO.read(new File("./images/pawn-white.png"));//这里还没有把路径给对应起来
        }

        if (PAWN_BLACK == null) {
            PAWN_BLACK = ImageIO.read(new File("./images/pawn-black.png"));
        }
    }

    private void initiatePawnImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                pawnImage = PAWN_WHITE;
            } else if (color == ChessColor.BLACK) {
                pawnImage = PAWN_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PawnChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color, ClickController listener, int size) {
        super(chessboardPoint, location, color, listener, size);
        initiatePawnImage(color);
    }

    @Override
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if (getChessColor() == ChessColor.BLACK) {
            if (destination.getY() == source.getY() && destination.getX() == source.getX() + 1 && chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) {
                return true;
            }
            if (destination.getY() == source.getY() && source.getX() == 1 && chessComponents[3][destination.getY()] instanceof EmptySlotComponent) {
                return true;
            }
            if (destination.getX() == source.getX() + 1 && destination.getY() == source.getY() - 1 && chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.WHITE) {
                return true;
            }
            if (destination.getX() == source.getX() + 1 && destination.getY() == source.getY() + 1 && chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.WHITE) {
                return true;
            }

        } else if (getChessColor() == ChessColor.WHITE) {
            if (destination.getY() == source.getY() && destination.getX() == source.getX() - 1 && chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) {
                return true;
            }
            if (destination.getY() == source.getY() && source.getX() == 6 && chessComponents[4][destination.getY()] instanceof EmptySlotComponent) {
                return true;
            }
            if (destination.getX() == source.getX() - 1 && destination.getY() == source.getY() - 1 && chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.BLACK) {
                return true;
            }
            if (destination.getX() == source.getX() - 1 && destination.getY() == source.getY() + 1 && chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.BLACK) {
                return true;
            }
        }
        return false;
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(pawnImage, 0, 0, getWidth() - 13, getHeight() - 20, this);
        g.drawImage(pawnImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}
