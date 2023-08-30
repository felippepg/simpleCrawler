package br.com.felippe.simpleCrawler.helpers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelperNewsExtractor {

    @Autowired
    HelperDateTime helper;

    public String extractSubtitle(Document document) {
        Element excerptElement = document.selectFirst(".single__excerpt p");
        return excerptElement != null ? excerptElement.text() : "";
    }

    public String extractAuthor(Document document) {
        Element authorElement = document.selectFirst(".single__author-info a");
        return authorElement != null ? authorElement.text() : "";
    }

    public String extractDate(Document document) {
        Element timeElement = document.selectFirst("time.entry-date");
        String datetimeAttribute = timeElement.attr("datetime");
        return helper.convertDate(datetimeAttribute);
    }

    public String extractContent(Document document) {
        Elements contentElements = document.select(".element-border--bottom p");
        return contentElements != null ? contentElements.text() : "";

    }
}
