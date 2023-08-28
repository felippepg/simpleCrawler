package br.com.felippe.simpleCrawler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CrawlerController {
    @GetMapping("/")
    public String showForm() {
        return "index";
    }
}
