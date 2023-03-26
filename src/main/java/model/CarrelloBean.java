package model;

import java.util.ArrayList;

public class CarrelloBean{

    ArrayList<ProductcartBean> products;

    public CarrelloBean(){
    }

    public CarrelloBean(ArrayList<ProductcartBean> products){
        this.products = products;
    }

    public ArrayList<ProductcartBean> getProducts(){
        return products;
    }

    public void setProducts(ArrayList<ProductcartBean> products){
        this.products = products;
    }

}
