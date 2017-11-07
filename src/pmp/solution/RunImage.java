package pmp.solution;

import javax.media.jai.PlanarImage;

import pmp.Model.ResultModel;
import pmp.importclasses.Coordinate;
import pmp.importclasses.FilterCalcCentroids;
import pmp.interfaces.Writeable;
import pmp.pipes.SimplePipe;

import java.util.ArrayList;


public class RunImage {

    public static void main(String[] args) {
        //Testsink
        ImageSink sink = new ImageSink();

        CheckDeviationFilter deviationFilter = new CheckDeviationFilter(new SimplePipe<ResultModel>(sink));
        CountBallsFilter countBallsFilter = new CountBallsFilter(new SimplePipe<ResultModel>((Writeable<ResultModel>) deviationFilter));
        FilterCalcCentroids centroidsFilter = new FilterCalcCentroids(new SimplePipe<ArrayList<Coordinate>>((Writeable<ArrayList<Coordinate>>) countBallsFilter));
        DisplayFilter df5 = new DisplayFilter(new SimplePipe<PlanarImage>(centroidsFilter), "after edFilter");
        ErodeDilateFilter edFilter = new ErodeDilateFilter(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df5));
        ImageSaveFilter imageSaveFilter = new ImageSaveFilter(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) edFilter));
        DisplayFilter df4 = new DisplayFilter(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) imageSaveFilter), "after MedianFilter");
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
