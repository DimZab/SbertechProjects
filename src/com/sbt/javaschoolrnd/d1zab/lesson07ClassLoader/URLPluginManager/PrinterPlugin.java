package com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager;

import com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager.src.Plugin;


public class PrinterPlugin implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Plugin " + this.getClass() + " успешно запущен ...");
    }
}
