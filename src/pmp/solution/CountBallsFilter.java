package pmp.solution;

import pmp.Model.ResultModel;
import pmp.filter.DataTransformationFilter2;
import pmp.importclasses.Coordinate;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class CountBallsFilter extends DataTransformationFilter2<ArrayList<Coordinate>, ResultModel> {

    public CountBallsFilter(Writeable<ResultModel> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected ResultModel process(ArrayList<Coordinate> entity) {
        if (entity != null) {
            return new ResultModel(entity);
        } else {
            return null;
        }
    }
}
