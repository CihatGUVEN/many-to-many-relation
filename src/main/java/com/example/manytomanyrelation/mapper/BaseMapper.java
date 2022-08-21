package com.example.manytomanyrelation.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;


public interface BaseMapper<Dto, Entity> {

    @Named("dtoToEntity")
    Entity dtoToEntity(Dto dto);

    @Named("entityToDto")
    Dto entityToDto(Entity entity);

    @IterableMapping(qualifiedByName = "entityToDto")
    List<Dto> entityListToDtoList( List<Entity> entityList);

    @IterableMapping(qualifiedByName = "dtoToEntity")
     List<Entity> dtoListToEntityList(List<Dto> dtoList);

    @IterableMapping(qualifiedByName = "entityToDto")
    Set<Dto> entitySetToDtoSet(Set<Entity> entitySet);

    @IterableMapping(qualifiedByName = "dtoToEntity")
    Set<Entity> dtoSetToEntitySet(Set<Dto> dtoSet);



}

