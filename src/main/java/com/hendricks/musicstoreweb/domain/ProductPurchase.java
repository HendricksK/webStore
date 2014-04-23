/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author kurvin
 */
@Entity
public class ProductPurchase {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Date date;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_purchases")
    List<PurchaseCD> cdPurchases = new ArrayList();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_purchases")
    List<PurchaseDevice> devicePurchases = new ArrayList();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dg_purchases")
    List<PurchaseDigitalMedia> dgPurchases = new ArrayList();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "v_purchases")
    List<PurchaseVinyl> vinylPurchases = new ArrayList();
    
    
    private ProductPurchase(){};
    
    private ProductPurchase(ProductPurchase item){
        this.ID = item.ID;
    }
    
    private ProductPurchase(Builder p){
        this.ID = p.ID;
    }

    public Long getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public List<PurchaseCD> getCdPurchases() {
        return cdPurchases;
    }

    public List<PurchaseDevice> getDevicePurchases() {
        return devicePurchases;
    }

    public List<PurchaseDigitalMedia> getDgPurchases() {
        return dgPurchases;
    }

    public List<PurchaseVinyl> getVinylPurchases() {
        return vinylPurchases;
    }
    
    public static class Builder{
        private Long ID;
        private Date date;
        private List<PurchaseCD> cdPurchases = new ArrayList();
        private List<PurchaseDevice> devicePurchases = new ArrayList();
        private List<PurchaseDigitalMedia> dgPurchases = new ArrayList();
        private List<PurchaseVinyl> vinylPurchases = new ArrayList();
        
        public Builder(Date d){
            this.date = d;
        }

        public Builder setCdPurchases(List<PurchaseCD> cdPurchases) {
            this.cdPurchases = cdPurchases;
            return this;
        }

        public Builder setDevicePurchases(List<PurchaseDevice> devicePurchases) {
            this.devicePurchases = devicePurchases;
            return this;
        }

        public Builder setDvdPurchases(List<PurchaseDigitalMedia> dvdPurchases) {
            this.dgPurchases = dvdPurchases;
            return this;
        }

        public Builder setVinylPurchases(List<PurchaseVinyl> vinylPurchases) {
            this.vinylPurchases = vinylPurchases;
            return this;
        }
        
        public Builder ProductPurchase(ProductPurchase pp){
            this.ID = pp.ID;
            this.cdPurchases = pp.cdPurchases;
            this.date = pp.date;
            this.devicePurchases = pp.devicePurchases;
            this.dgPurchases = pp.dgPurchases;
            this.vinylPurchases = pp.vinylPurchases;
            return this;
        }
        
        public ProductPurchase build(){
            return new ProductPurchase(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.ID);
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
        final ProductPurchase other = (ProductPurchase) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
}
