package dao;

import model.Artist;

import java.util.List;

/**
 * Created by alexandermiheev on 13.06.16.
 */
public interface ArtistDAO {
    Artist getArtist(int index);
    List<Artist> getAllArtists();
    void addArtist(Artist artist);
    void deleteArtist(int index);
    void updateArtist(int index, Artist artist);
}
