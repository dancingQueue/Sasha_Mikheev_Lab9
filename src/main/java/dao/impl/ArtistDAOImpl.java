package dao.impl;

import dao.ArtistDAO;
import model.Album;
import model.Artist;
import model.Catalogue;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 13.06.16.
 */
public class ArtistDAOImpl implements ArtistDAO {

    private static final String FILE_NAME = "data.txt";
    private static Catalogue catalogue;

    public ArtistDAOImpl() {
        catalogue = new Catalogue("Music Library", new ArrayList<>());
        saveCatalogueDataToFile();
    }

    public Artist getArtist(int index) {
        loadCatalogueDataFromFile();

        List<Artist> artistsList = catalogue.getArtistList();

        return artistsList.get(index);
    }

    public List<Artist> getAllArtists() {
        loadCatalogueDataFromFile();
        return catalogue.getArtistList();
    }

    public void addArtist(Artist artist) {
        loadCatalogueDataFromFile();
        catalogue.addArtist(artist);
        saveCatalogueDataToFile();
    }

    public void deleteArtist(int index) {
        loadCatalogueDataFromFile();
        catalogue.removeArtist(index);
        saveCatalogueDataToFile();
    }

    public void updateArtist(int index, Artist artist) {
        Artist artistToUpdate = getArtist(index);

        String updatedName = artist.getArtistName();
        List<Album> updatedAlbums = artist.getAlbumList();

        artistToUpdate.setArtistName(updatedName);
        artistToUpdate.setAlbumList(updatedAlbums);

        saveCatalogueDataToFile();

    }

    private void loadCatalogueDataFromFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Catalogue.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            File inputFile = new File(FILE_NAME);

            catalogue = (Catalogue) unmarshaller.unmarshal(inputFile);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void saveCatalogueDataToFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Catalogue.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            File outputFile = new File(FILE_NAME);

            marshaller.marshal(catalogue, outputFile);


        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
