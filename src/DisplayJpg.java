

import javax.swing.*;
import java.awt.*;

public class DisplayJpg {

    /*
    Hardcoded window size
     */
    public static void display1()
    {
        JFrame window = new JFrame();  //create a Frame
        ImageIcon picture = new ImageIcon("src/swing.jpg");  //load a picture from computer
        JLabel label = new JLabel(picture);  //add the picture to a label

        window.add(label);  //add the label to the frame
        window.setVisible(true);  //Set the window to visible
        //set the size of the window (try modifying the width and height)
        window.setSize(400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //let the window can be close by click "x"
    }

    /*
    Adaptive window size
     */
    public static void display2(){
        JFrame window = new JFrame();  //create a Frame
        ImageIcon picture = new ImageIcon("src/swing.jpg");  //load a picture from computer
        Image image = picture.getImage();  //create an Image to change the size of the picture
        ImageIcon newpicture = new ImageIcon(image.getScaledInstance(picture.getIconWidth() / 2, picture.getIconHeight() /2, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(newpicture);  //add the picture to a label

        window.add(label);  //add the label to the frame
        window.setVisible(true);  //Set the window to visible
        //set the size of the window, 30 is the height of the window ribbon at the top
        window.setSize(newpicture.getIconWidth(), newpicture.getIconHeight() + 30);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //let the window can be close by click "x"
    }

    public static void main(String[] args) {
        display1();
        //display2();
    }


}
