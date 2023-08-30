package br.com.felippe.simpleCrawler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class News {
    private String url;
    private String title;
    private String subtitle;
    private String author;
    private String date;
    private String content;

//    public News(String url, String title, String subtitle, String author, String date, String content) {
//        this.url = url;
//        this.title = title;
//        this.subtitle = subtitle;
//        this.author = author;
//        this.date = date;
//        this.content = content;
//    }

}
