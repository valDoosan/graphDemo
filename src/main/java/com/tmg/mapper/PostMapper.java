package com.tmg.mapper;

import com.tmg.bean.Post;
import com.tmg.entity.PostEntity;
import com.tmg.repository.AuthorRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.FIELD,
        componentModel = "spring")
public abstract class PostMapper {
    @Autowired
    protected AuthorRepository repository;

    @Mapping(source = "author.id", target = "authorId")
    public abstract Post toDto(PostEntity entity);

    public abstract List<Post> toListDto(List<PostEntity> entity);

    @Mapping(target = "author", expression = "java(repository.getOne(dto.getId()))")
    public abstract PostEntity toEntity(Post dto);
}
