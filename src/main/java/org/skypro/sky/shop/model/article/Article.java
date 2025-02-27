package org.skypro.sky.shop.model.article;

import org.skypro.sky.shop.model.search.Searchable;
import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {
    private String title;
    private String text;
    private final UUID id;

    public Article(UUID id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return title + '\n' + text;
    }

    @Override
    public String searchTerm(String term) {
        if (title.contains(term) || text.contains(term)) {
            return toString();
        }
        return CODE_NULL;
    }

    @Override
    public String getSearchedContent() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
