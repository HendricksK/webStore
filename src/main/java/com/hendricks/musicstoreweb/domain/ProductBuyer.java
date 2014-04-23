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
public class ProductBuyer {
    private String Name;
    private int ID;
    private List<MediaSupplier> mediaSuppList = new ArrayList();
    private List<DeviceSupplier> deviceSuppList = new ArrayList();
    
    private ProductBuyer(){};
    
    private ProductBuyer(ProductBuyer item){
        this.Name = item.Name;
        this.ID = item.ID;
    }
    
    private ProductBuyer(Builder item){
        this.Name = item.Name;
        this.ID = item.ID;
    }
    
    public static class Builder{
        private String Name;
        private int ID;
        private List<MediaSupplier> mediaSuppList = new ArrayList();
        private List<DeviceSupplier> deviceSuppList = new ArrayList();
        
        public Builder(int ID){
            this.ID = ID;
        }
        
        public Builder setName(String value){
            this.Name = value;
            return this;
        }
        
        public Builder ProductBuyer(ProductBuyer item){
            this.Name = item.Name;
            return this;
        }

        public Builder setMediaSuppList(List<MediaSupplier> mediaSuppList) {
            this.mediaSuppList = mediaSuppList;
            return this;
        }

        public Builder setDeviceSuppList(List<DeviceSupplier> deviceSuppList) {
            this.deviceSuppList = deviceSuppList;
            return this;
        }
        
        public ProductBuyer build(){
            return new ProductBuyer(this);
        }
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }

    public List<MediaSupplier> getMediaSuppList() {
        return mediaSuppList;
    }

    public List<DeviceSupplier> getDeviceSuppList() {
        return deviceSuppList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.ID;
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
        final ProductBuyer other = (ProductBuyer) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
}
