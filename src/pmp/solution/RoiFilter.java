package pmp.solution;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Writeable;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.security.InvalidParameterException;

public class RoiFilter extends DataTransformationFilter2<PlanarImage,PlanarImage> {

    public RoiFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected PlanarImage process(PlanarImage nextVal) {
        PlanarImage image = nextVal;
        Rectangle rectangle = new Rectangle(10, 35, image.getWidth(), image.getHeight() / 4);
        nextVal = PlanarImage.wrapRenderedImage(image.getAsBufferedImage(rectangle, image.getColorModel()));
        nextVal.setProperty("offsetX", 10);
        nextVal.setProperty("offsetY", 35);
        return nextVal;
    }

}
