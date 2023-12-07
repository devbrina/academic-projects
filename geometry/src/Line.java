public class Line extends GeometricFigure {
    private double length;
    public Line(String color, double length){
        super(color);
        this.length = length;
    }

    @Override
    public boolean compare(GeometricFigure fig) {
        Line l = (Line) fig; //casting
        return this.length == l.length  &&  this.getColor().equals(l.getColor());
    }
}
