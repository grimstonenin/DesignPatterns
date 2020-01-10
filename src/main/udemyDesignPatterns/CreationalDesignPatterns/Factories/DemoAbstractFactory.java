package main.udemyDesignPatterns.CreationalDesignPatterns.Factories;

import javafx.util.Pair;
import sun.reflect.Reflection;

import java.util.ArrayList;
import java.util.List;

public class DemoAbstractFactory {
}

interface HotDrink{
    void consume();
}

class Tea implements HotDrink{
    @Override
    public void consume() {
        System.out.println("This tea is great!");
    }
}

class Coffee implements HotDrink{
    @Override
    public void consume() {
        System.out.println("This Coffee is great!");
    }
}

interface HotDrinkFactory{
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put tea bag!");
        System.out.println("Add" + amount + "ml hot water!");
        return new Tea();
    }
}


class CoffeeFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind beans!");
        System.out.println("Add" + amount + "ml hot water!");
        return new Coffee();
    }
}

class HotDrinkMachine{
    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine() {
//TODO - take home and download there
}

}
