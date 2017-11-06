package pmp.solution;

import pmp.filter.DataTransformationFilter1;
import pmp.interfaces.Writeable;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.ThresholdDescriptor;
import java.security.InvalidParameterException;

public class SelectionFilter extends DataTransformationFilter1<PlanarImage> {

    public SelectionFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected void process(PlanarImage entity) {
        double[] low = {0, 30.00000};
        double[] high = {30.00001, 0};
        double[] constants = {255};
        PlanarImage current = ThresholdDescriptor.create(entity, low, high, constants, null);
    }


}
