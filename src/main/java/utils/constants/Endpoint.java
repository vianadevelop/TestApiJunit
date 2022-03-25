package utils.constants;

/**
 * @author Edward
 * @since 03/24/2022
 */
public enum Endpoint implements Constant<String> {
    BOOKING("/booking");

    private String value;

    Endpoint(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
