package com.fundooapp.specification;

import com.fundooapp.entity.*;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import java.util.*;

public final class NoteSpecification {
    private NoteSpecification() {}
    public static Specification<Note> search(User owner, String titleText, String state, String labelName) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("owner"), owner));
            if (titleText != null && !titleText.isBlank())
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + titleText.toLowerCase() + "%"));
            if (labelName != null && !labelName.isBlank()) {
                Join<Note, NoteLabel> labels = root.join("labels", JoinType.INNER);
                predicates.add(cb.equal(cb.lower(labels.get("label")), labelName.toLowerCase()));
                query.distinct(true);
            }
            if (state != null && !state.isBlank()) {
                switch (state.toLowerCase()) {
                    case "archive", "archived" -> { predicates.add(cb.isTrue(root.get("isArchived"))); predicates.add(cb.isFalse(root.get("isDeleted"))); }
                    case "trash", "trashed", "deleted" -> predicates.add(cb.isTrue(root.get("isDeleted")));
                    case "pin", "pinned" -> { predicates.add(cb.isTrue(root.get("isPined"))); predicates.add(cb.isFalse(root.get("isDeleted"))); }
                    case "active" -> { predicates.add(cb.isFalse(root.get("isArchived"))); predicates.add(cb.isFalse(root.get("isDeleted"))); }
                    default -> throw new IllegalArgumentException("Unknown note state: " + state);
                }
            }
            return cb.and(predicates.toArray(Predicate[]::new));
        };
    }
}
