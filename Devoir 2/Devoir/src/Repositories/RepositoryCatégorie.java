package Repositories;

import java.util.ArrayList;
import java.util.List;

import Entities.Categorie;

public class RepositoryCatégorie {
    private List<Categorie> catégories = new ArrayList<>();


    public void save(Categorie Categorie) {
        catégories.add(catégories);
    }

    public Categorie findById(int id) {
        for (Categorie catégorie : catégories) {
            if (catégorie.getId() == id) {
                return catégorie;
            }
        }
        return null;
    }

    
    public List<Categorie> findAll() {
        return catégories;
    }

    
    public void update(Categorie catégorie) {
        for (int i = 0; i < catégories.size(); i++) {
            if (catégories.get(i).getId() == catégorie.getId()) {
                catégories.set(i, catégorie);
                return;
            }
        }
    }


    public void delete(int id) {
        catégories.removeIf(catégorie -> catégorie.getId() == id);
    }
}

