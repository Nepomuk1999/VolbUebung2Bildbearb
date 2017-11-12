package pmp.solution;

import pmp.Model.Ball;
import pmp.Model.ResultModel;
import pmp.filter.Sink;
import pmp.importclasses.Coordinate;

import javax.media.jai.PlanarImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class ImageSink extends Sink<ResultModel> {
    String outputpath = "C:/Users/Jan/Documents/FHV/FHV_Semester5_IBT5/Systemarchitekturen/Uebungen/Uebung2/Output/";
    String filename = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());

    String output = outputpath + filename;
    StringBuilder sb = new StringBuilder();

    LinkedList<Coordinate> startcoordinates;
    int range;


    @Override
    public void write(ResultModel value) throws StreamCorruptedException {
        if (value != null) {
            sb.append("Uebung 2: Bildverarbeitung in einer Pipes&Filters Architektur:").append(System.lineSeparator());
            sb.append("File: " + filename).append(System.lineSeparator());
            sb.append("Range: " + range + "%").append(System.lineSeparator());
            sb.append(System.lineSeparator());
            sb.append("Input: ").append(System.lineSeparator());
            int i = startcoordinates.size();
            for (Coordinate coordinate : startcoordinates) {
                sb.append("Centroid " + i + ": " + coordinate.toString()).append(System.lineSeparator());
                i--;
            }
            sb.append(System.lineSeparator());
            sb.append("Output: ").append(System.lineSeparator());
            i = value.getBalls().size();
            for (Ball ball : value.getBalls()) {
                sb.append("Centroid " + i + ": " + ball.getCoordinates().toString() + " " + ball.getIsInTolerance()).append(System.lineSeparator());
                i--;
            }
            sb.append(System.lineSeparator());
            try {
                System.out.println("File: " + filename);
                OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File(output)), StandardCharsets.UTF_8);
                out.write(sb.toString());
                out.flush();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void setStartcoordinates(LinkedList<Coordinate> sc){
        startcoordinates = sc;
    }

    public void setrange(int r){
        range = r;
    }
}
