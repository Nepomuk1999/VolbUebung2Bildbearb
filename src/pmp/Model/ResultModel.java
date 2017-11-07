package pmp.Model;


import pmp.importclasses.Coordinate;

import java.util.LinkedList;
import java.util.List;

public class ResultModel {

    List<Ball> balls;

    public ResultModel(List<Coordinate> entity) {
        balls = new LinkedList<Ball>();
        for (Coordinate c : entity) {
            Ball currentBall = new Ball(c);
            balls.add(currentBall);
        }
    }
}
