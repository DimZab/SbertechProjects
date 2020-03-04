package ru.sbertech.javaschoolrnd.d1zab;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainAnotherCat {

    public static void main(String[] args) {
        AnotherCat barsik = new AnotherCat("barsik", 12);

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