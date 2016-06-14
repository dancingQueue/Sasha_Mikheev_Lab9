package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 13.06.16.
 */
public class Artist {
    private String artistName;
    private List<Album> albumList;

    public Artist(String artistName, List<Album> albumList) {
        this.artistName = artistName;
        this.albumList = albumList;
    }

    public Artist() {
        this.artistName = "Various artist name";
        this.albumList = new ArrayList<>();
    }

    public Integer getSummaryTrackLength() {
        int resultTrackLength = 0;

        for (Album album: albumList) {
            resultTrackLength += album.getAlbumLengthInSeconds();
        }

        return resultTrackLength;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }
}