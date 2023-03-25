package com.notes.notesservice.repository;

import com.notes.notesservice.entity.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ContentRepository extends MongoRepository<Content, UUID> {
    List<Content> findAllByOrderByCreatedAtDesc();
}
