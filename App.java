import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    public void afficherMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Menu Principal");
            System.out.println("1. Créer un Client");
            System.out.println("2. Lister les Clients");
            System.out.println("3. Ajouter une adresse et l'associer à un client");
            System.out.println("4. Lister les adresses en affichant le nom du client");
            System.out.println("5. Quitter");
            System.out.print("Choix: ");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    creerClient();
                    break;
                case 2:
                    listerClients();
                    break;
                case 3:
                    ajouterAddresseEtAssocierClient();
                    break;
                case 4:
                    listerAddressesAvecClients();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez saisir à nouveau.");
            }
        } while (choix != 5);

        scanner.close();
    }
    
    ClientRepository clientRepository = new ClientRepository();
    AdresseRepository adresseRepository = new AdresseRepository();

       
    ClientService clientService = new ClientService(clientRepository);
    AddresseService adresseService = new AddresseService(addresseRepository);

       
    MenuService menuService = new MenuService(clientService, adresseService);

    menuService.afficherMenuPrincipal();
}


   
    
