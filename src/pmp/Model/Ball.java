package pmp.Model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import pmp.importclasses.Coordinate;

public class Ball {

    Coordinate focus;
    Boolean isInTolerance;
    Integer expansion;

    public Ball(Coordinate focusOfEntity) {
        focus = focusOfEntity;
    }

    public Coordinate getCoordinates() {
        return focus;
    }

    public void setIsInTolerance(Boolean b) {
        isInTolerance = b;
    }

    public String getIsInTolerance() {
        if (isInTolerance != null) {
            if (isInTolerance == true) {
                return "Focus is in tolerance range.";
            } else {
                return "Focus is not in tolerance range.";
            }
        } else {
            return "tolerance not checked";
        }
    }
}
