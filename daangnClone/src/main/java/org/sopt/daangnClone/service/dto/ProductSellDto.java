package org.sopt.daangnClone.service.dto;

public record ProductSellDto(
        String title,
        Boolean isSell,
        int price,
        Boolean suggest,
        String description,
        String location
) {

}
