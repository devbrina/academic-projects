public abstract class GeometricFigure {
    private String color;
    //an abstract class can have concrete and abstract methods
    public GeometricFigure(String color){
        this.color=color;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public abstract boolean compare(GeometricFigure fig);
}
