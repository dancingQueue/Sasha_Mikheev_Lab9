package dao;

import dao.ArtistDAO;
import dao.impl.ArtistDAOImpl;

/**
 * Created by alexandermiheev on 13.06.16.
 */
public class ArtistDAOFactory {
    public static ArtistDAO getArtistDAO() {
        return new ArtistDAOImpl();
    }
}
