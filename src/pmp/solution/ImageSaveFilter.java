package pmp.solution;

import pmp.filter.ForwardingFilter;
import pmp.interfaces.Writeable;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.FileStoreDescriptor;
import java.security.InvalidParameterException;

public class ImageSaveFilter extends ForwardingFilter<PlanarImage> {

    String fileOutputPath = "C:/Users/Jan/Documents/FHV/FHV_Semester5_IBT5/Systemarchitekturen/Uebungen/Uebung2/Output/";

    public ImageSaveFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected boolean forward(PlanarImage entity) {
        String filename = "" + System.currentTimeMillis();
        PlanarImage current = FileStoreDescriptor.create(entity, fileOutputPath + filename,
                "tiff", null, true, null);
        System.out.println("ImageFile: " + filename);
        return true;
    }
}
