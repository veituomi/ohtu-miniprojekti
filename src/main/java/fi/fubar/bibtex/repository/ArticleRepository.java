package fi.fubar.bibtex.repository;

import fi.fubar.bibtex.domain.Article;
import fi.fubar.bibtex.domain.UserAccount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a WHERE LOWER(CONCAT("
            + "a.title, a.author, a.journal, a.note, a.handle"
            + ")) LIKE LOWER(CONCAT('%', ?1, '%'))")
    public List<Article> searchAllColumns(String searchString);
    
    public List<Article> findAllByOwner(UserAccount owner);

}