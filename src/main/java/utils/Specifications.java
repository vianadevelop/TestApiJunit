package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Edward
 * @since 03/24/2022
 */
@Setter
public class Specifications {
    /**
     * With the annotations of lombok we will be able tu use
     * the setter methods in the fields below. (In order to assign a new value)
     */
    private Map<String, ?> queryParams;
    private Map<String, ?> pathParams;
    private Map<String, String> headers;
    private ContentType contentType;
    private Object body;

    /**
     * The constructor helps us to initialize the objects,
     * making them optional when we use the buildSpecification method.
     */
    public Specifications() {
        this.headers = new HashMap<>();
        this.queryParams = new HashMap<>();
        this.pathParams = new HashMap<>();
        this.body = new HashMap<>();
        this.contentType = ContentType.JSON;
    }

    /**
     * Build a request specifying the ContentType, headers,
     * QueryParams, PathParams, etc.
     * You can add whatever you need here.
     *
     * @return a request specification
     */
    public RequestSpecification buildSpecification() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(this.contentType);
        requestSpecBuilder.addHeaders(this.headers);
        requestSpecBuilder.addQueryParams(this.queryParams);
        requestSpecBuilder.addPathParams(this.pathParams);
        requestSpecBuilder.setBody(this.body);
        return requestSpecBuilder.build();
    }

}
