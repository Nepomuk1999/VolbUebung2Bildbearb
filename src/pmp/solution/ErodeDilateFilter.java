package pmp.solution;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Writeable;

import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.DilateDescriptor;
import java.security.InvalidParameterException;

public class ErodeDilateFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {
    KernelJAI kernel;

    public ErodeDilateFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
        float[] kernelMatrix = new float[]{0, 50, 50, 0
                , 50, 0, 0, 50
                , 50, 0, 0, 50
                , 0, 50, 50, 0};
        kernel = new KernelJAI(4, 4, kernelMatrix);
    }

    @Override
    protected PlanarImage process(PlanarImage entity) {
        return entity = DilateDescriptor.create(entity, kernel, null);
    }
}
