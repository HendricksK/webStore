/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kurvin
 */
@Entity
public class PurchaseVinyl{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Double price;
    
    private PurchaseVinyl(){};
    
    private PurchaseVinyl(PurchaseVinyl item){
        this.ID = item.ID;
        this.price = item.price;
    }
    
    private PurchaseVinyl(Builder item){
        this.ID = item.ID;
        this.price = item.price;
    }
    
        public static class Builder{
            private Long ID;
            private Double price;
            
            public Builder setPrice(Double price){
                this.price = price;
                return this;
            }
            
            public Builder PurchaseVinyl(PurchaseVinyl item){
                this.ID = item.ID;
                this.price = item.price;
                return this;
            }
            
            public PurchaseVinyl build(){
                return new PurchaseVinyl(this);
            }

        }

    public Double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.ID);
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
        final PurchaseVinyl other = (PurchaseVinyl) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
        
    
}
