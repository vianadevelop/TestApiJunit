package utils.constants;

/**
 * @author Edward
 * @since 03/29/2022
 */
public enum KeyProperties implements Constant<String> {
    PROPERTIES_FILES("application.properties"),
    ENVIRONMENT("Environment"),
    BASE_URI("RestAssured.baseURI"),
    PORT("RestAssured.port");

    private String value;

    KeyProperties(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
