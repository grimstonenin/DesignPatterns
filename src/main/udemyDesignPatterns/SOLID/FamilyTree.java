package main.udemyDesignPatterns.SOLID;

import java.util.ArrayList;
import java.util.List;


class Triplet<F, S, T>{
    public final F first;
    public final S second;
    public final T third;

    public Triplet(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Triplet)) {
            return false;
        }
        Triplet<?, ?, ?> p = (Triplet<?, ?, ?>) o;
        return first.equals(p.first) && second.equals(p.second) && third.equals(p.third);
    }

    private static boolean equals(Object x, Object y) {
        return (x == null && y == null) || (x != null && x.equals(y));
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode()) ^ (third == null ? 0 : third.hashCode());
    }

    public static <F, S, T> Triplet <F, S, T> create(F f, S s, T t) {
        return new Triplet<F, S, T>(f, s, t);
    }
}

enum Relationship{
    PARENT, CHILD,SIBLING
}

class Person{
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

class Relationships{
    private List<Triplet<Person,Relationship,Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child){
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }
}

class Research{
    public Research(Relationships relationships){
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.stream().filter(x -> x.first.name.equals("John")
                && x.second.equals(Relationship.PARENT))
                .forEach(ch -> System.out.println(ch.first.name + " has a child called " + ch.third.name));
    }
}

public class FamilyTree {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        Research research = new Research(relationships);

    }
}
