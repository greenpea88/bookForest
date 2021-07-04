package com.spring.project.bookforest.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int rate;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(columnDefinition = "TINYINT")
    private boolean deleted = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_email")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public Review(String title, int rate, String content, User user, Product product){
        this.title = title;
        this.rate = rate;
        this.content = content;

        this.user = user;
        this.product = product;
    }

    public void update(String title, int rate, String content){
        this.title = title;
        this.rate = rate;
        this.content = content;

        this.updatedAt = LocalDateTime.now();
    }
}
