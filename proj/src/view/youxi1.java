package view;

import controller.GameController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class youxi1 extends JFrame {
    /**
     * 这个类表示游戏过程中的整个游戏界面
     */
    private final int WIDTH;
    private final int HEIGTH;
    public final int CHESSBOARD_SIZE;
    private GameController gameController;


    public youxi1(int width, int height) {
        setTitle("国际象棋"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.CHESSBOARD_SIZE = HEIGTH * 4 / 5;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);


        addChessboard();
        addcundang();
        addhuiqi();
        addfanhui();
        addchongzhi();
    }



    /**
     * 在游戏面板中添加棋盘
     */
    private void addChessboard() {
        Chessboard chessboard = new Chessboard(CHESSBOARD_SIZE, CHESSBOARD_SIZE);
        gameController = new GameController(chessboard);
        chessboard.setLocation(HEIGTH / 10, HEIGTH / 10);
        add(chessboard);
    }


    /**
     * 在游戏面板中增加重置按钮
     */
    private void addchongzhi() {
        JButton button = new JButton("重置游戏");
        button.setLocation(HEIGTH, HEIGTH / 10 + 360);
        button.setSize(200, 60);
        //button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                youxi1 you = new youxi1(1000, 760);
                int result = JOptionPane.showConfirmDialog(you, "若未存档，将丢失数据，是否重置", "提示", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    SwingUtilities.invokeLater(() -> {
                        youxi1 mainF = new youxi1(1000, 760);
                        mainF.setVisible(true);
                    });
                    dispose();
                }
            }
        });
    }

    //添加存档按钮
    private void addcundang() {
        JButton cundang = new JButton("存档");
        cundang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cundang.setLocation(HEIGTH, HEIGTH / 10 + 240);
        cundang.setSize(200, 60);
        //button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(cundang);
    }

    //返回按钮
    private void addfanhui() {
        JButton button = new JButton("返回主界面");
        button.setLocation(HEIGTH, HEIGTH / 10 + 480);
        button.setSize(200, 60);
        //button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                youxi1 you = new youxi1(1000, 760);
                int result = JOptionPane.showConfirmDialog(you, "若未存档，将会丢失数据", "提示", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    SwingUtilities.invokeLater(() -> {
                        ChessGameFrame mainF = new ChessGameFrame(1000, 760);
                        mainF.setVisible(true);
                    });
                    dispose();
                }
                if (result == JOptionPane.CANCEL_OPTION) {

                }
            }
        });
    }


    private void addhuiqi() {
        JButton button = new JButton("悔棋");
        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        //button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }

    public GameController getGameController() {
        return gameController;
    }
}





