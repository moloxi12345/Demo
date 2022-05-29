package view;

import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class youxi1 extends JFrame {
    /**
     * 这个类表示游戏过程中的整个游戏界面
     */
    private final int WIDTH;
    private final int HEIGTH;
    public final int CHESSBOARD_SIZE;
    private GameController gameController;
    JLabel colorLabel;

    public youxi1(int width, int height) {
        setTitle("国际象棋"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.CHESSBOARD_SIZE = HEIGTH * 4 / 5;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);

        addColorLabel();
        addChessboard();
        addcundang();
        addhuiqi();
        addfanhui();
        addchongzhi();
        addbeijing();
    }

    //在游戏面板中添加背景图片
    private void addbeijing(){
        JLabel bei=new JLabel();
        bei.setSize(1000,726);
        bei.setLocation(0,0);
        bei.setIcon(new ImageIcon("C:\\Users\\86198\\OneDrive - 南方科技大学\\文档\\GitHub\\Demo\\images\\67.jpg"));
        add(bei);
    }
    /**
     * 在游戏面板中添加棋盘
     */
    private void addChessboard() {
        Chessboard chessboard = new Chessboard(CHESSBOARD_SIZE, CHESSBOARD_SIZE);
        gameController = new GameController(chessboard);
        chessboard.setColorLabel(colorLabel);
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
        cundang.setLocation(HEIGTH, HEIGTH / 10 + 240);
        cundang.setSize(200, 60);
        //button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(cundang);
        cundang.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(".");
            youxi1 you = new youxi1(1000, 760);
            fileChooser.showSaveDialog(you);
            File file = fileChooser.getSelectedFile();//获取用户选择的保存路径
            try {
                List<String> chessdata = gameController.cunDangGameAsFile();
                FileWriter fileWriter = new FileWriter(file);//向文件写入
                for (int i = 0; i < chessdata.size(); i++) {
                    fileWriter.write(chessdata.get(i));
                }
                fileWriter.close();
                SwingUtilities.invokeLater(() -> {
                    ChessGameFrame mainF = new ChessGameFrame(1000, 760);
                    mainF.setVisible(true);
                });
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
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
    private void addColorLabel() {
        colorLabel = new JLabel("欢迎来到万宁国际象棋");
        colorLabel.setLocation(HEIGTH, HEIGTH / 10);
        colorLabel.setSize(200, 60);
        colorLabel.setFont(new Font("伪宋", Font.BOLD, 20));
        add(colorLabel);
    }

    public JLabel getColorLabel() {
        return colorLabel;
    }

    public void setColorLabel(JLabel colorLabel) {
        this.colorLabel = colorLabel;
    }

    public GameController getGameController() {
        return gameController;
    }
}





