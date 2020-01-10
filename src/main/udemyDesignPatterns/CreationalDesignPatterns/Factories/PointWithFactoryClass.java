package main.udemyDesignPatterns.CreationalDesignPatterns.Factories;

public class PointWithFactoryClass {
    private double x, y;

    private PointWithFactoryClass(double x, double y) {
        this.x = x;
        this.y = y;
    }

   public static class Factory{
        public static PointWithFactoryClass newCartesianPoint(double x, double y){
            return new PointWithFactoryClass(x,y);
        }
        public static PointWithFactoryClass newPolarPoint(double rho, double theta){
            return new PointWithFactoryClass(rho * Math.cos(theta),theta * Math.sin(theta));
        }
    }

}


class DemoWithFactory{
    public static void main(String[] args) {
        PointWithFactoryClass newPolarPoint = PointWithFactoryClass.Factory.newPolarPoint(1.0, 2.0);
    }
}

