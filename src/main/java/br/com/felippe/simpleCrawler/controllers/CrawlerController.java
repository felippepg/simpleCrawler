package br.com.felippe.simpleCrawler.controllers;

import br.com.felippe.simpleCrawler.model.News;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


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
        ArrayList<News> newsList = new ArrayList<>();
//        var visited = request("https://www.infomoney.com.br/economia/juros-e-incerteza-economica-mostram-que-bancos-devem-se-manter-vigilantes-alerta-membro-do-fed/");
//        Elements divElement = visited.select(".element-border--bottom p");
//        Elements pElements = divElement.select("p");
//        StringBuilder textBuilder = new StringBuilder();
//
//        for (Element pElement : pElements) {
//            String paragraphText = pElement.text();
//            textBuilder.append(paragraphText);
//        }
//        System.out.println(divElement.text());
        for (Element link : assetLinks) {
            String urlSite = link.attr("href");
            var visited = request(urlSite);
            var news = new News(urlSite, visited.title(),
                    visited.select(".single__excerpt p").text(),
                    visited.selectFirst(".single__author-info a").text(),
                    visited.title(),
                    visited.select(".element-border--bottom p").text()
            );
            newsList.add(news);
        }

        model.addAttribute("newsList", newsList);
        return "index";
    }

    public static Document request(String url) {
        try {
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();

            if(connection.response().statusCode() == 200) {
//                System.out.println(document.title());
                return document;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
