package main.udemyDesignPatterns.CreationalDesignPatterns.Factories;

//factory methods - repara problema ca nu poti avea constructorul cu un nume specific

enum CoordinateSystem{
    CARTESIAN, POLAR
}

public class Point {
    private double x, y;

//    private Point(double x, double y, CoordinateSystem coordinateSystem) {
//        switch (coordinateSystem){
//            case POLAR:
//            {
//             this.x = x * Math.cos(y);
//             this.y = x * Math.sin(y);
//             break;
//            }
//            case CARTESIAN:
//            {
//                this.x = x;
//                this.y = y;
//                break;
//            }
//        }
//    }

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x, double y){
        return new Point(x,y);
    }

    public static Point newPolarPoint(double rho, double theta){
        return new Point(rho * Math.cos(theta),theta * Math.sin(theta));
    }
}

class DemoFactory{
    public static void main(String[] args) {
        Point cartesianPoint = Point.newCartesianPoint(1.0, 2.0);
        Point polarPoint = Point.newPolarPoint(2.0, 3.0);
    }
}