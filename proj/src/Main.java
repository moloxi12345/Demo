import view.ChessGameFrame;
import view.Dengluinterface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        new Dengluinterface().init();
//        SwingUtilities.invokeLater(() -> {
//            ChessGameFrame mainFrame = new ChessGameFrame(1000, 760);
//            mainFrame.setVisible(true);
//        });
    }
}
