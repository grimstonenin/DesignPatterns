package main.udemyDesignPatterns.SOLID;

//Interface Segregation Principle - nu pune mai mult intr-o interfata decat se asteapta un user sa fie


import sun.applet.Main;

public class Document {
}

interface Machine{
    void print(Document document);
    void fax(Document document);
    void scan(Document document);
}

class MultiFunctionMachine implements Machine{
    @Override
    public void print(Document document) {

    }

    @Override
    public void fax(Document document) {

    }

    @Override
    public void scan(Document document) {

    }
}

class OldSchoolPrinter implements Machine{
    @Override
    public void print(Document document) {

    }

    @Override
    public void fax(Document document) {

    }

    @Override
    public void scan(Document document) {

    }
}