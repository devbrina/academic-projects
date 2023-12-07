public class Circle extends GeometricFigure implements Calculate {
    private double ratio;
    private Dot center;
    public Circle(int x, int y,  double ratio, String color){
        super(color);
        this.center = new Dot(x, y);
        this.ratio = ratio;
    }
    @Override
    public boolean compare(GeometricFigure fig) {
        Circle c = (Circle) fig; //casting
        return this.center.equals(c.center) &&
                this.ratio == c.ratio &&
                this.getColor().equals(c.getColor());
    }
    @Override
    public double area() {
        //A = π * r2
        return Math.PI * this.ratio*this.ratio;
    }
    @Override
    public double perimeter() {
        //P = 2π * r
        return 2*Math.PI * (this.ratio);
    }
    public boolean intersection (Circle c){
        //If the distance of circle centers are lower than the sum of the ratios, then it areoverlapping
        double centerDistance = this.center.distance(c.center);
        return centerDistance <= this.ratio + c.ratio;
    }
}


