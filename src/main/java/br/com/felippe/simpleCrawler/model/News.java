package br.com.felippe.simpleCrawler.model;

public class News {
    private String url;
    private String title;
    private String subtitle;
    private String author;
    private String date;
    private String content;

    public News(String url, String title, String subtitle, String author, String date, String content) {
        this.url = url;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.date = date;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
