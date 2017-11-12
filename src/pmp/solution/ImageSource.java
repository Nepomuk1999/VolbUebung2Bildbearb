package pmp.solution;

import java.io.StreamCorruptedException;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

import pmp.filter.Source;
import pmp.interfaces.Writeable;
import pmp.interfaces.Readable;
import pmp.pipes.SimplePipe;

public class ImageSource extends Source<PlanarImage> {
    String ImageSource;
    boolean b = true;

    //public ImageSource(SimplePipe<PlanarImage> simplePipe) {
    //    super(simplePipe);
    //}

    public ImageSource(){
    }

    public ImageSource(Readable<PlanarImage> output){

    }

    public ImageSource(Writeable<PlanarImage> output){
        super(output);
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
