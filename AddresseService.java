import entities.Addresse;
package services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Addresse;
import entities.Client;

public class AddresseService {
    private Map<Client, List<Addresse>> clientsAdressesMap;

    public AddresseService() {
        this.ClientsAddressesMap = new HashMap<>();
    }

    public void ajouterAdresseEtAssocierClient(Client client, Addresse adresse) {
        if (!clientsAddressesMap.containsKey(client)) {
            clientsAddressesMap.put(client, new ArrayList<>());
        }
        clientsAddressesMap.get(client).add(adresse);
    }

    
    public List<Addresse> listerAdresses(Client client) {
        return clientsAddressesMap.getOrDefault(client, new ArrayList<>());
    }
}





    

