package com.dockerapp.dockerapp.controllers;

import com.dockerapp.dockerapp.services.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {
    private final StoreService storeService;

    public IndexController(StoreService storeService) {
        this.storeService = storeService;
    }



    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");
        model.addAttribute("stores", storeService.getAllStores());
        return "index";
    }
}
