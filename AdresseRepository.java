package repositories;
import entities.Addresse;
import java.util.ArrayList;
import java.util.List;
import entities.Addresse;

public class AdresseRepository {
    private List<Addresse> addresses;

    public AdresseRepository() {
        this.addresses = new ArrayList<>();
    }

   
    public void sauvegarderAdresse(Addresse addresse) {
        addresses.add(addresse);
    }

  
    public List<Addresse> recupererToutesAdresses() {
        return new ArrayList<>(addresses);
    }

    
    public void supprimerAdresse(Addresse addresse) {
        addresses.remove(addresse);
    }
}
    








