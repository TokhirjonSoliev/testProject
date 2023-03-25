package com.notes.notesservice.mapper;

import com.notes.notesservice.dto.ContentDto;
import com.notes.notesservice.entity.Content;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.UUID;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ContentMapper {

    @Mapping(target = "id", expression = "java(generateUUID())")
    Content contentDtoToContent(ContentDto contentDto);

    void contentDtoToExistContent(@MappingTarget Content content, ContentDto contentDto);

    default UUID generateUUID(){
        return UUID.randomUUID();
    }
}
