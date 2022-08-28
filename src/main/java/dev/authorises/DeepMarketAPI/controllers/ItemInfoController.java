package dev.authorises.DeepMarketAPI.controllers;

import dev.authorises.DeepMarketAPI.DeepMarketApiApplication;
import dev.authorises.DeepMarketAPI.deepmarket.DeepMarketItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemInfoController {

    @GetMapping("/items")
    List<DeepMarketItem> test(){
        return DeepMarketApiApplication.deepMarketManager.getMarketItems();
    }


}
