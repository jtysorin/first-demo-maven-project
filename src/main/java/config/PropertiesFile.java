package config;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.google.common.io.FileBackedOutputStream;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    public static String readPropertiesFile() throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream("src/main/java/config/config.properties");
        prop.load(input);
        String browser = prop.get("browser").toString();

        return browser;
    }

    public static void writePropertiesFile() throws IOException {
        Properties prop = new Properties();
        OutputStream output = new FileOutputStream("src/main/java/config/config.properties");
        prop.setProperty("browser", "Chrome");
        prop.setProperty("browser2", "Edge");
        prop.setProperty("browser3", "Edge");
        prop.store(output, null);
    }
}
