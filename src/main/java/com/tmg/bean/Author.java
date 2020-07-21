package com.tmg.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
   private Long id;
   private String name;
   private String thumbnail;
   private List<Post> posts;
}
