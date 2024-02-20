
public class Addresse {
    private String id;
    private String ville;
    private String quartier;
    private String numVilla;
    
    public Addresse(String id, String ville, String quartier, String numVilla) {
        this.id = id;
        this.ville = ville;
        this.quartier = quartier;
        this.numVilla = numVilla;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getQuartier() {
        return quartier;
    }
    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }
    public String getNumVilla() {
        return numVilla;
    }
    public void setNumVilla(String numVilla) {
        this.numVilla = numVilla;
    }
    
}


