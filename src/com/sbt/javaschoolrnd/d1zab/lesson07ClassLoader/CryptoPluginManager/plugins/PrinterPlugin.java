package com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.CryptoPluginManager.plugins;

import com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.CryptoPluginManager.source.main.IPlugin;


public class PrinterPlugin implements IPlugin {
	@Override
	public void doUsefull() {
		System.out.println("Module " + this.getClass() + " running ...");
	}
}