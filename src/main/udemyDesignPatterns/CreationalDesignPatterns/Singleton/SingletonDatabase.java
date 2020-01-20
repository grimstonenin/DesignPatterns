package main.udemyDesignPatterns.CreationalDesignPatterns.Singleton;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class SingletonDatabase {

    private static Dictionary<String, Integer> capitals = new Hashtable<>();
    private static int instanceCount = 0;

    private static int getCount() {
        return instanceCount;
    }

    private SingletonDatabase(){
        instanceCount++;
        System.out.println("Initialising Database.");

        try{
            File file = new File(SingletonDatabase.class.getProtectionDomain().getCodeSource().getLocation().getFile());
            Path fullPath = Paths.get(file.getPath(), "stuff.txt");
            List<String> strings = Files.readAllLines(fullPath);
            for(String s : strings){
                if(strings.indexOf(s)%2==1){
                    capitals.put(s,Integer.parseInt(strings.get(strings.indexOf(s)+1)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final SingletonDatabase INSTANCE = new SingletonDatabase();

    public static SingletonDatabase getInstance(){
        return INSTANCE;
    }

    public int getPopulation(String s){
        return capitals.get(s);
    }
}
