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



   public String getNamemovie(){return namemovie;}

    public void setNamemovie(String namemovie) {
        this.namemovie = namemovie;
    }

    public String getNameseries() {
        return nameseries;
    }

    public void setNameseries(String nameseries) {
        this.nameseries = nameseries;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
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

    public String getnamemovie() {
        return "" ;
    }

    public String getnameseries() {
        return "" ;
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
