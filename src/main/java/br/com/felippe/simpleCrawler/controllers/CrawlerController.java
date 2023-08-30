package br.com.felippe.simpleCrawler.controllers;

import br.com.felippe.simpleCrawler.model.News;
import br.com.felippe.simpleCrawler.service.CrawlerService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;





@Controller
public class CrawlerController {
    @Autowired
    CrawlerService service;

    @GetMapping("/")
    public String mostrarFormulario() {
        return "index";
    }

    @GetMapping("/search")
    public String buscarDados(Model model) {

        String url = "https://www.infomoney.com.br/mercados/";
        var newsList = service.buscarDadosService(url);
        model.addAttribute("newsList", newsList);
        return "index";
    }

}
