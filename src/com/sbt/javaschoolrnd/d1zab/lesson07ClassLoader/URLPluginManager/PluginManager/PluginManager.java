package com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager.PluginManager;

import com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager.src.IPlugin;

public class PluginManager implements IPlugin {
    @Override
    public void doUsefull() {
        System.out.println("Plugin " + this.getClass() + " успешно запущен ...");
    }
}
