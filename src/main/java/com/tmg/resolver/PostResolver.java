package com.tmg.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tmg.bean.Author;
import com.tmg.bean.Post;
import com.tmg.entity.AuthorEntity;
import com.tmg.mapper.AuthorMapper;
import com.tmg.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostResolver implements GraphQLResolver<Post> {
    private AuthorRepository repository;
    private AuthorMapper mapper;

    public Author getAuthor(Post post) {
        final AuthorEntity entity = repository.getOne(post.getAuthorId());
        return mapper.toDto(entity);
    }

    @Autowired
    public void setRepository(AuthorRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(AuthorMapper mapper) {
        this.mapper = mapper;
    }
}
