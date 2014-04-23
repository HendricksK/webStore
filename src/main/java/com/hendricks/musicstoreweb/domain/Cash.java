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
public final class Cash {
    private String transaction;
    private int ID;
    
    private Cash(){};
    
    private Cash(Cash item){
        this.transaction = item.transaction;
        this.ID = item.ID;
    }
    
    private Cash(Builder item){
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
        
        public Builder Cash(Cash item){
            this.ID = item.ID;
            return this;
        }
        
        public Cash build(){
            return new Cash(this);
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
        int hash = 5;
        hash = 89 * hash + this.ID;
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
        final Cash other = (Cash) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
}
