package pawninfo;

public class Pawn {
    private String pawnName;
    private String color;
    private static final String DEFAULT_COLOR = "white";

    public Pawn(String fistPawnName, String color) {
        this.pawnName = fistPawnName;
        this.color = color;
    }

    public Pawn(String pawnName) {
        this.pawnName = pawnName;
        this.color = DEFAULT_COLOR;
    }

    public String getColor() {
        return color;
    }

    public String getPawnName() {
        return pawnName;
    }
}
