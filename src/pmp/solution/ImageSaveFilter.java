package pmp.solution;

import pmp.filter.ForwardingFilter;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

public class ImageSaveFilter extends ForwardingFilter<PlanarImage> {

    public ImageSaveFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    public ImageSaveFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    protected boolean forward(PlanarImage entity) {
        String filename = "" + System.currentTimeMillis() + ".jpg";
        try {
            ImageIO.write(entity, "JPG",new File(/*fileOutputPath +*/ filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ImageFile: " + filename);
        return true;
    }
}
