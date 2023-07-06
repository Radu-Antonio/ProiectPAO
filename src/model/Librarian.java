package model;

import java.util.Objects;

public class Librarian extends Person {
    private double salary;

    public Librarian(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return Double.compare(librarian.salary, salary) == 0
                && Objects.equals(librarian.getName(), this.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, this.getName());
    }
}
