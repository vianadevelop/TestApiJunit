package utils;

import utils.constants.KeyProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Edward
 * @since 03/29/2022
 */
public class PropertySource {
    private Properties properties;

    public PropertySource() {
        this(KeyProperties.PROPERTIES_FILES.getValue());
    }

    public PropertySource(String filename) {
        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filename)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filename);
        }
        this.properties = prop;
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

}
