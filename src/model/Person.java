package model;

public abstract class Person {
    static int currId = 0;
    protected int id;
    private String name;

    public Person(String name) {
        this.id = currId++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
