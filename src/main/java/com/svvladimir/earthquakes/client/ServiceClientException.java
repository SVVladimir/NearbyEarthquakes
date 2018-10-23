package com.svvladimir.earthquakes.client;

public class ServiceClientException extends DataSourceException {

    public ServiceClientException(String errorMessage) {
        super(errorMessage);
    }
}
