import dao.ArtistDAO;
import dao.ArtistDAOFactory;
import org.junit.Assert;
import model.Artist;
import org.junit.Before;
import org.junit.Test;
import suppliers.EntitiesSupplier;

/**
 * Created by alexandermiheev on 15.06.16.
 */
public class ArtistDAOImplTest {
    private static ArtistDAO artistDAO;

    @Before
    public void initArtistDAO() {
        artistDAO = ArtistDAOFactory.getArtistDAO();
    }

    @Test
    public void testAddArtist() {
        Artist artistToAdd = EntitiesSupplier.getArtist(3);

        artistDAO.addArtist(artistToAdd);
        Assert.assertEquals(1, artistDAO.getAllArtists().size());

    }

    @Test
    public void testDeleteArtist() {
        Artist artistToAdd = EntitiesSupplier.getArtist(3);
        artistDAO.addArtist(artistToAdd);

        artistDAO.deleteArtist(0);
        int amountOfArtists = artistDAO.getAllArtists().size();

        Assert.assertEquals(0, amountOfArtists);
    }

}
