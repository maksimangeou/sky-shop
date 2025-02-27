package org.skypro.sky.shop.model.product;

import org.skypro.sky.shop.model.search.Searchable;
import java.util.Objects;

public abstract class Product implements Searchable {

    private String name;

    public Product(String name) {
        try {
            if (name.isBlank()) {
                throw new IllegalArgumentException();
            }
            this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println("Название состоит из пробелов");
        } catch (NullPointerException e) {
            System.out.println("Пустое значение в аргументе");
        }
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String searchTerm(String term) {
        if (name.contains(term)) {
            return name;
        }
        return CODE_NULL;
    }

    @Override
    public String getSearchedContent() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
