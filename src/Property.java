import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
    FileInputStream fis_properties;
    private String FILE_PATH;
    private boolean WRITE_TO_FILE;
    private boolean WRITE_SENTENCE;
    private String API_KEY;

    public Property() {
        Properties property = new Properties();
        try {
            fis_properties = new FileInputStream("properties.properties");
            property.load(fis_properties);
            FILE_PATH = property.getProperty("FILE_PATH");
            WRITE_TO_FILE = Boolean.valueOf(property.getProperty("WRITE_TO_FILE"));
            WRITE_SENTENCE = Boolean.valueOf(property.getProperty("WRITE_SENTENCE"));
            API_KEY = property.getProperty("API_KEY");
        } catch (IOException e) {
            System.err.println("Error occured while was reading properties file");
        }
    }

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public boolean isWRITE_TO_FILE() {
        return WRITE_TO_FILE;
    }

    public boolean isWRITE_SENTENCE() {
        return WRITE_SENTENCE;
    }

    public String getAPI_KEY() {
        return API_KEY;
    }
}
