package com.example.vincent.utilisateurs;


public class User {

    private String nom, email, img;

    public User(){

        this.nom = "";
        this.email = "";
        this.img = "";
    }

    public String toString(User pUser){

        String toString = pUser.getNom() + " " + pUser.getEmail();
        return (toString);
    }


    public String getNom(){

        return this.nom;
    }

    public String getEmail(){

        return this.email;
    }

    public String getImg(){

        return this.img;
    }

    public void setNom(String pNom){

        this.nom = pNom;
    }

    public void setEmail(String pEmail){

        this.email = pEmail;
    }

    public void setImg(String pImg){

        this.img = pImg;
    }
}
