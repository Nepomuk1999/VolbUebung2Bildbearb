package pmp.solution;

import java.awt.BorderLayout;
import java.awt.Container;
import java.security.InvalidParameterException;

import javax.media.jai.PlanarImage;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.sun.media.jai.widget.DisplayJAI;

import pmp.filter.ForwardingFilter;
import pmp.interfaces.Writeable;

public class DisplayFilter extends ForwardingFilter<PlanarImage> {

    public DisplayFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected boolean forward(PlanarImage entity) {
        JFrame frame = new JFrame();
        frame.setTitle("file");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        //ParameterBlock pb = new ParameterBlock();
        //pb.add(entity);
        DisplayJAI dj = new DisplayJAI(entity);
        contentPane.add(new JScrollPane(dj), BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
        return true;
    }

}
