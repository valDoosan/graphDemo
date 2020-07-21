package com.tmg.mapper;

import com.tmg.bean.Author;
import com.tmg.entity.AuthorEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.FIELD,
        componentModel = "spring", uses = PostMapper.class)
public interface AuthorMapper {
    Author toDto(AuthorEntity entity);

    List<Author> toListDto(List<AuthorEntity> entity);
}
