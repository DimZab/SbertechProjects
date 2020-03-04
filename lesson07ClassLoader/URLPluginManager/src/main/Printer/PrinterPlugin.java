package Printer;
import ru.sbertech.javaschoolrnd.d1zab.Plugin;

public class PrinterPlugin implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Plugin " + this.getClass() + " успешно запущен ...");
    }
}
