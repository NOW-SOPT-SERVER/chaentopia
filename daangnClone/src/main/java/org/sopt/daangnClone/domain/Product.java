package org.sopt.daangnClone.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Boolean isSell;
    private int price;
    private Boolean suggest;
    private String description;
    private String location;

    @Builder Product(String title, Boolean isSell, int price, Boolean suggest, String description, String location) {
        this.title = title;
        this.isSell = isSell;
        this.price = price;
        this.suggest = suggest;
        this.description = description;
        this.location = location;
    }

    public static Product create(String title, Boolean isSell, int price, Boolean suggest, String description, String location) {
        return Product.builder()
                .title(title)
                .isSell(isSell)
                .price(price)
                .suggest(suggest)
                .description(description)
                .location(location)
                .build();
    }
}
