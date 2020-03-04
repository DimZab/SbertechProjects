package PluginManager;
import ru.sbertech.javaschoolrnd.d1zab.Plugin;

public class PluginManager implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Plugin " + this.getClass() + "  is successfully launched... ");
    }
}
