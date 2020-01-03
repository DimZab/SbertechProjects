import com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.CryptoPluginManager.source.start.sbt.Plugin;

public class AnotherPlugin implements Plugin {
	@Override
	public void doUsefull() {
		System.out.println("Module " + this.getClass() + " running ...");
	}
}