package main.udemyDesignPatterns.SOLID;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//Open Closed Principle - Open to Extension, Closed to Modification - ca sa faci ceva la clasele de mai jos trebuie sa adaugi o gramada de cod
//Solutie: Specification design pattern

enum Color
{
    RED,GREEN,BLUE
}

enum Size
{
    SMALL, MEDIUM, LARGE, HUGE
}

public class Product {

    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String toString(){
        return this.name + " " + this.color.name() + " " + this.size.name();
    }
}

class ProductFilter
{
    public Stream<Product> filterByColor(List<Product> products, Color color){
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size){
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color){
        return products.stream().filter(p -> p.size == size).filter(p -> p.color == color);
    }
}


class BetterFilter implements Filter<Product>{
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T>{
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product>{

    private Color color;

    ColorSpecification(Color color){
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpecification implements Specification<Product>{

    private Size size;

    SizeSpecification(Size size){
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class DemoOCP
{
    public static void main(String[] args){
        Product apple = new Product("apple", Color.RED, Size.SMALL);
        Product tree = new Product("tree", Color.GREEN, Size.LARGE);
        Product house = new Product("house", Color.RED, Size.HUGE);

        List<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(tree);
        products.add(house);

        ProductFilter pf = new ProductFilter();
        System.out.println("Filter by Color: RED" );
        pf.filterByColor(products,Color.RED).forEach(System.out::println);

        System.out.println("Filter by Size: HUGE" );
        pf.filterBySize(products, Size.HUGE).forEach(System.out::println);

        System.out.println();
        System.out.println("With design pattern:");
        BetterFilter betterFilter = new BetterFilter();
        betterFilter.filter(products, new ColorSpecification(Color.RED)).forEach(System.out::println);


    }
}