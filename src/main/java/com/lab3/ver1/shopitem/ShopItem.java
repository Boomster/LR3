package com.lab3.ver1.shopitem;

import org.springframework.stereotype.Component;

@Component
public record ShopItem (
        Integer id,
        String name,
        Integer year,
        Double cost
        //String minRequirements,
        //String recRequirements
){}
