package model;

import java.sql.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO{

    public CustomerBean getCustomerByUsernameAndPassword(String username,String password)throws SQLException{
        try {
            ConnectionPool cp = new ConnectionPool();
            java.sql.Connection con = cp.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Clients where Username=? and Password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                CustomerBean customerBean = new CustomerBean();
                customerBean.setUsername(rs.getString("Username"));
                customerBean.setNome(rs.getString("Nome"));
                customerBean.setCognome(rs.getString("Cognome"));
                customerBean.setEmail(rs.getString("Email"));
                customerBean.setIsadmin(rs.getInt("isAdmin"));
                return customerBean;
            }
            return null;

        }catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }


    public void doSave(CustomerBean u) throws SQLException {
        ConnectionPool cp = new ConnectionPool();
        Connection con = ConnectionPool.getConnection();
        try {
            con = cp.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PreparedStatement ps = con.prepareStatement("INSERT INTO Clients(Nome,Cognome,Username,Password,isAdmin,Email) VALUES (?,?,?,?,?,?)");
        ps.setString(1, u.getNome());
        ps.setString(2, u.getCognome());
        ps.setString(3, u.getUsername());
        ps.setString(4, u.getPassword());
        ps.setInt(5,0);
        ps.setString(6, u.getEmail());
        ps.execute();
    }

    public boolean checkUsername(String username)throws SQLException{
        ConnectionPool cp = new ConnectionPool();
        Connection con = ConnectionPool.getConnection();

        try{
            con = cp.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }

        PreparedStatement ps = con.prepareStatement("SELECT Username FROM Clients WHERE Username = ?;");
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){

            return true;
        }
        return false;
    }
    public ArrayList<CustomerBean> getAllCustomer(){
        try{
            ConnectionPool cp = new ConnectionPool();
            Connection con = cp.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Clients");
            ResultSet rs = ps.executeQuery();
            ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
            while(rs.next()){

                CustomerBean customerBean = new CustomerBean();

                customerBean.setNome(rs.getString("Nome"));
                customerBean.setCognome(rs.getString("Cognome"));
                customerBean.setUsername(rs.getString("Username"));
                customerBean.setPassword(rs.getString("Password"));
                customerBean.setEmail(rs.getString("Email"));
                customerBean.setIsadmin(rs.getInt("IsAdmin"));

                list.add(customerBean);
            }
            return list;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }
}