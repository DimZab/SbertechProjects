package ru.sbertech.javaschoolrnd.d1zab;

public class MainCat {

    public static void main(String[] args) {
        DomesticCat from = new DomesticCat("Barsik", 12, "LazyCat");
        Cat to = new Cat("Noname", 0);

        System.out.println("\nRecipient class properties before assign: ");
        System.out.println("name: " + to.getName());
        System.out.println("age: " + to.getAge());

        BeanUtils.assign(to, from);

        System.out.println("\nRecipient class properties after assign: ");
        System.out.println("name: " + to.getName());
        System.out.println("age: " + to.getAge());
    }

}