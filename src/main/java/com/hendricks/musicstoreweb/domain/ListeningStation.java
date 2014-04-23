/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendricks.musicstoreweb.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kurvin
 */
public final class ListeningStation {

    private String album;
    private String artist;
    private int ID;
    private List<Album> albumList = new ArrayList();

    private ListeningStation() {
    }

    ;
    
    private ListeningStation(ListeningStation item) {
        this.album = item.album;
        this.artist = item.artist;
        this.ID = item.ID;
    }

    private ListeningStation(Builder item) {
        this.album = item.album;
        this.artist = item.artist;
        this.ID = item.ID;
    }

    public static class Builder {

        private String album;
        private String artist;
        private int ID;
        private List<Album> albumList = new ArrayList();

        public Builder(int ID) {
            this.ID = ID;
        }

        public Builder setAlbum(String album) {
            this.album = album;
            return this;
        }

        public Builder setArtist(String artist) {
            this.artist = artist;
            return this;
        }

        public Builder setAlbumList(List<Album> albumList) {
            this.albumList = albumList;
            return this;
        }

        public Builder ListeningStation(ListeningStation item) {
            this.album = item.album;
            this.artist = item.artist;
            this.albumList = item.albumList;
            return this;
        }

        public ListeningStation build() {
            return new ListeningStation(this);
        }
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public int getID() {
        return ID;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.ID;
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
        final ListeningStation other = (ListeningStation) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

}
