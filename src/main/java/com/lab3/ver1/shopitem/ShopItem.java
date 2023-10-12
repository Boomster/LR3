package com.lab3.ver1.shopitem;

import org.springframework.stereotype.Component;

@Component
public record ShopItem (
        int id,
        String name,
        int year,
        double cost,
        String minRequirements,
        String recRequirements
){}
