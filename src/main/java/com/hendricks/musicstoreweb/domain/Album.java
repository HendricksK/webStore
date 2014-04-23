/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author kurvin
 */
@Entity
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="album_id")
    List<Song> songList;*/
    
    /*@JoinColumn(name="album_id1")
    CD cd;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="album_id2")
    Vinyl vinyl;*/
    
    /*public List<Song> getSongList() {
        return songList;
    }*/

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void display(){
        System.out.println(toString());
    }

    /*public CD getCd() {
        return cd;
    }

    public Vinyl getVinyl() {
        return vinyl;
    }*/
    
    private Album(Builder b){
        this.id = b.id;
        this.name = b.name;
        //this.songList = b.songList;
    }
    
    private Album(Album a){
        this.id = a.id;
        this.name = a.name;
        //this.songList = a.songList;
    }
    
    private Album(){
        
    }
    
    public static class Builder{
        private Long id;
        private String name;
        /*@OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="album_id")
        List<Song> songList;*
        /*@JoinColumn(name="album_id")
        CD cd;
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="album_id")
        Vinyl vinyl;*/
        
        public Builder(String name){
            this.name = name;
        };
        
        public Builder setName(String nme){
            this.name = nme;
            return this;
        }
        
        /*public Builder setSongList(List<Song> s){
            this.songList = s;
            return this;
        }*/
        
        public Builder setId(Long ID){
            this.id = ID;
            return this;
        }

        /*public Builder setCd(CD cd) {
        this.cd = cd;
        return this;
        }
        public Builder setVinyl(Vinyl vinyl) {
        this.vinyl = vinyl;
        return this;
        }*/
        /*public Builder setMedia(MediaInterface media) {
            this.media = media;
            return this;
        }*/
        
        public Builder Album(Album a){
            this.id = a.id;
            //this.cd = a.cd;
            this.name = a.name;
            //this.songList = a.songList;
            //this.media = a.media;
            //this.vinyl = a.vinyl;
            return this;
        }
        
        public Album build(){
            return new Album(this);
        }

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hendricks.musicstoreweb.domain.Album[ id=" + id + " ]";
    }
    
}
