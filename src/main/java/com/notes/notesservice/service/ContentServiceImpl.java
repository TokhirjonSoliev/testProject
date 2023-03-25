package com.notes.notesservice.service;

import com.notes.notesservice.dto.ContentDto;
import com.notes.notesservice.entity.Content;
import com.notes.notesservice.exception.NotFoundException;
import com.notes.notesservice.mapper.ContentMapper;
import com.notes.notesservice.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final ContentMapper contentMapper;

    @Override
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    @Override
    public List<Content> getAllOrderedContents() {
        return contentRepository.findAll().stream().sorted((content1, content2) -> content2.getCreatedAt().compareTo(content1.getCreatedAt())).collect(Collectors.toList());
    }

    @Override
    public Content createContent(ContentDto contentDto) {
        Content content = contentMapper.contentDtoToContent(contentDto);
        content.setCreatedAt(LocalDateTime.now());
        return contentRepository.save(content);
    }

    @Override
    public Content updateContent(String contentId, ContentDto contentDto) {
        Content content = contentRepository.findById(UUID.fromString(contentId))
                .orElseThrow(() -> new NotFoundException("Content not found"));

        contentMapper.contentDtoToExistContent(content, contentDto);
        return contentRepository.save(content);
    }

    @Override
    public String deleteContent(String contentId) {
        Content content = contentRepository.findById(UUID.fromString(contentId))
                .orElseThrow(() -> new NotFoundException("Content not found"));

        contentRepository.delete(content);
        return "Content deleted";
    }

    @Override
    public String likeContent(String contentId) {
        Content content = contentRepository.findById(UUID.fromString(contentId))
                .orElseThrow(() -> new NotFoundException("Content not found"));
        content.setLike(content.getLike() + 1);
        contentRepository.save(content);
        return null;
    }

    @Override
    public String dislikeContent(String contentId) {
        Content content = contentRepository.findById(UUID.fromString(contentId))
                .orElseThrow(() -> new NotFoundException("Content not found"));
        content.setDislike(content.getDislike() + 1);
        contentRepository.save(content);
        return null;
    }
}
