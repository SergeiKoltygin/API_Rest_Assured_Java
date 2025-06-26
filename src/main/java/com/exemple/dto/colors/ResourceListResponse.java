package com.exemple.dto.colors;

import com.exemple.dto.people.SupportDto;

import java.util.List;

public class ResourceListResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<ColorResource> data;
    private SupportDto support;

    public ResourceListResponse() {
    }

    public ResourceListResponse(int page, int per_page, int total, int total_pages, List<ColorResource> data, SupportDto support) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<ColorResource> getData() {
        return data;
    }

    public void setData(List<ColorResource> data) {
        this.data = data;
    }

    public SupportDto getSupport() {
        return support;
    }

    public void setSupport(SupportDto support) {
        this.support = support;
    }
}

