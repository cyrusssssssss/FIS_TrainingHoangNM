package dao.jdbc;

import core.CriminalCase;
import core.Detective;
import core.enums.CaseStatus;
import core.enums.CaseType;

import core.enums.EmployeeStatus;
import core.enums.Rank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DatabaseMapper {
    public static final Logger logger = LoggerFactory.getLogger(DatabaseMapper.class);

    public static CriminalCase getCriminalCase(ResultSet criminalCaseResultSet){
        try {
            CriminalCase criminalCase = new CriminalCase();

            criminalCase.setId(criminalCaseResultSet.getLong("id"));
            criminalCase.setNumber(criminalCaseResultSet.getString("number"));
            criminalCase.setType(CaseType.valueOf(criminalCaseResultSet.getString("case_type")));
            criminalCase.setSortDescription(criminalCaseResultSet.getString("sort_des"));
            criminalCase.setDetailedDescription(criminalCaseResultSet.getString("detail"));
            criminalCase.setStatus(CaseStatus.valueOf(criminalCaseResultSet.getString("case_status")));
            criminalCase.setNotes(criminalCaseResultSet.getString("notes"));
            criminalCase.setLeadInvestigator(criminalCaseResultSet.getString("id_leadInvest"));


            return criminalCase;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }

    public static Detective getDetective(ResultSet detectiveResultSet){
        try {
            Detective detective = new Detective();

            detective.setId(detectiveResultSet.getLong("id"));
            detective.setUserName(detectiveResultSet.getString("user_name"));
            detective.setFirstName(detectiveResultSet.getString("first_name"));
            detective.setLastName(detectiveResultSet.getString("last_name"));
            detective.setPassWord(detectiveResultSet.getString("password"));
            detective.setHiringDate(LocalDateTime.parse((detectiveResultSet.getString("hiring_date"))));
            detective.setBadgeNumber(detectiveResultSet.getString("badge"));
            detective.setRank(Rank.valueOf(detectiveResultSet.getString("rank")));
            detective.setArmed(Boolean.parseBoolean(detectiveResultSet.getString("armed")));
            detective.setStatus(EmployeeStatus.valueOf(detectiveResultSet.getString("status")));
            detective.setIdCriminal(detectiveResultSet.getLong("id_criminal"));

            return detective;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }

}
