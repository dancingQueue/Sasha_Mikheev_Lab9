package model;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 13.06.16.
 */
public class Album {
    private String albumName;
    private String albumGenre;
    private List<Track> albumTracks;

    public Album(String albumName, String albumGenre, List<Track> albumTracks) {
        this.albumName = albumName;
        this.albumGenre = albumGenre;
        this.albumTracks = albumTracks;
    }

    public Album() {
        this.albumName = "Various album name";
        this.albumGenre = "Various album genre";
        this.albumTracks = new ArrayList<>();
    }

    public Integer getAlbumLengthInSeconds() {
        int resultLength = 0;

        for (Track track: albumTracks) {
            resultLength += track.getTrackLengthInSeconds();
        }

        return resultLength;
    }

    @XmlAttribute(name = "name")
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @XmlAttribute(name = "genre")
    public String getAlbumGenre() {
        return albumGenre;
    }

    public void setAlbumGenre(String albumGenre) {
        this.albumGenre = albumGenre;
    }

    public List<Track> getAlbumTracks() {
        return albumTracks;
    }

    public void setAlbumTracks(List<Track> albumTracks) {
        this.albumTracks = albumTracks;
    }
}