package pmp.solution;

import pmp.Model.Ball;
import pmp.Model.ResultModel;
import pmp.filter.Sink;

import javax.media.jai.PlanarImage;
import java.io.StreamCorruptedException;

public class ImageSink extends Sink<ResultModel> {


    @Override
    public void write(ResultModel value) throws StreamCorruptedException {
        if (value != null) {
            for (Ball ball : value.getBalls()) {
                System.out.println(ball.getCoordinates().toString() + " " + ball.getIsInTolerance());
            }
        }
    }

}
