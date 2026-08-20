package com.fundooapp.repository;

import com.fundooapp.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface NoteLabelRepository extends JpaRepository<NoteLabel, Integer> {
    List<NoteLabel> findByOwnerAndIsDeletedFalseOrderByLabelAsc(User owner);
    Optional<NoteLabel> findByIdAndOwner(Integer id, User owner);
    boolean existsByLabelIgnoreCaseAndOwnerAndIsDeletedFalse(String label, User owner);
}
