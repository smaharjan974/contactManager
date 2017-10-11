package com.example.sanjay.samelikeviber;

import android.widget.Button;
import android.widget.ImageView;


/**
 * Created by SANJAY on 10/5/2017.
 */

public class Model {

    int img;
    private String txtname, txtphone, txtlocation;
    public String get;


    public Model( int img,String txtname, String txtphone, String txtlocation) {
        this.img = img;
        this.txtname = txtname;
        this.txtphone = txtphone;
        this.txtlocation = txtlocation;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTxtname() {
        return txtname;
    }

    public void setTxtname(String txtname) {
        this.txtname = txtname;
    }

    public String getTxtphone() {
        return txtphone;
    }

    public void setTxtphone(String txtphone) {
        this.txtphone = txtphone;
    }

    public String getTxtlocation() {
        return txtlocation;
    }

    public void setTxtlocation(String txtlocation) {
        this.txtlocation = txtlocation;
    }


}
