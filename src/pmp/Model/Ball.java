package pmp.Model;

import pmp.importclasses.Coordinate;

public class Ball {

    Coordinate focus;
    Boolean isInTolerance;
    Integer expansion;

    public Ball(Coordinate focusOfEntity) {
        focus = focusOfEntity;
    }
}
