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

            IPlugin printer = pluginManager.load("Another","ru.plugin.AnotherPlugin");
            printer.doUsefull();

            IPlugin anotherIPlugin = pluginManager.load("PluginManager","ru.plugin.PluginManager");
            anotherIPlugin.doUsefull();

            IPlugin printerAverveyko = pluginManager.load("Printer","ru.plugin.averveyko.PrinterPlugin");
            printerAverveyko.doUsefull();

            IPlugin printerIvanov = pluginManager.load("Printer","ru.plugin.ivanov.PrinterPlugin");
            printerIvanov.doUsefull();

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
