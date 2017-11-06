package pmp.solution;

import com.sun.media.jai.widget.DisplayJAI;
import pmp.pipes.SimplePipe;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import  java.awt.Rectangle;

public class TestMain {

    public static void main(String[] args) {

        String ImageSource = "C:\\Users\\Jan\\Documents\\FHV\\FHV_Semester5_IBT5\\Systemarchitekturen\\Uebungen\\Uebung2\\loetstellen.jpg";

        PlanarImage image = JAI.create("fileload", ImageSource);

        JFrame frame = new JFrame();
        frame.setTitle("file");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        DisplayJAI dj = new DisplayJAI(image);
        contentPane.add(new JScrollPane(dj), BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);

        Rectangle rectangle = new Rectangle(0, 34, image.getWidth(), image.getHeight()/4);

        //PlanarImage renderdimage = PlanarImage.wrapRenderedImage((Image)image.getAsBufferedImage(rectangle, image.getColorModel()));



    }

}
