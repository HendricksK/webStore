/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb.test.repository;

import com.hendricks.musicstoreweb.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb.domain.ProductPurchase;
import com.hendricks.musicstoreweb.domain.PurchaseCD;
import com.hendricks.musicstoreweb.domain.PurchaseDevice;
import com.hendricks.musicstoreweb.repository.ProductPurchaseRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author kurvin
 */
public class ProductPurchaseRepositoryTest {
    
    private static Long id;
    private static ApplicationContext ctx;
    
    private static ProductPurchaseRepository repo;
    
    public ProductPurchaseRepositoryTest() {
    }
    
    @Test 
    public static void createPP(){
        repo = ctx.getBean(ProductPurchaseRepository.class);
        Date d = new Date();
        
        List<PurchaseCD> cdPurchaces = new ArrayList<>();
        
        ProductPurchase p = new ProductPurchase.Builder(d)
                .setCdPurchases(cdPurchaces)
                .build();
        
        repo.save(p);
        
        id = p.getID();
        Assert.assertNotNull(p);
                
    }
    
    @Test(dependsOnMethods="createPP")
    public static void readPP(){
        repo = ctx.getBean(ProductPurchaseRepository.class);
        
        ProductPurchase p = repo.findOne(id);
        Assert.assertEquals(p.getID(), id);
    }
    
    @Test(dependsOnMethods="createPP")
    public static void updatePP(){
         repo = ctx.getBean(ProductPurchaseRepository.class);
         
         ProductPurchase p = repo.findOne(id);
         
         List<PurchaseDevice> dPurchaces = new ArrayList<>();
         
         ProductPurchase update = new ProductPurchase.Builder(p.getDate())
                 .setDevicePurchases(dPurchaces)
                 .ProductPurchase(p)
                 .build();
         
         repo.save(update);
    
    }
    
    @Test(dependsOnMethods="readPP")
    public static void deletePP(){
        repo = ctx.getBean(ProductPurchaseRepository.class);
        
        repo.delete(id);
        ProductPurchase p = repo.findOne(id);
        Assert.assertNull(p);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
