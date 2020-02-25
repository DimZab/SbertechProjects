package com.sbt.javaschoolrnd.d1zab.lesson06Proxy.LectionTask;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {
        Cat barsik = new Cat("barsik", 12);

        Class clazz = barsik.getClass();

        // Show all class methods (including parent and private).
        while (clazz != null) {
            System.out.println("\nMethods declared in " + clazz);

            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println(declaredMethod);
            }

            clazz = clazz.getSuperclass(); // Going to parent
        }

        // Show all class getters
        clazz = barsik.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("\nGetters declared in " + clazz);
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().startsWith("get"))
                System.out.println(declaredMethod);
        }

        // Checking that all string constants have values equal to their name
        System.out.println("\nString const == value");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == String.class) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                    System.out.print(field.getName() + " ");
                    try {
                        System.out.println(field.getName().equals(field.get(barsik)));
                    } catch (IllegalAccessException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}



class Cat {

    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "THURSDAY";
    public static final String FRIDAY = "FRIDAY";
    public static final String SATURDAY = "SATURDAY";
    public static final String SUNDAY = "SUNDAY";


    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }


    private String getSecretFeed() { return "Secret Food recieved."; }
}
