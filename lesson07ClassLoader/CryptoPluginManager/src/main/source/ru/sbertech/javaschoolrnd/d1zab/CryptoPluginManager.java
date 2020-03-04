package source.ru.sbertech.javaschoolrnd.d1zab;

public class CryptoPluginManager {private final EncryptedClassLoader encryptedClassLoader;

    public CryptoPluginManager(String pluginRootDirectory, String key) {
        this.encryptedClassLoader = new EncryptedClassLoader (ClassLoader.getSystemClassLoader(), pluginRootDirectory, key);
    }

    public Plugin load(String pluginName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = encryptedClassLoader.loadClass(pluginName);
        return (Plugin) clazz.newInstance();
    }
}
