package pmp.solution;

import pmp.filter.DataTransformationFilter1;
import pmp.interfaces.Writeable;

import javax.media.jai.PlanarImage;
import javax.media.jai.operator.MedianFilterDescriptor;
import javax.media.jai.operator.MedianFilterShape;
import java.security.InvalidParameterException;

import static javax.media.jai.operator.MedianFilterDescriptor.MEDIAN_MASK_SQUARE;

public class MedianFilter extends DataTransformationFilter1<PlanarImage> {
    public MedianFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected void process(PlanarImage entity) {
        Integer maskSize = 5;
        MedianFilterShape shape = MEDIAN_MASK_SQUARE;
        PlanarImage current = MedianFilterDescriptor.create(entity, shape, maskSize,
                null);
    }
}
