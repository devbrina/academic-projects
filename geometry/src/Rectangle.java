public class Rectangle extends GeometricFigure implements Calculate {
    private double base;
    private double height;
    public Rectangle(String color, double base, double height){
        super(color);
        this.base = base;
        this.height = height;
    }
    public boolean compare (GeometricFigure fig){
        Rectangle  r = (Rectangle) fig; //casting
        return r.base == this.base && r.height == this.height
                && this.getColor().equals(r.getColor());
    }

    @Override
    public double area() {
        return this.base * this.height;
    }
    @Override
    public double perimeter() {
        return 2*(this.base + this.height);
    }
}
