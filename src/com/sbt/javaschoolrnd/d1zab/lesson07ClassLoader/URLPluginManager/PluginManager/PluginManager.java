package com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager.PluginManager;

import com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager.src.Plugin;


public class PluginManager implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Plugin " + this.getClass() + "  is successfully launched... ");
    }
}
