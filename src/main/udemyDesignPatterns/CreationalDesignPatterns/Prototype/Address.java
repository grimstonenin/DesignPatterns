package main.udemyDesignPatterns.CreationalDesignPatterns.Prototype;

import java.util.Arrays;

//Never implement Cloneable - better to use a copy constructor

class Person{
    public String[] names;
    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Person(names.clone(), (Address)address.clone());
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }
}

 class Address implements Cloneable{
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public Address(Address other){
        this(other.streetName, other.houseNumber);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName, houseNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}

class Employee{
    public String name;
    public Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee other){
        name = other.name;
        address = new Address(other.address); // copy constructor
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class Demo{
    public static void main(String[] args) throws CloneNotSupportedException{
        Person person1 = new Person(new String[]{"John", "Smith"}, new Address("London Road", 123));
        Person person2 = (Person) person1.clone();
        person2.names[0] = "Jane";
        person2.address.houseNumber = 124;

        System.out.println(person1);
        System.out.println(person2);
    }
}