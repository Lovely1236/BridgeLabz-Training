package com.clinic.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.clinic.dto.Specialization;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class SpecializationDAOImpl implements SpecializationDAO {
    private final JdbcTemplate jdbcTemplate;
    public SpecializationDAOImpl(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public Specialization save(Specialization specialization) {
        KeyHolder keys = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO specializations (name,description) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, specialization.getName()); statement.setString(2, specialization.getDescription()); return statement;
        }, keys);
        specialization.setSpecializationId(keys.getKey().intValue()); return specialization;
    }
    @Override public int update(Specialization s) { return jdbcTemplate.update("UPDATE specializations SET name=?,description=? WHERE specialization_id=?", s.getName(), s.getDescription(), s.getSpecializationId()); }
    @Override public int deleteById(int id) { return jdbcTemplate.update("DELETE FROM specializations WHERE specialization_id=?", id); }
    @Override public Optional<Specialization> findById(int id) { return jdbcTemplate.query("SELECT * FROM specializations WHERE specialization_id=?", rowMapper(), id).stream().findFirst(); }
    @Override public List<Specialization> findAll() { return jdbcTemplate.query("SELECT * FROM specializations ORDER BY name", rowMapper()); }
    private org.springframework.jdbc.core.RowMapper<Specialization> rowMapper() { return (rs, row) -> Specialization.builder().specializationId(rs.getInt("specialization_id")).name(rs.getString("name")).description(rs.getString("description")).build(); }
}
