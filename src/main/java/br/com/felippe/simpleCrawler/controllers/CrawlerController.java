package br.com.felippe.simpleCrawler.controllers;

import br.com.felippe.simpleCrawler.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CrawlerController {
    @Autowired
    CrawlerService crawlerService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model) {
        String url = "https://www.infomoney.com.br/mercados/";
        var newsList = crawlerService.fetchData(url);

        model.addAttribute("newsList", newsList);
        return "index";
    }

}
