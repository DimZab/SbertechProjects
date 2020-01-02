package com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.CryptoPluginManager.source.main;

import com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.URLPluginManager.src.IPlugin;


public class CryptoPluginManager {
    private final CryptoPluginLoader cryptoPluginLoader;

    public CryptoPluginManager(String pluginRootDirectory, String key) {
        this.cryptoPluginLoader = new CryptoPluginLoader(ClassLoader.getSystemClassLoader(), pluginRootDirectory, key);
    }

    public IPlugin load(String pluginName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = cryptoPluginLoader.loadClass(pluginName);
        return (IPlugin) clazz.newInstance();
    }
}
