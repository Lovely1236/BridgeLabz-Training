package com.fundooapp.service;

import com.fundooapp.dto.*;
import com.fundooapp.entity.*;
import com.fundooapp.exception.*;
import com.fundooapp.repository.NoteLabelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LabelService {
    private final NoteLabelRepository labels; private final CurrentUserService currentUser;
    public LabelService(NoteLabelRepository labels, CurrentUserService currentUser) { this.labels = labels; this.currentUser = currentUser; }
    @Transactional
    public LabelResponse create(LabelRequest request) {
        User owner = currentUser.get(); String name = request.label().trim();
        if (labels.existsByLabelIgnoreCaseAndOwnerAndIsDeletedFalse(name, owner)) throw new ConflictException("Label already exists");
        NoteLabel label = new NoteLabel(); label.setLabel(name); label.setOwner(owner); return LabelResponse.from(labels.save(label));
    }
    @Transactional
    public LabelResponse update(Integer id, LabelRequest request) {
        NoteLabel label = find(id); String name = request.label().trim(); User owner = currentUser.get();
        if (!label.getLabel().equalsIgnoreCase(name) && labels.existsByLabelIgnoreCaseAndOwnerAndIsDeletedFalse(name, owner)) throw new ConflictException("Label already exists");
        label.setLabel(name); return LabelResponse.from(label);
    }
    @Transactional
    public void delete(Integer id) { find(id).setDeleted(true); }
    @Transactional(readOnly = true)
    public List<LabelResponse> list() { return labels.findByOwnerAndIsDeletedFalseOrderByLabelAsc(currentUser.get()).stream().map(LabelResponse::from).toList(); }
    private NoteLabel find(Integer id) { return labels.findByIdAndOwner(id, currentUser.get()).filter(l -> !l.isDeleted()).orElseThrow(() -> new ResourceNotFoundException("Label not found")); }
}
