//import view.ChessGameFrame;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class BianJiinterface {
//    //组件
//    JFrame jf = new JFrame("编辑你的信息");
//    final int WIDTH = 500;
//    final int HEIGHT = 400;
//
//    //组装
//    public void init() {
//        JPanel jp=new JPanel();
//        int w = Toolkit.getDefaultToolkit().getScreenSize().width;//获取当前屏幕的宽度
//        int h = Toolkit.getDefaultToolkit().getScreenSize().height;//获取当前屏幕的高度
//        jf.setBounds((w - WIDTH) / 2, (h - HEIGHT) / 2, WIDTH, HEIGHT);
//        jf.setResizable(false);
//        Box vbox = Box.createVerticalBox();
//        //组装昵称
//        Box ubox = Box.createHorizontalBox();
//        JLabel name = new JLabel("昵称");
//        JTextField namek = new JTextField(15);
//        ubox.add(name);
//        ubox.add(Box.createHorizontalStrut(20));
//        ubox.add(namek);
//        //组装年龄
//        Box nbox = Box.createHorizontalBox();
//        JLabel age = new JLabel("年龄");
//        JTextField agek = new JTextField(15);
//        nbox.add(age);
//        nbox.add(Box.createHorizontalStrut(20));
//        nbox.add(agek);
//        //组装手机号
//        Box pbox = Box.createHorizontalBox();
//        JLabel phone = new JLabel("手机号");
//        JTextField phonek = new JTextField(15);
//        pbox.add(phone);
//        pbox.add(Box.createHorizontalStrut(20));
//        pbox.add(phonek);
//        //组装性别
//        Box xbox = Box.createHorizontalBox();
//        JLabel sex = new JLabel("性别");
//        JRadioButton male = new JRadioButton("男", false);
//        JRadioButton female = new JRadioButton("女", false);
//        ButtonGroup bg = new ButtonGroup();
//        bg.add(male);
//        bg.add(female);
//        xbox.add(sex);
//        xbox.add(Box.createHorizontalStrut(20));
//        xbox.add(male);
//        xbox.add(female);
//        xbox.add(Box.createHorizontalStrut(120));
//        //返回主界面
//        Box tbox=Box.createHorizontalBox();
//        JButton xiugai =new JButton("修改");
//        JButton baocun=new JButton("保存");
//        JButton fanhui=new JButton("返回");
//        fanhui.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new ChessGameFrame
//                        jf.dispose();
//            }
//        });
//        baocun.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //获取输入的信息
//                String username=namek.getText().trim();
//                String userage=agek.getText().trim();
//                String userphine=phonek.getText().trim();
//                String usersex=bg.isSelected(male.getModel())? male.getText() : female.getText();
//                //访问接口
//            }
//        });
//        tbox.add(xiugai);
//        tbox.add(Box.createHorizontalStrut(40));
//        tbox.add(baocun);
//        tbox.add(Box.createHorizontalStrut(40));
//        tbox.add(fanhui);
//        //组装竖直box
//        vbox.add(Box.createVerticalStrut(50));
//        vbox.add(ubox);
//        vbox.add(Box.createVerticalStrut(20));
//        vbox.add(nbox);
//        vbox.add(Box.createVerticalStrut(20));
//        vbox.add(pbox);
//        vbox.add(Box.createVerticalStrut(20));
//        vbox.add(xbox);
//        vbox.add(Box.createVerticalStrut(20));
//        vbox.add(tbox);
//        //
//        jp.add(vbox);
//        jf.add(jp);
//        //
//        jf.setVisible(true);
//
//    }
//
//}
