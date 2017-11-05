package com.example.muska.tp;

/**
 * Created by muska on 02-04-2017.
 */

public class Contact {

    String name,email,uname,pass;
    int id;

    //constructor
    Contact(){}

    public void setName(String name)
    {
        this.name=name;

    }
    public String getName()
    {
        return this.name;
    }
    public void setEmail(String email)
    {
        this.email=email;

    }
    public String  getEmail()
    {
        return this.email;
    }

    public void setUname(String uname)
    {
        this.uname=uname;

    }
    public String getUname()
    {
        return this.uname;
    }
    public void setPass(String pass)
    {
        this.pass=pass;

    }
    public String getPass()
    {
        return this.pass;
    }

}
