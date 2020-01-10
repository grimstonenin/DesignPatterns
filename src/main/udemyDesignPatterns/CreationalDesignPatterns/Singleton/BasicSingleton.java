package main.udemyDesignPatterns.CreationalDesignPatterns.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BasicSingleton implements Serializable {

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private BasicSingleton(){
    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance(){
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "BasicSingleton{" +
                "value=" + value +
                '}';
    }
}

class Demo{

    static void saveToFile(BasicSingleton basicSingleton, String fileName) throws Exception{
        try(FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(basicSingleton);
        }
    }

    static BasicSingleton readFromFile(String fileName) throws Exception{
        try(FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            return (BasicSingleton) objectInputStream.readObject();
        }
    }

    public static void main(String[] args) throws Exception{
        BasicSingleton basicSingleton = BasicSingleton.getInstance();
        basicSingleton.setValue(111);
        System.out.println(basicSingleton.getValue());

        String fileName = "singleton.bin";
        saveToFile(basicSingleton, fileName);

        basicSingleton.setValue(222);

        BasicSingleton basicSingleton2 = readFromFile(fileName);

        System.out.println(basicSingleton);
        System.out.println(basicSingleton2);

        //not equal
    }
}