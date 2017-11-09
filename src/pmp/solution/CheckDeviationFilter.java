package pmp.solution;

import pmp.Model.Ball;
import pmp.Model.ResultModel;
import pmp.filter.DataTransformationFilter2;
import pmp.importclasses.Coordinate;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.LinkedList;

public class CheckDeviationFilter extends DataTransformationFilter2<ResultModel, ResultModel> {

    LinkedList<Coordinate> _expectedCentroids;
    Integer _range;

    public CheckDeviationFilter(Writeable<ResultModel> output, LinkedList<Coordinate> expectedCentroids, Integer range)
            throws InvalidParameterException {
        super(output);
        _range = range;
        _expectedCentroids = expectedCentroids;
    }

    @Override
    protected ResultModel process(ResultModel entity) {
        for (Ball ball : entity.getBalls()) {
            ball.setIsInTolerance(isInTolerance(ball.getCoordinates()));
        }
        return entity;
    }

    private Boolean isInTolerance(Coordinate toCheck) {
        int xToCheck = toCheck._x;
        int yToCheck = toCheck._y;
        for (Coordinate c : _expectedCentroids) {
            if (xToCheck >= (c._x - _range / 2) && xToCheck <= (c._x + _range / 2)) {
                if (yToCheck >= (c._y - _range / 2) && yToCheck <= (c._y + _range / 2)) {
                    return true;
                }
            }
        }
        return false;
    }


}
