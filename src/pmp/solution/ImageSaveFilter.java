package pmp.solution;

import pmp.filter.ForwardingFilter;
import pmp.interfaces.Writeable;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.FileStoreDescriptor;
import java.security.InvalidParameterException;

public class ImageSaveFilter extends ForwardingFilter<PlanarImage> {

    String fileOutputPath = "C:/Users/Home/Desktop/Semester 5/Systemarchitektur/Übungen/Aufgabe 2/Output/";

    public ImageSaveFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected boolean forward(PlanarImage entity) {
        PlanarImage current = FileStoreDescriptor.create(entity, fileOutputPath + System.currentTimeMillis(),
                "tiff", null, true, null);

        return true;
    }
}
