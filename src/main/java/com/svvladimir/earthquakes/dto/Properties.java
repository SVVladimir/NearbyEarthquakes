package com.svvladimir.earthquakes.dto;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "mag",
        "place",
        "time",
        "updated",
        "tz",
        "url",
        "detail",
        "felt",
        "cdi",
        "mmi",
        "alert",
        "status",
        "tsunami",
        "sig",
        "net",
        "code",
        "ids",
        "sources",
        "types",
        "nst",
        "dmin",
        "rms",
        "gap",
        "magType",
        "type",
        "title"
})
public class Properties implements Serializable {

    @JsonProperty("mag")
    private Double mag;
    @JsonProperty("place")
    private String place;
    @JsonProperty("time")
    private Long time;
    @JsonProperty("updated")
    private Long updated;
    @JsonProperty("tz")
    private Long tz;
    @JsonProperty("url")
    private String url;
    @JsonProperty("detail")
    private String detail;
    @JsonProperty("felt")
    private Object felt;
    @JsonProperty("cdi")
    private Object cdi;
    @JsonProperty("mmi")
    private Object mmi;
    @JsonProperty("alert")
    private Object alert;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tsunami")
    private Long tsunami;
    @JsonProperty("sig")
    private Long sig;
    @JsonProperty("net")
    private String net;
    @JsonProperty("code")
    private String code;
    @JsonProperty("ids")
    private String ids;
    @JsonProperty("sources")
    private String sources;
    @JsonProperty("types")
    private String types;
    @JsonProperty("nst")
    private Long nst;
    @JsonProperty("dmin")
    private Double dmin;
    @JsonProperty("rms")
    private Double rms;
    @JsonProperty("gap")
    private Long gap;
    @JsonProperty("magType")
    private String magType;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -8886439071245368421L;

    @JsonProperty("mag")
    public Double getMag() {
        return mag;
    }

    @JsonProperty("mag")
    public void setMag(Double mag) {
        this.mag = mag;
    }

    @JsonProperty("place")
    public String getPlace() {
        return place;
    }

    @JsonProperty("place")
    public void setPlace(String place) {
        this.place = place;
    }

    @JsonProperty("time")
    public Long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Long time) {
        this.time = time;
    }

    @JsonProperty("updated")
    public Long getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    @JsonProperty("tz")
    public Long getTz() {
        return tz;
    }

    @JsonProperty("tz")
    public void setTz(Long tz) {
        this.tz = tz;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    @JsonProperty("detail")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @JsonProperty("felt")
    public Object getFelt() {
        return felt;
    }

    @JsonProperty("felt")
    public void setFelt(Object felt) {
        this.felt = felt;
    }

    @JsonProperty("cdi")
    public Object getCdi() {
        return cdi;
    }

    @JsonProperty("cdi")
    public void setCdi(Object cdi) {
        this.cdi = cdi;
    }

    @JsonProperty("mmi")
    public Object getMmi() {
        return mmi;
    }

    @JsonProperty("mmi")
    public void setMmi(Object mmi) {
        this.mmi = mmi;
    }

    @JsonProperty("alert")
    public Object getAlert() {
        return alert;
    }

    @JsonProperty("alert")
    public void setAlert(Object alert) {
        this.alert = alert;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("tsunami")
    public Long getTsunami() {
        return tsunami;
    }

    @JsonProperty("tsunami")
    public void setTsunami(Long tsunami) {
        this.tsunami = tsunami;
    }

    @JsonProperty("sig")
    public Long getSig() {
        return sig;
    }

    @JsonProperty("sig")
    public void setSig(Long sig) {
        this.sig = sig;
    }

    @JsonProperty("net")
    public String getNet() {
        return net;
    }

    @JsonProperty("net")
    public void setNet(String net) {
        this.net = net;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("ids")
    public String getIds() {
        return ids;
    }

    @JsonProperty("ids")
    public void setIds(String ids) {
        this.ids = ids;
    }

    @JsonProperty("sources")
    public String getSources() {
        return sources;
    }

    @JsonProperty("sources")
    public void setSources(String sources) {
        this.sources = sources;
    }

    @JsonProperty("types")
    public String getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(String types) {
        this.types = types;
    }

    @JsonProperty("nst")
    public Long getNst() {
        return nst;
    }

    @JsonProperty("nst")
    public void setNst(Long nst) {
        this.nst = nst;
    }

    @JsonProperty("dmin")
    public Double getDmin() {
        return dmin;
    }

    @JsonProperty("dmin")
    public void setDmin(Double dmin) {
        this.dmin = dmin;
    }

    @JsonProperty("rms")
    public Double getRms() {
        return rms;
    }

    @JsonProperty("rms")
    public void setRms(Double rms) {
        this.rms = rms;
    }

    @JsonProperty("gap")
    public Long getGap() {
        return gap;
    }

    @JsonProperty("gap")
    public void setGap(Long gap) {
        this.gap = gap;
    }

    @JsonProperty("magType")
    public String getMagType() {
        return magType;
    }

    @JsonProperty("magType")
    public void setMagType(String magType) {
        this.magType = magType;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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