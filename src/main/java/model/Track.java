package model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by alexandermiheev on 13.06.16.
 */
public class Track {
    private String trackName;
    private Integer trackLengthInSeconds;

    public Track(String trackName, Integer trackLengthInSeconds) {
        this.trackName = trackName;
        this.trackLengthInSeconds = trackLengthInSeconds;
    }

    public Track() {
        this.trackName = "Various track name";
        this.trackLengthInSeconds = 0;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Integer getTrackLengthInSeconds() {
        return trackLengthInSeconds;
    }

    public void setTrackLengthInSeconds(Integer trackLengthInSeconds) {
        this.trackLengthInSeconds = trackLengthInSeconds;
    }
}