package com.fundooapp.controller;

import com.fundooapp.dto.*;
import com.fundooapp.service.LabelService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/noteLabels")
public class LabelController {
    private final LabelService labels;
    public LabelController(LabelService labels) { this.labels = labels; }
    @PostMapping LabelResponse create(@Valid @RequestBody LabelRequest request) { return labels.create(request); }
    @PatchMapping("/{id}") LabelResponse update(@PathVariable Integer id, @Valid @RequestBody LabelRequest request) { return labels.update(id, request); }
    @DeleteMapping("/{id}/deleteNoteLabel") ResponseEntity<Void> delete(@PathVariable Integer id) { labels.delete(id); return ResponseEntity.noContent().build(); }
    @GetMapping("/getNoteLabelList") List<LabelResponse> list() { return labels.list(); }
}
