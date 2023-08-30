package br.com.felippe.simpleCrawler.service;

import br.com.felippe.simpleCrawler.helpers.HelperNewsExtractor;
import br.com.felippe.simpleCrawler.model.News;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
@Service
public class CrawlerService {

    @Autowired
    HelperNewsExtractor extractor;

    public ArrayList<News> buscarDadosService(String url) {
        ArrayList<News> newsList = new ArrayList<>();
        var document = request(url);
        Elements assetLinks = document.select(".article-card__asset a");

        for (Element link : assetLinks) {
            String urlSite = link.attr("href");
            var visited = request(urlSite);
            var subtitle = extractor.extractSubtitle(visited);
            var author = extractor.extractAuthor(visited);
            var date = extractor.extractDate(visited);
            var content = extractor.extractContent(visited);

            var news = new News(urlSite, visited.title(),subtitle,author,date,content);
            newsList.add(news);
        }
        return newsList;
    }

    public Document request(String url) {
        try {
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();

            if(connection.response().statusCode() == 200) {
                return document;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
