package de.home.discogs;

import com.google.gson.JsonObject;

public class Pagination {

    private Integer perPage;
    private Integer items;
    private Integer page;
    private Integer pages;

    private Pagination(Integer perPage, Integer items, Integer page, Integer pages) {
        this.perPage = perPage;
        this.items = items;
        this.page = page;
        this.pages = pages;
    }

    public static Pagination create(Integer perPage, Integer items, Integer page, Integer pages) {
        return new Pagination(perPage, items, page, pages);
    }

    public static Pagination create(JsonObject json) {
        return new Pagination(
                json.get("per_page").getAsInt(),
                json.get("items").getAsInt(),
                json.get("page").getAsInt(),
                json.get("pages").getAsInt()
        );
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getItems() {
        return items;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPages() {
        return pages;
    }
}
