package model;
import java.sql.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PrenotazioneDAO {

    public PrenotazioneBean getPrenotazioneByEmail(String email) {

        try {
            ConnectionPool cp = new ConnectionPool();
            Connection con = cp.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Prenotazione WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                PrenotazioneBean prenotazioneBean = new PrenotazioneBean();
                prenotazioneBean.setEmail(email);
                prenotazioneBean.setNome(rs.getString("Nome"));
                prenotazioneBean.setOra(rs.getString("Ora"));
                prenotazioneBean.setCellulare(rs.getString("Cellulare"));
                prenotazioneBean.setPersone(rs.getInt("Persone"));
                prenotazioneBean.setGiorno(rs.getString("Giorno"));
                return prenotazioneBean;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<PrenotazioneBean> getPrenotazioni() {

        try {
            ConnectionPool cp = new ConnectionPool();
            Connection con = cp.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Prenotazione");
            ResultSet rs = ps.executeQuery();
            ArrayList<PrenotazioneBean> list = new ArrayList<PrenotazioneBean>();

            while(rs.next()){

                PrenotazioneBean prenotazioneBean = new PrenotazioneBean();
                prenotazioneBean.setEmail(rs.getString("Email"));
                prenotazioneBean.setNome(rs.getString("Nome"));
                prenotazioneBean.setOra(rs.getString("Ora"));
                prenotazioneBean.setCellulare(rs.getString("Cellulare"));
                prenotazioneBean.setPersone(rs.getInt("Persone"));
                prenotazioneBean.setGiorno(rs.getString("Giorno"));
                list.add(prenotazioneBean);
            }


            return list;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void doSave(PrenotazioneBean prenotazioneBean)throws SQLException{

        ConnectionPool cp = new ConnectionPool();
        Connection con = ConnectionPool.getConnection();

        try{
            con = cp.getConnection();

        }catch(SQLException e){
            e.printStackTrace();
        }
        PreparedStatement ps = con.prepareStatement("INSERT INTO Prenotazione(Email,Nome,Giorno,Cellulare,Ora,Persone)VALUES(?,?,?,?,?,?)");
        ps.setString(1,prenotazioneBean.getEmail());
        ps.setString(2, prenotazioneBean.getNome());
        ps.setString(3,prenotazioneBean.getGiorno());
        ps.setString(4, prenotazioneBean.getCellulare());
        ps.setString(5,prenotazioneBean.getOra());
        ps.setInt(6,prenotazioneBean.getPersone());
        ps.execute();

    }



}