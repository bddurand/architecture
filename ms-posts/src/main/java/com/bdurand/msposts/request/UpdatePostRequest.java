package com.bdurand.msposts.request;

import lombok.Data;

@Data
public class UpdatePostRequest {

    private String title;
    private String body;
}
