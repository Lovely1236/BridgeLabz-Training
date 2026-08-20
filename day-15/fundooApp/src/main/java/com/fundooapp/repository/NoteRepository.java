package com.fundooapp.repository;

import com.fundooapp.entity.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface NoteRepository extends JpaRepository<Note, Integer>, JpaSpecificationExecutor<Note> {
    List<Note> findByOwnerAndIsDeletedFalseAndIsArchivedFalseOrderByNoteIdDesc(User owner);
    List<Note> findByOwnerAndIsArchivedTrueAndIsDeletedFalseOrderByNoteIdDesc(User owner);
    List<Note> findByOwnerAndIsDeletedTrueOrderByNoteIdDesc(User owner);
    Optional<Note> findByNoteIdAndOwner(Integer noteId, User owner);
}
