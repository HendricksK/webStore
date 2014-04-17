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
public class CD implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String album;
    private String artist;
    private Long songID;
    
    private CD(){};
    
    private CD(CD item){
        this.album = item.album;
        this.artist = item.artist;
        this.id = item.id;
        this.songID = item.songID;
    }
    
    private CD(Builder item){
        this.album = item.album;
        this.artist = item.artist;
        this.id = item.id;
        this.songID = item.songID;
    }
    
        public static class Builder{
            private static final long serialVersionUID = 1L;
            @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            private Long id;
            private String album;
            private String artist;
            private Long songID;
            
            public Builder(){
              //defauult constructor as the database itself willl be creating the ID
            }

            public Builder setAlbum(String album) {
                this.album = album;
                return this;
            }

            public Builder setArtist(String artist) {
                this.artist = artist;
                return this;
            }

            public Builder setSongID(Long s) {
                this.songID = s;
                return this;
            }

            public Builder CD(CD item){
                this.album = item.album;
                this.artist = item.artist;
                this.songID = item.songID;
                return this;
            }

            public CD build(){
                return new CD(this);
            }    
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public Long getID() {
        return id;
    }

    public Long getSongID() {
        return songID;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final CD other = (CD) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CD{" + "id=" + id + '}';
    }
        
       
}
