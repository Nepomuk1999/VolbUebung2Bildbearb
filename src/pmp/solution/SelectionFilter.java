package pmp.solution;

import pmp.filter.DataTransformationFilter1;
import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Writeable;

import javax.media.jai.PlanarImage;
import javax.media.jai.operator.ThresholdDescriptor;
import java.security.InvalidParameterException;

public class SelectionFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {

    public SelectionFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected PlanarImage process(PlanarImage entity) {
        double[] low = {0, 80};
        double[] high = {0, 0};
        double[] constants = {255, 255};
        return entity = ThresholdDescriptor.create(entity, low, high, constants, null);
    }


}
