package com.tmg.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
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

@Component
public class Mutation implements GraphQLMutationResolver {
    private PostRepository repository;
    private AuthorRepository authorRepository;
    private PostMapper mapper;
    private AuthorMapper authorMapper;

    public Post writePost(String title, String category, String text, Long authorId) {
        final AuthorEntity authorEntity = authorRepository.getOne(authorId);
        final PostEntity postEntity = new PostEntity();
        postEntity.setAuthor(authorEntity);
        postEntity.setCategory(category);
        postEntity.setText(text);
        postEntity.setTitle(title);
        return mapper.toDto(repository.save(postEntity));
    }

    public Author writeAuthor(String name, String thumbnail) {
        final AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(name);
        authorEntity.setThumbnail(thumbnail);
        return authorMapper.toDto(authorRepository.save(authorEntity));
    }

    @Autowired
    public void setRepository(PostRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(PostMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setAuthorMapper(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
