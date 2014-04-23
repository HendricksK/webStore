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
public final class Card {
    
    private String transaction;
    private int ID;
    
    private Card(){};
    
    private Card(Card item){
        this.transaction = item.transaction;
        this.ID = item.ID;
    }
    
    private Card(Builder item){
        this.ID = item.ID;
        this.transaction = item.transaction;
    }
    
    public static class Builder{
        private String transaction;
        private int ID;
        
        public Builder(String item){
            this.transaction = item;
        }

        public Builder setID(int ID) {
            this.ID = ID;
            return this;
        }
        
        public Builder Card(Card item){
            this.ID = item.ID;
            return this;
        }
        
        public Card build(){
            return new Card(this);
        }  
    }

    public String getTransaction() {
        return transaction;
    }

    public int getID() {
        return ID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.ID;
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
        final Card other = (Card) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
}
