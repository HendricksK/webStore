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
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kurvin
 */
@Embeddable
public class Genre implements Serializable{
    private String name;
    private int ID;
    
    private Genre(){};
    
    private Genre(Builder item){
        name = item.name;
        ID = item.ID;
    }
    
    private Genre(Genre item){
        this.ID = item.ID;
        this.name = item.name;
    }
    
        public static class Builder{
            private String name;
            private int ID;

            public Builder(int value){
                this.ID = value;
            }

            public Builder setName(String name) {
                this.name = name;
                return this;
            }

            public Builder Genre(Genre item){
                name = item.name;
                return this;
            }
            
            public Builder Genre(Builder g){
                this.ID = g.ID;
                this.name = g.name;
                return this;
            }

            public Genre build(){
                return new Genre(this);
            }

        }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
    
}
