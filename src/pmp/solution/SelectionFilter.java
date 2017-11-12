package pmp.solution;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import javax.media.jai.PlanarImage;
import javax.media.jai.operator.ThresholdDescriptor;
import java.security.InvalidParameterException;

public class SelectionFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {

    public SelectionFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    public SelectionFilter(Readable<PlanarImage> input) {
        super(input);
    }

    @Override
    protected PlanarImage process(PlanarImage entity) {
        double[] low = {0};
        double[] high = {35};
        double[] constants = {255};
        return entity = ThresholdDescriptor.create(entity, low, high, constants, null);
    }


}
