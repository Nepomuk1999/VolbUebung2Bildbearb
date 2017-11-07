package pmp.solution;

import pmp.Model.ResultModel;
import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;

public class CheckDeviationFilter extends DataTransformationFilter2<ResultModel, ResultModel> {


    public CheckDeviationFilter(Writeable<ResultModel> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected ResultModel process(ResultModel entity) {
        return null;
    }
}
