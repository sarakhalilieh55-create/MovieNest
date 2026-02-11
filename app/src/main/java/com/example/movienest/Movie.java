package com.example.movienest;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String namemovie;

    private String nameseries;
    private String time;
    private  String year;
    private  String summarize;
    private  String type;
    private  String producers;
    private  String   actors;
    private String photo;

    public Movie() {
    }

    public Movie(String namemovie, String nameseries, String time,  String year,
                   String summarize, String type,  String producers, String actors,
                   String photo) {
        this.namemovie = namemovie;
        this.nameseries = nameseries;
        this.time = time;
        this.year = year;
        this.summarize = summarize;
        this.type = type;
        this.producers = producers;
        this.actors = actors;
        this.photo = photo;
    }

    protected Movie(Parcel in) {
        this.namemovie = in.readString();
        this.nameseries = in.readString();
        this.time = in.readString();
        this.year = in.readString();
        this.summarize = in.readString();
        this.type = in.readString();
        this.producers = in.readString();
        this.actors = in.readString();
        this.photo = in.readString();

    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.namemovie);
        dest.writeString(this.nameseries);
        dest.writeString(this.time);
        dest.writeString(this.year);
        dest.writeString(this.summarize);
        dest.writeString(this.type);
        dest.writeString(this.producers);
        dest.writeString(this.actors);
        dest.writeString(this.photo);

    }

    public String getId() {
        return namemovie;
    }

    public void setId(String id) {
        this.namemovie = namemovie;
    }

    public String getNameCar() {
        return nameseries;
    }

    public void setNameCar(String nameCar) {
        this.nameseries = nameseries;
    }

    public String getHorse_power() {
        return time;
    }

    public void setHorse_power(String horse_power) {
        this.time = time;
    }

    public String getOwners() {
        return year;
    }

    public void setOwners(String owners) {
        this.year = year;
    }

    public String getPhone() {
        return summarize;
    }

    public void setPhone(String phone) {
        this.summarize = summarize;
    }

    public String getColor() {
        return type;
    }

    public void setColor(String color) {
        this.type = type;
    }

    public String getCar_num() {
        return producers;
    }

    public void setCar_num(String car_num) {
        this.producers = producers;
    }

    public String getManufacturer() {
        return actors;
    }

    public void setManufacturer(String manufacturer) {
        this.actors = actors;
    }

    public String getYear() {
        return photo;
    }

    public void setYear(String year) {
        this.photo = photo;
    }



    @Override
    public String toString() {
        return "Car{" +
                ", namemovie='" + namemovie + '\'' +
                " , nameseries='" + nameseries + '\'' +
                ",time ='" + time + '\'' +
                ", year='" + year + '\'' +
                ", summarize='" + summarize + '\'' +
                ", type='" + type + '\'' +
                ", producers='" + producers + '\'' +
                ", actors='" + actors + '\'' +
                ", photo='" + photo + '\'' +

                '}';
    }

    public int describeContents() {
        return 0;
    }

    public String getNamemovie() {
        return namemovie;
    }

    public String getNameseries() {
        return nameseries;
    }

    public String getnameseries() {
        return null;
    }

    public String getnamemovie() {
        String o = null;
        return o;
    }

    public String gettime() {
        return "";
    }

    public String getyear() {
        return "";
    }

    public String getsummerize() {
        return "";
    }

    public String gettype() {
        return "";
    }

    public String getprodusers() {
        return "";
    }

    public String getactors() {
        return "";
    }

    public String getphoto() {
        return null;
    }
}
