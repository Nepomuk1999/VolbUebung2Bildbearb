package pmp.test;

import com.sun.media.jai.widget.DisplayJAI;
import pmp.pipes.SimplePipe;

import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import  java.awt.Rectangle;

public class TestMain {

    public static void main(String[] args) {

        //READ
        String ImageSource = "C:\\Users\\Jan\\Documents\\FHV\\FHV_Semester5_IBT5\\Systemarchitekturen\\Uebungen\\Uebung2\\loetstellen.jpg";
        PlanarImage image = JAI.create("fileload", ImageSource);

        //Show 1
        //showPIC(image);

        Rectangle rectangle = new Rectangle(0, 34, image.getWidth(), image.getHeight()/4);
        PlanarImage renderdimage = PlanarImage.wrapRenderedImage(image.getAsBufferedImage(rectangle, image.getColorModel()));

        //Show 2
        showPIC(renderdimage);







    }




    public static void showPIC(PlanarImage image){
        JFrame frame = new JFrame();
        frame.setTitle("file");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        DisplayJAI dj = new DisplayJAI(image);
        contentPane.add(new JScrollPane(dj), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }


}
