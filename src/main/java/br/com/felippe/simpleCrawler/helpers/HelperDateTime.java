package br.com.felippe.simpleCrawler.helpers;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class HelperDateTime {
    public String convertDate(String data) {
        LocalDateTime dateTime = LocalDateTime.parse(data, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        return formattedDateTime;
    }

}
