import java.util.List;

import Entities.Article;
import Entities.Categorie;
import Repositories.RepositoryArticle;
import Repositories.RepositoryCatégorie;
import Service.ArticleService;
import Service.CatégorieService;

public class App {
    public static App.main(String[] args) throws  {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        RepositoryArticle repositoryArticle = new RepositoryArticle();
        RepositoryCatégorie repositoryCatégorie = new RepositoryCatégorie();
        ArticleService articleService = new ArticleService(repositoryArticle);
        CatégorieService catégorieService = new CatégorieService(repositoryCatégorie);

        // Création et ajout d'une catégorie
        Categorie catégorie1 = new Categorie(1, "Technologie");
        catégorieService.créerCatégorie(catégorie1);

        Article article1 = new Article();
        article1.setCatégorieId(catégorie1.getId());
        articleService.ajouterArticle(article1);

        System.out.println("Articles de la catégorie \"Technologie\":");
        List<Article> articlesTechnologie = articleService.listerArticlesParCatégorie(catégorie1.getId());
        for (Article article : articlesTechnologie) {
            article.afficherArticle();
            System.out.println();
        }

        article1.setContenu(null);
        articleService.mettreÀJourArticle(article1);

        System.out.println("Article mis à jour:");
        article1.afficherArticle();

        catégorieService.supprimerCatégorie(catégorie1.getId());
        articleService.supprimerArticle(article1.getId());
    }
}

