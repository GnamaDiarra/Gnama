import entities.Client;
package services;
import java.util.ArrayList;
import java.util.List;

import entities.Client;
public class ClientService {
    
    private List<Client> clients;

    public ClientService() {
        this.clients = new ArrayList<>();
    }

    
    public void creerClient(Client client) {
       clients.add(client);
    }

 
    public List<Client> listerClients() {
        return new ArrayList<>(clients);
    }
}
