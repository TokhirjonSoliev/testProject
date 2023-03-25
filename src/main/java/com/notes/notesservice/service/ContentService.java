package com.notes.notesservice.service;

import com.notes.notesservice.dto.ContentDto;
import com.notes.notesservice.entity.Content;

import java.util.List;

public interface ContentService {
    List<Content> getAllContents();
    List<Content> getAllOrderedContents();
    Content createContent(ContentDto contentDto);
    Content updateContent(String id, ContentDto contentDto);
    String deleteContent(String id);
    String likeContent(String id);
    String dislikeContent(String id);
}
