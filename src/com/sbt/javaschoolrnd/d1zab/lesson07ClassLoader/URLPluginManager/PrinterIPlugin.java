package com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager;

import com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager.src.IPlugin;


public class PrinterIPlugin implements IPlugin {
    @Override
    public void doUsefull() {
        System.out.println("Plugin " + this.getClass() + " успешно запущен ...");
    }
}
