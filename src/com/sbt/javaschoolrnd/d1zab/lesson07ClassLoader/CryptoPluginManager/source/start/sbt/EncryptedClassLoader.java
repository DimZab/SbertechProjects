package com.sbt.javaschoolrnd.d1zab.lesson07ClassLoader.CryptoPluginManager.source.start.sbt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Plugin loader from file System
 */


public class EncryptedClassLoader extends ClassLoader {
    private final String pluginRootDirectory;
    private final String key;

    public EncryptedClassLoader(ClassLoader parent, String pluginRootDirectory, String key) {
        super(parent);
        this.pluginRootDirectory = pluginRootDirectory;
        this.key = key;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // Getting byte code from file and download it
            byte b[] = fecthClassFromFS(pluginRootDirectory
                    + File.separator + name + ".class");

            // "Decrypting" byte code file
            b = decryptByte(b, this.key.getBytes());

            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            return super.findClass(name);
        }
    }

    /**
     * Read file in array of bytes
     *
     * @param path to file
     * @return array of bytes
     * @throws IOException errors while reading file
     */
    private byte[] fecthClassFromFS(String path) throws IOException {
        System.out.println("Downloading plugin from file " + path);
        Path filePath = Paths.get(path);
        return Files.readAllBytes(filePath);
    }

    private byte[] decryptByte(byte[] content, byte[] key) {
        byte[] result = new byte[content.length];
        for (int i = 0; i < content.length; i++) {
            result[i] = (byte) (content[i] ^ key[i % key.length]);
        }
        return result;
    }
}