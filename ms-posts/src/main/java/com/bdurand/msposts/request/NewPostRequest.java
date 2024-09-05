package com.bdurand.msposts.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewPostRequest {


    @NotNull(message = "UserId cannot be null")
    private Integer userId;
    private String title;
    private String body;

}
