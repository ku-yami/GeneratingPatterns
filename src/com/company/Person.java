package com.company;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    // Имя (String). Каждый человек обязан иметь имя, причём с момента создания объекта изменить его
    // нельзя.
    protected final String name;

    // Фамилия (String). Каждый человек обязан иметь фамилию, причём с момента создания объекта
    // изменить её нельзя.
    protected final String surname;

    // Возраст (int). Если возраст человека известен, то с момента создания объекта он может быть
    // изменён только увеличением на единицу через вызов метода happyBirthday().
    protected int age;

    // Текущий город жительства (String). Может быть известен (в этом случае метод boolean
    // hasAddress() должен вернуть true, иначе - false) и выставлен в любой через setAddress(String
    // city).
    private String address;

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return hasAddress() ? address : "";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = -1;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(surname);
        return child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
