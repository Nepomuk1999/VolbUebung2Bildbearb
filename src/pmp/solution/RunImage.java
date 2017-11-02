package pmp.solution;

import javax.media.jai.PlanarImage;

import pmp.pipes.SimplePipe;

public class RunImage {

    public static void main(String[] args) {

        DisplayFilter df = new DisplayFilter(null);
        ImageSource source = new ImageSource(new SimplePipe<PlanarImage>(df));


        source.run();
    }

}
