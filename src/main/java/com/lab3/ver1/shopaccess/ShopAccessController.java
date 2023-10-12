package com.lab3.ver1.shopaccess;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lab3")
public class ShopAccessController {
    @GetMapping("/{number}")
    public String testUse(@PathVariable String text){
        return text;
    }
}
