package pmp.solution;

import java.io.StreamCorruptedException;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

import pmp.filter.Source;
import pmp.pipes.SimplePipe;

public class ImageSource extends Source<PlanarImage> {

    String ImageSource = "C:/Users/Jan/Documents/FHV/FHV_Semester5_IBT5/Systemarchitekturen/Uebungen/Uebung2/loetstellen.jpg";
    boolean b = true;

    public ImageSource(SimplePipe<PlanarImage> simplePipe) {
        super(simplePipe);
    }

    @Override
    public PlanarImage read() throws StreamCorruptedException {
        PlanarImage current = null;
        while (b) {
            current = JAI.create("fileload", ImageSource);
            b = false;
        }
        if (!b) {
            return current;
        } else {
            return null;
        }
    }

    public void setImageSource(String imageSource) {
        ImageSource = imageSource;
    }
}
