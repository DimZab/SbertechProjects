package com.sbt.javaschoolrnd.d1zab.lesson06Proxy.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    /*
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */

    public static void assign(Object to, Object from) {

        Class clazzFrom = from.getClass();
        Class clazzTo = to.getClass();

        //Getting all public methods
        for (Method getMethod : clazzFrom.getMethods()) {

            if (getMethod.getDeclaringClass() == Object.class)
                // Skip all methods of Object
                continue;

            if (getMethod.getName().startsWith("get")) { // getter
                System.out.println("\nFound getter " + getMethod);

                //Generate the name of the setter recipient
                String setterName = getMethod.getName().replace("get", "set");
                System.out.println("Setter search: " + setterName);

                //Looking for setters
                for (Method setMethod : clazzTo.getMethods()) {
                    if (setMethod.getName().equals(setterName)) { //Found searched name
                        // Check if returned getter class is compatible to setter parameter


                        if (getMethod.getReturnType().isAssignableFrom(setMethod.getParameterTypes()[0])){
                            System.out.println("Setter found: " + setMethod);

                            try {
                                setMethod.invoke(to, getMethod.invoke(from));
                                System.out.println("Value is set.");
                            } catch (IllegalAccessException e) {
                                System.out.println("There is no acces to method " + getMethod);
                            } catch (InvocationTargetException e) {
                                System.out.println("Bad call with method " + getMethod);
                            }
                        }
                    }
                }
            }
        }
    }
}
