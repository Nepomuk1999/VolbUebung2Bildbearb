package pmp.solution;

import javax.media.jai.PlanarImage;

import pmp.filter.Sink;
import pmp.pipes.SimplePipe;

public class RunImage {

    public static void main(String[] args) {

        DisplayFilter df = new DisplayFilter(new Sink<>());
        ImageSource source = new ImageSource(new SimplePipe<PlanarImage>(df));


        source.run();
    }

}
