package com.clinic.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.clinic.dto.VisitHistory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class VisitHistoryDAOImpl implements VisitHistoryDAO {
    private final JdbcTemplate jdbcTemplate;
    public VisitHistoryDAOImpl(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public VisitHistory save(VisitHistory visit) {
        KeyHolder keys = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO visit_history (appointment_id,diagnosis,prescription,visit_notes) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, visit.getAppointmentId()); statement.setString(2, visit.getDiagnosis()); statement.setString(3, visit.getPrescription()); statement.setString(4, visit.getVisitNotes()); return statement;
        }, keys);
        visit.setVisitId(keys.getKey().intValue()); return visit;
    }

    @Override public int update(VisitHistory visit) { return jdbcTemplate.update("UPDATE visit_history SET diagnosis=?,prescription=?,visit_notes=? WHERE visit_id=?", visit.getDiagnosis(), visit.getPrescription(), visit.getVisitNotes(), visit.getVisitId()); }
    @Override public Optional<VisitHistory> findById(int id) { return jdbcTemplate.query("SELECT * FROM visit_history WHERE visit_id=?", rowMapper(), id).stream().findFirst(); }
    @Override public Optional<VisitHistory> findByAppointmentId(int id) { return jdbcTemplate.query("SELECT * FROM visit_history WHERE appointment_id=?", rowMapper(), id).stream().findFirst(); }
    @Override public List<VisitHistory> findAll() { return jdbcTemplate.query("SELECT * FROM visit_history ORDER BY visit_id", rowMapper()); }
    private org.springframework.jdbc.core.RowMapper<VisitHistory> rowMapper() { return (rs, row) -> VisitHistory.builder().visitId(rs.getInt("visit_id")).appointmentId(rs.getInt("appointment_id")).diagnosis(rs.getString("diagnosis")).prescription(rs.getString("prescription")).visitNotes(rs.getString("visit_notes")).build(); }
}
