package dao.jdbc;

import core.CriminalCase;
import core.Detective;
import dao.IDetective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCDetectiveDAO implements IDetective {
    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);

    @Override
    public void create(Detective detective) {
        try (Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO detective" +
                    " (id, user_name, first_name, last_name, password, hiring_date, badge, rank, armed, status, idCriminal) VALUES " +
                    "(?,?,?,?,?,?,?,?,?,?,?);");
            stmt.setLong(1, detective.getId());
            stmt.setString(2, detective.getUserName());
            stmt.setString(3, detective.getFirstName());
            stmt.setString(4, detective.getLastName());
            stmt.setString(5, detective.getPassWord());
            stmt.setString(6, detective.getHiringDate().toString());
            stmt.setString(7, detective.getBadgeNumber());
            stmt.setString(8, detective.getRank().toString());
            stmt.setString(9, String.valueOf(detective.isArmed()));
            stmt.setString(10,detective.getStatus().toString());
            stmt.setLong(11, detective.getIdCriminal());
            stmt.executeUpdate ();

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public void update(Detective detective, Long id) {
        try (Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("Update detective" +
                    " set id=?, user_name=?, first_name=?, last_name=?, password=?, hiring_date=?, badge=?, rank=? armed=?, " +
                    "status=?, idCriminal=? " +
                    "where id=?");
            stmt.setLong(1, detective.getId());
            stmt.setString(2, detective.getUserName());
            stmt.setString(3, detective.getFirstName());
            stmt.setString(4, detective.getLastName());
            stmt.setString(5, detective.getPassWord());
            stmt.setString(6, detective.getHiringDate().toString());
            stmt.setString(7, detective.getBadgeNumber());
            stmt.setString(8, String.valueOf(detective.getRank()));
            stmt.setString(9, String.valueOf(detective.isArmed()));
            stmt.setString(10, String.valueOf(detective.getStatus()));
            stmt.setLong(11, detective.getIdCriminal());
            stmt.executeUpdate ();

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection con = DatabaseUtility.getConnection()) {

            PreparedStatement stmt = con.prepareStatement("delete from detective where id=?");
            stmt.setLong(1, id);
            stmt.executeUpdate ();

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public Detective findById(Long id) {
        Detective detective = new Detective();
        try (Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("select id, user_name, first_name, last_name, password," +
                    " hiring_date, badge, rank, armed, status, id_criminal" +
                    " where id =? " );
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery ();
            while (rs.next()) {
                detective = DatabaseMapper.getDetective(rs);
                logger.debug(detective.toString());


            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return detective;
    }

    @Override
    public List<Detective> getAll() {
        List<Detective> detectives = new ArrayList<>();
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM detective");
             ResultSet rs = stmt.executeQuery ()) {

            while (rs.next()) {
                Detective detective = DatabaseMapper.getDetective(rs);
                logger.debug(detective.toString());

                if(detective != null) detectives.add(detective);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

        return detectives;
    }

    @Override
    public int countT() {
        int count = 0;
        try (Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("Select COUNT(*) AS recordCount from detective"
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
