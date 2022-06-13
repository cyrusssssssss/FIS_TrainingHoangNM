package dao.jdbc;

import core.CriminalCase;
import dao.ICriminalCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCCriminalCaseDAO implements ICriminalCase {
    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);
    @Override
    public void create(CriminalCase criminalCase) {
        try (Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO criminal_case" +
                    " (id, number, case_type, sort_des, detail, case_status, notes, id_leadInvest) VALUES " +
                    "(?,?,?,?,?,?,?,?);");
            stmt.setLong(1, criminalCase.getId());
            stmt.setString(2, criminalCase.getNumber());
            stmt.setString(3, criminalCase.getType().toString());
            stmt.setString(4, criminalCase.getSortDescription());
            stmt.setString(5, criminalCase.getDetailedDescription());
            stmt.setString(6, criminalCase.getStatus().toString());
            stmt.setString(7, criminalCase.getNotes());
            stmt.setString(8, criminalCase.getLeadInvestigator());
            stmt.executeUpdate ();

        } catch (Exception ex) {
            logger.error(ex.toString());
        }


    }

    @Override
    public void update(CriminalCase criminalCase, Long id) {
        try (Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("Update criminal_case" +
                    " set id=?, number=?, case_type=?, sort_des=?, detail=?, case_status=?, notes=?, id_leadInvest=? " +
                    "where id=?");
            stmt.setLong(1, criminalCase.getId());
            stmt.setString(2, criminalCase.getNumber());
            stmt.setString(3, criminalCase.getType().toString());
            stmt.setString(4, criminalCase.getSortDescription());
            stmt.setString(5, criminalCase.getDetailedDescription());
            stmt.setString(6, criminalCase.getStatus().toString());
            stmt.setString(7, criminalCase.getNotes());
            stmt.setString(8, criminalCase.getLeadInvestigator());
            stmt.setLong(9, id);
            stmt.executeUpdate ();

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("delete from criminal_case where id=?");
            stmt.setLong(1, id);
            stmt.executeUpdate ();

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public CriminalCase findById(Long id) {
        CriminalCase criminalCase = new CriminalCase();
        try (Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("select id, number, case_type, sort_des, detail," +
                    " case_status, notes, id_leadInvest criminal_case from criminal_case where id =? " );
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery ();
            while (rs.next()) {
                 criminalCase = DatabaseMapper.getCriminalCase(rs);
                logger.debug(criminalCase.toString());


            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return criminalCase;

    }

    @Override
    public List<CriminalCase> getAll() {
        List<CriminalCase> criminalCases = new ArrayList<>();
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM criminal_case");
             ResultSet rs = stmt.executeQuery ()) {

            while (rs.next()) {
                CriminalCase criminalCase = DatabaseMapper.getCriminalCase(rs);
                logger.debug(criminalCase.toString());

                if(criminalCase != null) criminalCases.add(criminalCase);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

        return criminalCases;
    }

    @Override
    public int countT() {
        int count = 0;
        try (Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("Select COUNT(*) AS recordCount from criminal_case"
                    );

            ResultSet rs = stmt.executeQuery ();
            rs.next();
            count  = rs.getInt("recordCount");


        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return count;
    }

}
