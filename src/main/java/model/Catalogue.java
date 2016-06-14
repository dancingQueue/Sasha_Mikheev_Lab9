package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 13.06.16.
 */
@XmlRootElement(name = "catalogue")
public class Catalogue {
    private String catalogueName;
    private List<Artist> artistList;

    public Catalogue(String catalogueName, List<Artist> artistList) {
        this.catalogueName = catalogueName;
        this.artistList = artistList;
    }

    public Catalogue() {
        this.catalogueName = "default name";
        this.artistList = new ArrayList<>();
    }

    @XmlAttribute(name = "name")
    public String getCatalogueName() {
        return catalogueName;
    }

    public void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
    }

    @XmlElement(name = "artists")
    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    public void addArtist(Artist artist) {
        this.artistList.add(artist);
    }

    public void removeArtist(int index) {
        this.artistList.remove(index);
    }
}