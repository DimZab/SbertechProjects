package plugins;
import source.ru.sbertech.javaschoolrnd.d1zab.Plugin;

public class AnotherPlugin implements Plugin {
	@Override
	public void doUsefull() {
		System.out.println("Module " + this.getClass() + " running ...");
	}
}