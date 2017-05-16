package com.lk.ofo.entity;

/**
 * Created by luokai on 2017/4/21.
 */
public class DestroyBicycle extends Basis {
    private int id;
    private int number;
    private String status;
    private String addressX;
    private String addressY;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressX() {
        return addressX;
    }

    public void setAddressX(String addressX) {
        this.addressX = addressX;
    }

    public String getAddressY() {
        return addressY;
    }

    public void setAddressY(String addressY) {
        this.addressY = addressY;
    }
}
