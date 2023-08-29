package br.com.felippe.simpleCrawler.controllers;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class CrawlerController {
    @GetMapping("/")
    public String mostrarFormulario() {
        return "index";
    }

    @GetMapping("/search")
    public String buscarDados(Model model) {

        String url = "https://www.infomoney.com.br/mercados/";
        Document document = request(url);
        Elements assetLinks = document.select(".article-card__asset a");
        for (Element link : assetLinks) {
            String urlSite = link.attr("href");
            System.out.println("URL: " + urlSite);
        }

        //System.out.println(document);
        //System.out.println(document.select(".article-card"));
        return "index";
    }

    public static Document request(String url) {
        try {
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();

            if(connection.response().statusCode() == 200) {
                System.out.println(document.title());
                return document;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
