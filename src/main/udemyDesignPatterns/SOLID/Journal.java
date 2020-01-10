package main.udemyDesignPatterns.SOLID;

//Single Responsibility principle

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index){
        entries.remove(index);
    }

    public void save(String fileName) throws IOException {
        try(PrintStream out = new PrintStream(fileName))
        {
           out.println(toString());
        }
    }

    public String toString(){
        return String.join(System.lineSeparator(), entries);
    }
}

class Demo {
    public static void main(String[] args){
        Journal j = new Journal();
        j.addEntry("I worked today");
        j.addEntry("I went to the gym");

        System.out.println(j.toString());
    }
}
