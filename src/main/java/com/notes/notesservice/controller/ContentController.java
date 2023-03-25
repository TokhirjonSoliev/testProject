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

    /**
     * This is an api which is used to get all Contents
     * @return List<Content>
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<Content>> getAllNotes() {
        return ResponseEntity.ok(contentService.getAllContents());
    }

    /**
     * This is an api which is used to get all Contents in order from new to old
     * @return List<Content>
     */
    @GetMapping(value = "/order")
    public ResponseEntity<List<Content>> getAllOrderedNotes() {
        return ResponseEntity.ok(contentService.getAllOrderedContents());
    }

    /**
     * This is an api which is used to create a Content
     * @return Content
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Content> createNotes(@RequestBody ContentDto contentDto) {
        return ResponseEntity.ok(contentService.createContent(contentDto));
    }

    /**
     * This is an api which is used to update a Content
     * @return Content
     */
    @PutMapping(value = "/edit/{content_id}")
    public ResponseEntity<Content> editNotes(@PathVariable("content_id") String contentId, @RequestBody ContentDto contentDto) {
        return ResponseEntity.ok(contentService.updateContent(contentId, contentDto));
    }

    /**
     * This is an api which is used to delete a Content
     * @return String
     */
    @DeleteMapping(value = "/delete/{content_id}")
    public ResponseEntity<String> deleteNotes(@PathVariable("content_id") String contentId) {
        return ResponseEntity.ok(contentService.deleteContent(contentId));
    }

    /**
     * This is an api which is used to give a like to Content
     * @return String
     */
    @PutMapping(value = "/like/{content_id}")
    public ResponseEntity<String> likeNotes(@PathVariable("content_id") String contentId) {
        return ResponseEntity.ok(contentService.likeContent(contentId));
    }

    /**
     * This is an api which is used to give a dislike to Content
     * @return String
     */
    @PutMapping(value = "/dislike/{content_id}")
    public ResponseEntity<String> dislikeNotes(@PathVariable("content_id") String contentId) {
        return ResponseEntity.ok(contentService.dislikeContent(contentId));
    }
}
