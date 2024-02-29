package Entities;

public class Categorie {
    private int id;
    private String nomCat;

    public Categorie(int i, String string) {

    }

    public void Catégorie(int id, String nomCat) {
        this.id = id;
        this.nomCat = nomCat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public void afficherCatégorie() {
        System.out.println("ID : " + id);
        System.out.println("Nom de la catégorie : " + nomCat);
    }

}
