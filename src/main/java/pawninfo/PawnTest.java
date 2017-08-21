package pawninfo;

import junit.framework.TestCase;

import static junit.framework.Assert.assertEquals;

public class PawnTest extends TestCase {
    private final String fistPawnName = "zuZi";
    private final String defaultColor = "white";
    private final String firstColor = "black";
    private final String secondPawnName = "pawn";

    public void testCreate() {
        Pawn pawn = new Pawn(fistPawnName, defaultColor);
        assertEquals(defaultColor, pawn.getColor());
    }

//    public void testCreateTwo() {
//        Pawn pawnTwo = new Pawn(secondPawnName);
//    }

}
