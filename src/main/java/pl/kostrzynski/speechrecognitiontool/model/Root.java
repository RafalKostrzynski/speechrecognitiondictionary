package pl.kostrzynski.speechrecognitiontool.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Root{
    @JsonProperty("n_results")
    public int getN_results() {
        return this.n_results;
    }
    public void setN_results(int n_results) {
        this.n_results = n_results;
    }
    int n_results;
    @JsonProperty("page_number")
    public int getPage_number() {
        return this.page_number;
    }
    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }
    int page_number;
    @JsonProperty("results_per_page")
    public int getResults_per_page() {
        return this.results_per_page;
    }
    public void setResults_per_page(int results_per_page) {
        this.results_per_page = results_per_page;
    }
    int results_per_page;
    @JsonProperty("n_pages")
    public int getN_pages() {
        return this.n_pages;
    }
    public void setN_pages(int n_pages) {
        this.n_pages = n_pages;
    }
    int n_pages;
    @JsonProperty("available_n_pages")
    public int getAvailable_n_pages() {
        return this.available_n_pages;
    }
    public void setAvailable_n_pages(int available_n_pages) {
        this.available_n_pages = available_n_pages;
    }
    int available_n_pages;
    @JsonProperty("results")
    public List<LexiconResult> getResults() {
        return this.lexiconResults;
    }
    public void setResults(List<LexiconResult> lexiconResults) {
        this.lexiconResults = lexiconResults;
    }
    List<LexiconResult> lexiconResults;
}