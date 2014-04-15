/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb.domain;

/**
 *
 * @author kurvin
 */
public final class Song {
    
    private String name;
    private int ID;
    private String album;
    private int trackNum;
    
    private Song(){};
    
    private Song(Song item){
        name = item.name;
        ID = item.ID;
        album = item.album;
        trackNum = item.trackNum;
    }
    
    private Song(Builder item){
        name = item.name;
        ID = item.ID;
        album = item.album;
        trackNum = item.trackNum;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getAlbum() {
        return album;
    }

    public int getTrackNum() {
        return trackNum;
    }
    
    
    
        public static class Builder{
            
            private String name;
            private int ID;
            private String album;
            private int trackNum;
            
            public Builder(int value){
                ID = value;
            }
            
            public Builder setName(String value){
                this.name = value;
                return this;
            }
            
            public Builder setAlbum(String value){
                this.album = value;
                return this;
            }
            
            public Builder setTrack(int value){
                this.trackNum = value;
                return this;
            }
            
            public Builder Song(Song item){
                this.name = item.name;
                this.album = item.album;
                this.trackNum = item.trackNum;
                return this;
            }
            
            public Song build(){
                return new Song(this);
            }
        }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.ID;
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
        final Song other = (Song) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
        
    
}
