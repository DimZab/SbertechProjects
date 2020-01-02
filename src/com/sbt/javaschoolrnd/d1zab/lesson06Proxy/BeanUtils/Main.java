package com.sbt.javaschoolrnd.d1zab.lesson06Proxy.BeanUtils;

public class Main {

    public static void main(String[] args) {
        DomesticCat from = new DomesticCat("Barsik", 12, "LazyCat");
        Cat to = new Cat("Noname", 0);

        System.out.println("\nRecipient class properties before assign: ");
        System.out.println("name: "  + to.getName());
        System.out.println("age: "  + to.getAge());

        BeanUtils.assign(to, from);

        System.out.println("\nRecipient class properties after assign: ");
        System.out.println("name: "  + to.getName());
        System.out.println("age: "  + to.getAge());
    }

}


class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String privateMethod() {
        return "This is private method!";
    }

}

class DomesticCat extends Cat {
    private String activities;

    public DomesticCat(String name, int age, String activities) {
        super(name, age);
        this.activities = activities;
    }

    public String getProfession() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

}

