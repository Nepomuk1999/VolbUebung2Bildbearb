package pmp.solution;

import javax.lang.model.util.SimpleElementVisitor6;
import javax.media.jai.PlanarImage;

import pmp.Model.ResultModel;
import pmp.importclasses.Coordinate;
import pmp.importclasses.FilterCalcCentroids;
import pmp.interfaces.Writeable;
import pmp.pipes.SimplePipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import pmp.interfaces.Readable;


public class RunImage {

    public static void main(String[] args) throws IOException {
        int range;
        int pushorpull = 0;
        String inputFilePath;
        LinkedList<Coordinate> coordinates = new LinkedList<>();

        //expected Coordinates
        coordinates.add(new Coordinate(73,77));
        coordinates.add(new Coordinate(110,80));
        coordinates.add(new Coordinate(202,80));
        coordinates.add(new Coordinate(265,79));
        coordinates.add(new Coordinate(330,81));
        coordinates.add(new Coordinate(396,81));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter path of file you want to read from:");
        inputFilePath = br.readLine();

        System.out.print("Enter expected range(cross-section dimension):");
        range = Integer.parseInt(br.readLine());

        System.out.print("Enter 0 for Push and 1 for Pull:");
        pushorpull = Integer.parseInt(br.readLine());

        if(pushorpull == 0) {
            System.out.println("PUSH");
            ImageSink sink = new ImageSink();
            CheckDeviationFilter deviationFilter = new CheckDeviationFilter((Writeable<ResultModel>) new SimplePipe<ResultModel>(sink), coordinates, range);
            CountBallsFilter countBallsFilter = new CountBallsFilter(new SimplePipe<ResultModel>((Writeable<ResultModel>) deviationFilter));
            FilterCalcCentroids centroidsFilter = new FilterCalcCentroids(new SimplePipe<ArrayList<Coordinate>>((Writeable<ArrayList<Coordinate>>) countBallsFilter));
            DisplayFilter df5 = new DisplayFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>(centroidsFilter), "after edFilter");
            ErodeDilateFilter edFilter = new ErodeDilateFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df5));
            ImageSaveFilter imageSaveFilter = new ImageSaveFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) edFilter));
            DisplayFilter df4 = new DisplayFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) imageSaveFilter), "after MedianFilter");
            MedianFilter medianFilter = new MedianFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df4));
            DisplayFilter df3 = new DisplayFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) medianFilter), "after SelectionFilter");
            SelectionFilter selectionFilter = new SelectionFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df3));
            DisplayFilter df2 = new DisplayFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) selectionFilter), "after RoiFilter");
            RoiFilter rf = new RoiFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df2));
            DisplayFilter df1 = new DisplayFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) rf), "after Source");
            ImageSource source = new ImageSource((Writeable) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df1));

            source.setImageSource(inputFilePath);
            sink.setStartcoordinates(coordinates);
            sink.setrange(range);
            source.run();

        } else {
            System.out.println("PULL");
            ImageSource source = new ImageSource();
            DisplayFilter df1 = new DisplayFilter((Readable) new SimplePipe<PlanarImage>((Readable)source), "after Source");
            RoiFilter rf = new RoiFilter((Readable) new SimplePipe<PlanarImage>((Readable)df1));
            DisplayFilter df2 = new DisplayFilter((Readable) new SimplePipe<PlanarImage>((Readable)rf), "after RoiFilter");
            SelectionFilter selectionFilter = new SelectionFilter((Readable) new SimplePipe<PlanarImage>((Readable)df2));
            DisplayFilter df3 = new DisplayFilter((Readable) new SimplePipe<PlanarImage>((Readable)selectionFilter), "after SelectionFilter");
            MedianFilter medianFilter = new MedianFilter((Readable) new SimplePipe<PlanarImage>((Readable)df3));
            DisplayFilter df4 = new DisplayFilter((Readable) new SimplePipe<PlanarImage>((Readable) medianFilter), "after MedianFilter");
            ImageSaveFilter imageSaveFilter = new ImageSaveFilter((Readable) new SimplePipe<PlanarImage>((Readable) df4));
            ErodeDilateFilter erodeDilateFilter = new ErodeDilateFilter((Readable) new SimplePipe<PlanarImage>((Readable)imageSaveFilter));
            DisplayFilter df5 = new DisplayFilter((Readable) new SimplePipe<PlanarImage>((Readable) erodeDilateFilter), "after edFilter");
            FilterCalcCentroids filterCalcCentroids = new FilterCalcCentroids((Readable)new SimplePipe<ArrayList<Coordinate>>((Readable)df5));
            CountBallsFilter countBallsFilter = new CountBallsFilter((Readable)new SimplePipe<ResultModel>((Readable)filterCalcCentroids));
            CheckDeviationFilter deviationFilter = new CheckDeviationFilter((Readable)new SimplePipe<ResultModel>((Readable)countBallsFilter), coordinates, range);
            ImageSink sink = new ImageSink(deviationFilter);

            source.setImageSource(inputFilePath);
            sink.setStartcoordinates(coordinates);
            sink.setrange(range);
            sink.run();
        }

    }
}
