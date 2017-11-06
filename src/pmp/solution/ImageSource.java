package pmp.solution;

import java.io.StreamCorruptedException;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

import pmp.filter.Source;
import pmp.pipes.SimplePipe;

public class ImageSource extends Source<PlanarImage> {

    String ImageSource = "C:/Users/Home/Desktop/Semester 5/Systemarchitektur/Übungen/Aufgabe 2/loetstellen.jpg";

    public ImageSource(SimplePipe<PlanarImage> simplePipe) {
        super(simplePipe);
    }

    @Override
    public PlanarImage read() throws StreamCorruptedException {
        for (int ki = 1; ki > 0; ki--) {
            PlanarImage image = JAI.create("fileload", ImageSource);
            return image;
        }
        return null;
    }

}
