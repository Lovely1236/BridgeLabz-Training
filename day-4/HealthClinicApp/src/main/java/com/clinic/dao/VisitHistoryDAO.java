package com.clinic.dao;

import java.util.List;
import java.util.Optional;
import com.clinic.dto.VisitHistory;

public interface VisitHistoryDAO {
    VisitHistory save(VisitHistory visitHistory);
    int update(VisitHistory visitHistory);
    Optional<VisitHistory> findById(int visitId);
    Optional<VisitHistory> findByAppointmentId(int appointmentId);
    List<VisitHistory> findAll();
    default int storeVisitHistory(VisitHistory visitHistory) { return save(visitHistory).getVisitId(); }
}
