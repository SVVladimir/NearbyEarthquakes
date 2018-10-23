package com.svvladimir.earthquakes.client;

import com.svvladimir.earthquakes.util.JsonConverter;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static org.apache.http.impl.client.HttpClients.createDefault;
import static org.apache.logging.log4j.LogManager.getLogger;

public abstract class AbstractServiceClient {

    private static final Logger LOGGER = getLogger();

    private HttpClient httpclient = createDefault();
    private BasicResponseHandler responseHandler = new BasicResponseHandler();
    private JsonConverter jsonConverter = new JsonConverter();

    public <T> T get(String uri, Class<T> responseClass) throws ServiceClientException {
        HttpUriRequest request = new HttpGet(uri);
        LOGGER.debug("GET REQUEST - URI: " + uri);
        HttpResponse response = executeRequest(request);
        String content = getContent(response);
        LOGGER.debug("GET RESPONSE - STATUS: " + response.getStatusLine() + "\nCONTENT: " + jsonConverter.prettifyJson(content));
        return jsonConverter.jsonToObject(content, responseClass);
    }

    private String getContent(HttpResponse response) throws ServiceClientException {
        try {
            return responseHandler.handleResponse(response);
        } catch (IOException e) {
            LOGGER.error(e);
            throw new ServiceClientException("Unable to get response content");
        }
    }

    private HttpResponse executeRequest(HttpUriRequest request) throws ServiceClientException {
        try {
            return httpclient.execute(request);
        } catch (IOException e) {
            LOGGER.error(e);
            throw new ServiceClientException("Unable to execute request");
        }
    }
}
