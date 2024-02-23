package com.resume_tailor.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resume_tailor.backend.model.CoverLetter;
import com.resume_tailor.backend.service.CoverLetter.CoverLetterService;
import com.resume_tailor.backend.utils.ResponseWrapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cover_letters")
public class CoverLetterController {

    @Autowired
    private CoverLetterService coverLetterService;

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<CoverLetter>>> getAllCoverLetters() {
        try {
            List<CoverLetter> coverLetters = coverLetterService.getAllCoverLetters();
            String successMessage = "Successfully retrieved all cover letters.";
            return ResponseEntity.ok().body(new ResponseWrapper<>(true, successMessage, coverLetters));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(false, e.getMessage(), null));
        }
    }

    @GetMapping("/{coverLetterId}")
    public ResponseEntity<?> getCoverLetterById(@PathVariable Integer coverLetterId) {
        try {
            CoverLetter coverLetter = coverLetterService.getCoverLetterById(coverLetterId);
            if (coverLetter != null) {
                return ResponseEntity.ok().body(new ResponseWrapper<>(true, "Cover letter retrieved successfully.", coverLetter));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(false, e.getMessage(), null));
        }
    }

    @PostMapping
    public ResponseEntity<?> createCoverLetter(@Valid @RequestBody CoverLetter coverLetter) {
        try {
            CoverLetter createdCoverLetter = coverLetterService.createCoverLetter(coverLetter);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseWrapper<>(true, "Cover letter created successfully.", createdCoverLetter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(false, e.getMessage(), null));
        }
    }

    @PutMapping("/{coverLetterId}")
    public ResponseEntity<?> updateCoverLetter(@PathVariable Integer coverLetterId, @Valid @RequestBody CoverLetter updatedCoverLetter) {
        try {
            CoverLetter coverLetter = coverLetterService.updateCoverLetter(coverLetterId, updatedCoverLetter);
            return ResponseEntity.ok().body(new ResponseWrapper<>(true, "Cover letter updated successfully.", coverLetter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(false, e.getMessage(), null));
        }
    }

    @DeleteMapping("/{coverLetterId}")
    public ResponseEntity<?> deleteCoverLetter(@PathVariable Integer coverLetterId) {
        try {
            coverLetterService.deleteCoverLetter(coverLetterId);
            return ResponseEntity.ok().body(new ResponseWrapper<>(true, "Cover letter deleted successfully.", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(false, e.getMessage(), null));
        }
    }
}
