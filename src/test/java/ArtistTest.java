import model.Album;
import model.Artist;
import model.Track;
import org.junit.Assert;
import org.junit.Test;
import suppliers.EntitiesSupplier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 15.06.16.
 */
public class ArtistTest {

    public Album getAlbumWithTheSameLengthTracks(int length, int amountOfTracks) {
        Album resultAlbum = EntitiesSupplier.getAlbum(amountOfTracks);

        for (Track track: resultAlbum.getAlbumTracks()) {
            track.setTrackLengthInSeconds(length);
        }

        return resultAlbum;
    }


    @Test
    public void testArtistAlbumsLength() {
        int trackLength = 10;
        int amountOfTracks = 3;

        Album albumToAdd = getAlbumWithTheSameLengthTracks(trackLength, amountOfTracks);
        List<Album> albumList = new ArrayList<>();
        albumList.add(albumToAdd);

        Artist artist = new Artist("Test Artist", albumList);

        int totalLength = trackLength * amountOfTracks;

        Assert.assertEquals(totalLength, artist.getSummaryTrackLength());
    }
}
