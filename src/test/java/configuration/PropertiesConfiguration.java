package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfiguration {


    private static Properties prop = new Properties();


    private PropertiesConfiguration() {
    }

    private static String getProperty(String property) {
        try {
            prop.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(property);
    }

    public static String dataBaseName() {
        return getProperty("data.base.name");
    }

    public static String myBatisLocation() {
        return getProperty("my.batis.location");
    }
}
