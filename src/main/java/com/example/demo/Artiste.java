package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artiste {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String fullName;
    private  String stageName;
    private String image;
    @OneToMany(mappedBy = "leadArtiste")
     private Set<Song> mySongs;

    public Artiste() {
        mySongs = new HashSet<>();
    }

    public Artiste(String fullName, String stageName, String image, Set<Song> mySongs) {
        this.fullName = fullName;
        this.stageName = stageName;
        this.image = image;
        this.mySongs = mySongs;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Artiste{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }


    public Set<Song> getMySongs() {
        return mySongs;
    }

    public void setMySongs(Set<Song> mySongs) {
        this.mySongs = mySongs;
    }
}
