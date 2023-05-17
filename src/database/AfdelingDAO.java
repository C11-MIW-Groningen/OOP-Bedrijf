package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Purpose of the program
 */
public class AfdelingDAO {
    private DBaccess dBaccess;

    public AfdelingDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        String sql = "INSERT INTO afdeling (afdelingsnaam, afdelingsplaats) VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, afdeling.getAfdelingsNaam());
            preparedStatement.setString(2, afdeling.getAfdelingsPlaats());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("SQL Foutmelding: " + sqlException.getMessage());
        }
    }
}
