package fis.bank.criminal.repository.jdbctemplate.mapper;


import fis.bank.criminal.entity.Detective;
import fis.bank.criminal.entity.enums.EmployeeStatus;
import fis.bank.criminal.entity.enums.Rank;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetectiveRowMapper implements RowMapper<Detective> {
    @Override
    public Detective mapRow(ResultSet rs, int rowNum) throws SQLException {
        Detective detective = new Detective();
        detective.setId(rs.getLong("id"));
        detective.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        detective.setModifiedAt(rs.getTimestamp("modified_at").toLocalDateTime());
        detective.setVersion(rs.getInt("version"));
        detective.setArmed(rs.getBoolean("armed"));
        detective.setBadgeNumber(rs.getString("badgeNumber"));
        detective.setUserName(rs.getString("username"));
        detective.setFirstName(rs.getString("firstName"));
        detective.setLastName(rs.getString("lastName"));
        detective.setPassWord(rs.getString("password"));
        detective.setHiringDate(rs.getTimestamp("hiringDate").toLocalDateTime());
        detective.setRank(Rank.valueOf(rs.getString("rank_detective")));
        detective.setStatus(EmployeeStatus.valueOf(rs.getString("status_detective")));
        return detective;
    }
}
