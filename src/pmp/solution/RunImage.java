package pmp.solution;

import javax.media.jai.PlanarImage;

import pmp.pipes.SimplePipe;

import java.awt.*;

public class RunImage {

    public static void main(String[] args) {

        ImageSink sink = new ImageSink();

        DisplayFilter df2 = new DisplayFilter(new SimplePipe<PlanarImage>(sink));
        RoiFilter rf = new RoiFilter(new SimplePipe<PlanarImage>(df2));
        DisplayFilter df1 = new DisplayFilter(new SimplePipe<PlanarImage>(rf));
        ImageSource source = new ImageSource(new SimplePipe<PlanarImage>(df1));

        source.run();
    }

}
