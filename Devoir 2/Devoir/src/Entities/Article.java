package Entities;

import java.sql.Date;

public class Article {
        private int id;
        private String titre;
        private String contenu;
        private Date dateCreation;
        private boolean etat;

    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getTitre() {
            return titre;
        }
    
        public void setTitre(String titre) {
            this.titre = titre;
        }
    
        public String getContenu() {
            return contenu;
        }
    
        public void setContenu(String contenu) {
            this.contenu = contenu;
        }
    
        public Date getDateCreation() {
            return dateCreation;
        }
    
        public void setDateCreation(Date dateCreation) {
            this.dateCreation = dateCreation;
        }
    
        public boolean isEtat() {
            return etat;
        }
    
        public void setEtat(boolean etat) {
            this.etat = etat;
        }
    
        public void afficherArticle() {
            System.out.println("ID : " + id);
            System.out.println("Titre : " + titre);
            System.out.println("Contenu : " + contenu);
            System.out.println("Date de création : " + dateCreation);
            System.out.println("État : " + (etat ? "Actif" : "Inactif"));
        }

        public void setCatégorieId(int id2) {
            throw new UnsupportedOperationException("Unimplemented method 'setCatégorieId'");
        }
    }

