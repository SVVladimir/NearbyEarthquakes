package com.svvladimir.earthquakes.dto;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "metadata",
        "features"
})
public class EarthquakeCollection implements Serializable {

    @JsonProperty("type")
    private String type;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("features")
    private List<Earthquake> earthquakes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -5033754323602868729L;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("earthquakes")
    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    @JsonProperty("features")
    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}