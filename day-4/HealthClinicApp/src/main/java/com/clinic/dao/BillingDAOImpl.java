package com.clinic.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.clinic.dto.Billing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class BillingDAOImpl implements BillingDAO {
    private final JdbcTemplate jdbcTemplate;
    public BillingDAOImpl(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public Billing generateBill(Billing billing) {
        KeyHolder keys = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO billing (appointment_id,amount,payment_status) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, billing.getAppointmentId()); statement.setBigDecimal(2, billing.getAmount()); statement.setString(3, billing.getPaymentStatus().name()); return statement;
        }, keys);
        billing.setBillId(keys.getKey().intValue()); return billing;
    }

    @Override public int updatePaymentStatus(int billId, Billing.PaymentStatus status) { return jdbcTemplate.update("UPDATE billing SET payment_status=? WHERE bill_id=?", status.name(), billId); }
    @Override public Optional<Billing> findById(int id) { return jdbcTemplate.query("SELECT * FROM billing WHERE bill_id=?", rowMapper(), id).stream().findFirst(); }
    @Override public Optional<Billing> findByAppointmentId(int id) { return jdbcTemplate.query("SELECT * FROM billing WHERE appointment_id=?", rowMapper(), id).stream().findFirst(); }
    @Override public List<Billing> findAll() { return jdbcTemplate.query("SELECT * FROM billing ORDER BY bill_id", rowMapper()); }
    private org.springframework.jdbc.core.RowMapper<Billing> rowMapper() { return (rs, row) -> Billing.builder().billId(rs.getInt("bill_id")).appointmentId(rs.getInt("appointment_id")).amount(rs.getBigDecimal("amount")).paymentStatus(Billing.PaymentStatus.valueOf(rs.getString("payment_status"))).billingDate(rs.getObject("billing_date", java.time.LocalDateTime.class)).build(); }
}
