package Service;

import java.util.List;

import Entities.Article;
import Repositories.RepositoryArticle;

public class ArticleService {
    private RepositoryArticle repository;

    public ArticleService(RepositoryArticle repository) {
        this.repository = repository;
    }

    public void ajouterArticle(Article article) {
        repository.save(article);
    }

    public Article trouverArticleParId(int id) {
        return repository.findById(id);
    }

    public List<Article> listerTousLesArticles() {
        return repository.findAll();
    }

    public List<Article> listerArticlesParCatégorie(int catégorieId) {
        return repository.findByCatégorie(catégorieId);
    }

    public List<Article> chercherArticlesParTitre(String titre) {
        return repository.findByTitre(titre);
    }

    public List<Article> chercherArticlesParMotClé(String motCle) {
        return repository.findByTitreContaining(motCle);
    }

    public List<Article> listerArticlesParPage(int page, int taille) {
        return repository.findAll(page, taille);
    }

    public void mettreÀJourArticle(Article article) {
        repository.update(article);
    }

    public void supprimerArticle(int id) {
        repository.delete(id);
    }
}
