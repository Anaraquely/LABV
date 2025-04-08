package org.example.tdd.exercicio2;
import java.util.ArrayList;
import java.util.List;

public class Person {
    int id;
    String name;
    int age;
    private List<Email> emails = new ArrayList<>();

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addEmail(Email email) {
        emails.add(email);
    }

    public List<Email> getEmails() {
        return emails;
    }
}
