package Repositories;

import java.util.ArrayList;
import java.util.List;

import Entities.Article;

public class RepositoryArticle {
    private List<Article> articles = new ArrayList<>();

    public void save(Article article) {
        articles.add(article);
    }

    public Article findById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    
    public List<Article> findAll() {
        return articles;
    }

    public List<Article> findByCatégorie(int catégorieId) {
        List<Article> articlesByCatégorie = new ArrayList<>();
        for (Article article : articles) {
            if (((Object) article).getCategorieId() == catégorieId) {
                articlesByCatégorie.add(article);
            }
        }
        return articlesByCatégorie;
    }

    public List<Article> findByTitre(String titre) {
        List<Article> articlesByTitre = new ArrayList<>();
        for (Article article : articles) {
            if (article.getTitre().equals(titre)) {
                articlesByTitre.add(article);
            }
        }
        return articlesByTitre;
    }

    public List<Article> findByTitreContaining(String motCle) {
        List<Article> articlesByTitre = new ArrayList<>();
        for (Article article : articles) {
            if (article.getTitre().contains(motCle)) {
                articlesByTitre.add(article);
            }
        }
        return articlesByTitre;
    }

    public List<Article> findAll(int page, int taille) {
        int startIndex = (page - 1) * taille;
        if (startIndex >= articles.size()) {
            return new ArrayList<>();
        }
        int endIndex = Math.min(startIndex + taille, articles.size());
        return articles.subList(startIndex, endIndex);
    }

    public void update(Article article) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == article.getId()) {
                articles.set(i, article);
                return;
            }
        }
    }

    public void delete(int id) {
        articles.removeIf(article -> article.getId() == id);
    }
}
