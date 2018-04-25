package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
     private  long  year;

    //There are many songs, but each of them is led by ONE artiste.
    //The Artiste's ID is repsresented in the song table as leadArtiste
    @ManyToOne()
    private  Artiste leadArtiste;
    public Song(){}

    public Song(String title) {
        this.title = title;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public Artiste getLeadArtiste() {
        return leadArtiste;
    }

    public void setLeadArtiste(Artiste leadArtiste) {
        this.leadArtiste = leadArtiste;
    }
}
