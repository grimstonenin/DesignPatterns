package main.udemyDesignPatterns.CreationalDesignPatterns.Singleton;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton {

    private StaticBlockSingleton() throws IOException {
        System.out.println("Constructing");
        File.createTempFile(".",".");
    }

    private static StaticBlockSingleton INSTANCE;

    public static StaticBlockSingleton getINSTANCE() {
        return INSTANCE;
    }

    static{
        try{
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception e){
            System.err.println("Failed to create!");
        }
    }


}
