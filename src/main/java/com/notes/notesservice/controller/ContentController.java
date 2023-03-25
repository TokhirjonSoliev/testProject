package com.notes.notesservice.controller;

import com.notes.notesservice.dto.ContentDto;
import com.notes.notesservice.entity.Content;
import com.notes.notesservice.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/content")
public class ContentController {
    private final ContentService contentService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Content>> getAllNotes() {
        return ResponseEntity.ok(contentService.getAllContents());
    }

    @GetMapping(value = "/order")
    public ResponseEntity<List<Content>> getAllOrderedNotes() {
        return ResponseEntity.ok(contentService.getAllOrderedContents());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Content> createNotes(@RequestBody ContentDto contentDto) {
        return ResponseEntity.ok(contentService.createContent(contentDto));
    }

    @PutMapping(value = "/edit/{content_id}")
    public ResponseEntity<Content> editNotes(@PathVariable("content_id") String contentId, @RequestBody ContentDto contentDto) {
        return ResponseEntity.ok(contentService.updateContent(contentId, contentDto));
    }

    @DeleteMapping(value = "/delete/{content_id}")
    public ResponseEntity<String> deleteNotes(@PathVariable("content_id") String contentId) {
        return ResponseEntity.ok(contentService.deleteContent(contentId));
    }

    @PutMapping(value = "/like/{content_id}")
    public ResponseEntity<String> likeNotes(@PathVariable("content_id") String contentId) {
        return ResponseEntity.ok(contentService.likeContent(contentId));
    }

    @PutMapping(value = "/dislike/{content_id}")
    public ResponseEntity<String> dislikeNotes(@PathVariable("content_id") String contentId) {
        return ResponseEntity.ok(contentService.dislikeContent(contentId));
    }
}
