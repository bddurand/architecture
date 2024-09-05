package com.bdurand.msposts.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class Post {
    @Id
    private String id;
    private final Integer userId;
    private String title;
    private String body;
    private final LocalDateTime createdAt;

    @PersistenceCreator
    public Post(String id, Integer userId, String title, String body, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
    }

    private Post(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.title = builder.title;
        this.body = builder.body;
        this.createdAt = builder.createdAt;
    }

    public static class Builder {
        private String id;
        private Integer userId;
        private String title;
        private String body;
        private LocalDateTime createdAt;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Post build() {
            return new Post(this);
        }

        public Post withId(String id) {
            return new Builder()
                    .id(id)
                    .userId(this.userId)
                    .title(this.title)
                    .body(this.body)
                    .createdAt(this.createdAt)
                    .build();
        }

        public Post withUserId(Integer userId) {
            return new Builder()
                    .userId(userId)
                    .title(this.title)
                    .body(this.body)
                    .createdAt(this.createdAt)
                    .build();
        }

        public Post withTitle(String title) {
            return new Builder()
                    .userId(this.userId)
                    .title(title)
                    .body(this.body)
                    .createdAt(this.createdAt)
                    .build();
        }

        public Post withBody(String body) {
            return new Builder()
                    .userId(this.userId)
                    .title(this.title)
                    .body(body)
                    .createdAt(this.createdAt)
                    .build();
        }


        public Post withCreatedAt(LocalDateTime createdAt) {
            return new Builder()
                    .userId(this.userId)
                    .title(this.title)
                    .body(body)
                    .createdAt(createdAt)
                    .build();
        }
    }
}