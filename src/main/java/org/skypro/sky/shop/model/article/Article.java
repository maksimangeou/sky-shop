package org.skypro.sky.shop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.sky.shop.model.search.Searchable;
import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {
    private String name;
    private String text;
    private final UUID id;

    public Article(UUID id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return name + '\n' + text;
    }

    @JsonIgnore
    @Override
    public String searchTerm(String term) {
        if (name.contains(term) || text.contains(term)) {
            return toString();
        }
        return CODE_NULL;
    }

    @JsonIgnore
    @Override
    public String getSearchedContent() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
