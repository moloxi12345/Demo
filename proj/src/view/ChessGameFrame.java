package view;

import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGTH;
    private static Image chess;

    public ChessGameFrame(int width, int height) {
        setTitle("2022 CS102A Project Demo"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);

        addLabel();
        addHelloButton();
        addLoadButton();
        addzhuceButton();
        addzhutiButton();
        addlable();
    }


    /**
     * 在游戏面板中添加棋盘
     */
    private void addlable() {
        JLabel jo = new JLabel();
        jo.setSize(729, 729);
        jo.setLocation(0, 0);
        Image image;
        jo.setIcon(new ImageIcon("C:\\Users\\九思而后行。\\IdeaProjects\\Demo\\images\\chan.png"));
        add(jo);
    }

    /**
     * 在游戏面板中添加标签
     */
    private void addLabel() {
        JLabel statusLabel = new JLabel("欢迎来到万宁国际象棋");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addHelloButton() {
        JButton button = new JButton("开始新游戏");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    youxi1 youxiF = new youxi1(1000, 760);
                    youxiF.setVisible(true);
                });
                dispose();
            }
        });
        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        //button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }

    private void addLoadButton() {
        JButton button = new JButton("读档");
        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button.setSize(200, 60);
        //button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            youxi1 youxiF = new youxi1(1000, 760);
            String path = JOptionPane.showInputDialog(this, "Input Path here");
            youxiF.getGameController().loadGameFromFile(path);
            youxiF.setVisible(true);
            dispose();
        });

    }

    private void addzhuceButton() {
        JButton button = new JButton("用户信息");
        button.setLocation(HEIGTH, HEIGTH / 10 + 360);
        button.setSize(200, 60);
        //button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);


    }

    private void addzhutiButton() {
        JButton button = new JButton("主题风格");
        button.setLocation(HEIGTH, HEIGTH / 10 + 480);
        button.setSize(200, 60);
        //button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }
}
