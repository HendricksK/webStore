/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author kurvin
 */
@Entity
public class Vinyl implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String album;
    private String artist;
    
    private Vinyl(){};
    
    private Vinyl(Vinyl item){
        this.album = item.album;
        this.artist = item.artist;
        this.id = item.id;
        //this.songList = item.songList;
    }
    
    private Vinyl(Builder item){
        this.album = item.album;
        this.artist = item.artist;
        this.id = item.id;
        //this.songList = item.songList;
    }
    
        public static class Builder{
            private static final long serialVersionUID = 1L;
            @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            private Long id;
            private String album;
            private String artist;
            
            public Builder(){
                //default constructor for builder
            }

        public Builder setAlbum(String album) {
            this.album = album;
            return this;
        }

        public Builder setArtist(String artist) {
            this.artist = artist;
            return this;
        }

        /*public Builder setSongList(List<Song> songList) {
            this.songList = songList;
            return this;
        }*/
      
        
        public Builder Vinyl(Vinyl item){
            this.album = item.album;
            this.artist = item.artist;
            //this.songList = item.songList;
            return this;
        }
            
        public Vinyl build(){
            return new Vinyl(this);
        }    
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public long getID() {
        return id;
    }

    /*public List<Song> getSongList() {
        return songList;
    }*/

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vinyl other = (Vinyl) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vinyl{" + "id=" + id + '}';
    }
    
    
    
    
}
