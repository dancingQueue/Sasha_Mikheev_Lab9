import dao.ArtistDAO;
import dao.ArtistDAOFactory;
import model.Artist;
import suppliers.EntitiesSupplier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 13.06.16.
 */
public class Run {

    public List<Artist> getRandomArtistsList(int size) {
        List<Artist> resultArtistList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Artist currentArtist = EntitiesSupplier.getArtist(2);
            resultArtistList.add(currentArtist);
        }

        return resultArtistList;
    }

    public void printArtistsTotalTrackDuration(List<Artist> artistList) {
        for (Artist artist: artistList) {
            String nameDescription = "Artist name: " + artist.getArtistName();
            String albumLengthDescription = " Albums duration in seconds: " + artist.getSummaryTrackLength();
            System.out.println(nameDescription + albumLengthDescription);
        }
    }

    public void testArtistDAO() {
        int amountOfArtists = 2;
        List<Artist> artistList = getRandomArtistsList(amountOfArtists);

        ArtistDAO artistDAO = ArtistDAOFactory.getArtistDAO();

        for (Artist artist: artistList) {
            artistDAO.addArtist(artist);
        }
        System.out.println("Print all artists discography length in seconds");
        printArtistsTotalTrackDuration(artistDAO.getAllArtists());

        int newArtistAmountOfAlbums = 3;
        Artist newArtistToAdd = EntitiesSupplier.getArtist(newArtistAmountOfAlbums);
        System.out.println("Adding new artist and printing again");
        artistDAO.addArtist(newArtistToAdd);

        printArtistsTotalTrackDuration(artistDAO.getAllArtists());

        System.out.println("Removing the first artist");

        int artistIndexToRemove = 0;
        artistDAO.deleteArtist(artistIndexToRemove);

        System.out.println("Print all artists discography length in seconds again");
        printArtistsTotalTrackDuration(artistDAO.getAllArtists());


    }

    public void run() {
        testArtistDAO();
    }

}
