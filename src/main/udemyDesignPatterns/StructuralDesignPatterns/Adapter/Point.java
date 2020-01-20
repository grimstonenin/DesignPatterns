package main.udemyDesignPatterns.StructuralDesignPatterns.Adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {
    Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
}

class VectorObject extends ArrayList<Line>{

}

class VectorRectangle extends VectorObject{
    public VectorRectangle(int x, int y, int width, int height) {
        add(new Line(new Point(x,y), new Point(x+width, y)));
        add(new Line(new Point(x+width, y), new Point(x+width, y+height)));
        add(new Line(new Point(x,y), new Point(x,y+height)));
        add(new Line(new Point(x, y+height), new Point(x+width, y+height)));
    }
}

class LineToPointAdapter extends ArrayList<Point>{
    public static int count = 0;

    public LineToPointAdapter(Line line) {
        System.out.println(String.format("%d Generating points for line: [%d,%d] : [%d,%d] (no caching)",
                ++count, line.start.x, line.start.y, line.end.x, line.end.y));
        int left = Math.min(line.start.x, line.start.y);
        int right = Math.max(line.start.x, line.start.y);
        int top = Math.min(line.start.y, line.end.y);
        int bottom = Math.max(line.start.y, line.end.y);
        int dx = right - left;
        int dy = line.end.x - line.start.y;

        if(dx == 0){
            for(int y = top; y <= bottom; ++y){
                add(new Point(left, y));
            }
        } else if (dy == 0){
            for(int x = left; x <= right; ++x){
                add(new Point(x, top));
            }
        }
    }
}

class Demo{
    private static final List<VectorObject> vectorObjects = new ArrayList<>();
    private static void drawPoint(Point p){
        System.out.println(".");
    }

    private static void draw(){
        for(VectorObject v: vectorObjects){
            for(Line line: v){
                LineToPointAdapter points = new LineToPointAdapter(line);
                points.forEach(Demo::drawPoint);
            }
        }
    }

    public static void main(String[] args) {
        vectorObjects.add(new VectorRectangle(1,1, 10, 10));
        vectorObjects.add( new VectorRectangle(3,3,6,6));

        draw();
    }
}
