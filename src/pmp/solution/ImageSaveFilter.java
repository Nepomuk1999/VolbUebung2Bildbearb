package pmp.solution;

import pmp.filter.ForwardingFilter;
import pmp.interfaces.Writeable;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.FileStoreDescriptor;
import java.security.InvalidParameterException;

public class ImageSaveFilter extends ForwardingFilter<PlanarImage> {
    public ImageSaveFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected boolean forward(PlanarImage entity) {
        PlanarImage current = FileStoreDescriptor.create(entity, "bearbeitetesBild" + System.currentTimeMillis(),
                "JPG", null, true, null);

        return true;
    }
}
