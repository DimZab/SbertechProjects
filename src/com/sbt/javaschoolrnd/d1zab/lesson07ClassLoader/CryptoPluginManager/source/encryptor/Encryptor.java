package encryptor;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Encrypt byte code
 */


public class Encryptor {
    public static void main(String[] args) throws IOException {
        encryptFile("plugins/PrinterPlugin.class", "secretkey");
    }

    private static void encryptFile(String filePath, String key) throws IOException {
        Path path = Paths.get(filePath);
        byte[] content = Files.readAllBytes(path);

        System.out.println("Encrypting file " + path.toAbsolutePath());

        //"Proceeding"
        content = encryptByte(content, key.getBytes());

        // Rewrite file with encrypted content
        Files.write(path, content);
        System.out.println("File " + path.getFileName() + " is successfully proceeded");
    }

    private static byte[] encryptByte(byte[] content, byte[] key) {
        byte[] result = new byte[content.length];

        for (int i = 0; i < content.length; i++) {
            result[i] = (byte) (content[i] ^ key[i % key.length]);
        }
        return result;
    }
}
