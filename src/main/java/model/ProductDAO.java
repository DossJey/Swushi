package model;

import java.sql.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductDAO {

        public ProductBean getProductById(int idprod){

            try{
                ConnectionPool cp = new ConnectionPool();
                java.sql.Connection con = cp.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE Idprodotto=?");
                ps.setInt(1, idprod);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){

                    ProductBean productBean = new ProductBean();
                    productBean.setIdprod(idprod);
                    productBean.setNome(rs.getString("Nome"));
                    productBean.setPrezzo((Double.parseDouble(rs.getString("Prezzo"))));
                    productBean.setDescrizione(rs.getString("Descrizione"));
                    return productBean;
                }
                return null;

            }catch(SQLException e){
                e.printStackTrace();
            }
            return null;
        }

    public ArrayList<ProductBean> getProductList(){

        try{
            ConnectionPool cp = new ConnectionPool();
            java.sql.Connection con = cp.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Products");
            ResultSet rs = ps.executeQuery();
            ArrayList<ProductBean> list = new ArrayList<ProductBean>();
            while(rs.next()){

                ProductBean productBean = new ProductBean();
                productBean.setIdprod(rs.getInt("Idprodotto"));
                productBean.setNome(rs.getString("Nome"));
                productBean.setPrezzo((Double.parseDouble(rs.getString("Prezzo"))));
                productBean.setDescrizione(rs.getString("Descrizione"));
                list.add(productBean);
            }
            return list;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void doSave(ProductBean productBean)throws SQLException{

            ConnectionPool cp = new ConnectionPool();
            Connection con = ConnectionPool.getConnection();

            try{
                con = cp.getConnection();

            }catch(SQLException e){
                e.printStackTrace();
            }
            PreparedStatement ps = con.prepareStatement("INSERT INTO Products(Idprodotto,Nome,Prezzo,Descrizione)VALUES(?,?,?,?,?)");
            ps.setInt(1,productBean.getIdprod());
            ps.setString(2, productBean.getNome());
            ps.setDouble(3,productBean.getPrezzo());
            ps.setString(5, productBean.getDescrizione());
        }

    public void modificaPrezzo(double prezzo,int id)throws SQLException{
        ConnectionPool cp = new ConnectionPool();
        Connection con = ConnectionPool.getConnection();

        try{
            con = cp.getConnection();

        }catch(SQLException e){
            e.printStackTrace();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE Products SET Prezzo=? WHERE idProdotto=? ");
        ps.setDouble(1,prezzo);
        ps.setInt(2,id);
        int rs = ps.executeUpdate();


    }



}
