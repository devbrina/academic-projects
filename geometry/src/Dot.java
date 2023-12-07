public class Dot {
    private int x;
    private int y;
    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return "Dot{x=" + x + ", y=" + y+"}";
    }
    @Override
    public boolean equals(Object dot){
        Dot d = (Dot) dot;
        return this.x==d.x && this.y==d.y;
    }
    public double distance(Dot dot){
        double cath1 = this.x - dot.x;
        double cath2 = this.y - dot.y;
        return Math.sqrt(cath1*cath1 + cath2*cath2);
    }

}
