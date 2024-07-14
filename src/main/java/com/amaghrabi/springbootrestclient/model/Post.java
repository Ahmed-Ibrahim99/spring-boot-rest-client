package com.amaghrabi.springbootrestclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    Long id;
    Long userId;
    String title;
    String body;
}
