package Service;

import java.util.List;

import Entities.Categorie;
import Repositories.RepositoryCatégorie;

public class CatégorieService {
    private RepositoryCatégorie repository;

    public CatégorieService(RepositoryCatégorie repository) {
        this.repository = repository;
    }

    public void créerCatégorie(Categorie catégorie) {
        repository.save(catégorie);
    }

    public Categorie trouverCatégorieParId(int id) {
        return repository.findById(id);
    }

    public List<Categorie> listerToutesLesCatégories() {
        return repository.findAll();
    }

    public void mettreÀJourCatégorie(Categorie catégorie) {
        if (repository.findById(catégorie.getId()) != null) {
            repository.update(catégorie);
        } else {
            throw new IllegalArgumentException("La catégorie spécifiée n'existe pas.");
        }
    }

    public void supprimerCatégorie(int id) {
        if (repository.findById(id) != null) {
            repository.delete(id);
        } else {
            throw new IllegalArgumentException("La catégorie spécifiée n'existe pas.");
        }
    }
}
