package pmp.solution;

import javax.media.jai.PlanarImage;

import pmp.interfaces.Writeable;
import pmp.pipes.SimplePipe;



public class RunImage {

    public static void main(String[] args) {
        //Testsink
        ImageSink sink = new ImageSink();


        DisplayFilter df4 = new DisplayFilter(new SimplePipe<PlanarImage>(sink), "after MedianFilter");
        MedianFilter medianFilter = new MedianFilter(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df4));
        DisplayFilter df3 = new DisplayFilter(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) medianFilter), "after SelectionFilter");
        SelectionFilter selectionFilter = new SelectionFilter(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df3));
        DisplayFilter df2 = new DisplayFilter(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) selectionFilter), "after RoiFilter");
        RoiFilter rf = new RoiFilter(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df2));
        DisplayFilter df1 = new DisplayFilter(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) rf), "after Source");
        ImageSource source = new ImageSource(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df1));

        source.run();
    }

}
