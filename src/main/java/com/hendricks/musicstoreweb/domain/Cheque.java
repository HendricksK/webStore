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
public final class Cheque {
    
    private String transaction;
    private int ID;
    
    private Cheque(){};
    
    private Cheque(Cheque item){
        this.transaction = item.transaction;
        this.ID = item.ID;
    }
    
    private Cheque(Builder item){
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
        
        public Builder Cheque(Cheque item){
            this.ID = item.ID;
            return this;
        }
        
        public Cheque build(){
            return new Cheque(this);
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
        hash = 13 * hash + this.ID;
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
        final Cheque other = (Cheque) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
}
