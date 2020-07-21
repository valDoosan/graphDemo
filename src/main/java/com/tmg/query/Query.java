package com.tmg.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tmg.bean.Author;
import com.tmg.bean.Post;
import com.tmg.entity.AuthorEntity;
import com.tmg.entity.PostEntity;
import com.tmg.mapper.AuthorMapper;
import com.tmg.mapper.PostMapper;
import com.tmg.repository.AuthorRepository;
import com.tmg.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private PostRepository repository;
    private AuthorRepository authorRepository;
    private PostMapper mapper;
    private AuthorMapper authorMapper;

    public List<Post> getRecentPosts(int count, int offset) {
        final List<PostEntity> all = repository.findAll();

        return mapper.toListDto(all);
    }

    public List<Author> getAuthors() {
        final List<AuthorEntity> all = authorRepository.findAll();

        return authorMapper.toListDto(all);
    }

    @Autowired
    public void setMapper(PostMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setRepository(PostRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    public void setAuthorMapper(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }
}
