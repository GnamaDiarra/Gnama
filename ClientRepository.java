package repositories;
import entities.Client;
import java.util.ArrayList;
import java.util.List;

import entities.Client;
public class ClientRepository {

    
    private List<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    
    public void sauvegarderClient(Client client) {
        clients.add(client);
    }

    public List<Client> recupererTousClients() {
        return new ArrayList<>(clients);
    }

    public void supprimerClient(Client client) {
        clients.remove(client);
    }
}

    
