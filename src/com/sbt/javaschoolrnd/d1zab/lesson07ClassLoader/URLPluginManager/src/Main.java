package com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager.src;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        try {
            Path currentPath = Paths.get(".");
            String current = currentPath.toAbsolutePath().toString();

            PluginManager pluginManager = new PluginManager(current + "\\plugins");

            System.out.println("Encrypting file " + currentPath.toAbsolutePath());


            Plugin printer = pluginManager.load("AnotherPlugin","com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager.Another.AnotherPlugin");
            printer.doUsefull();

            Plugin anotherPlugin = pluginManager.load("PluginManager","com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager.PluginManager.PluginManager");
            anotherPlugin.doUsefull();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
