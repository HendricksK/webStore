/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb.test.repository;

import com.hendricks.musicstoreweb.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb.domain.Album;
import com.hendricks.musicstoreweb.domain.Song;
import com.hendricks.musicstoreweb.domain.songsEmbeddable;
import com.hendricks.musicstoreweb.repository.AlbumRepository;
import java.util.ArrayList;
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
public class AlbumRepositoryTest {
    
    public static ApplicationContext ctx;
    private AlbumRepository albumRepo;
    public List<songsEmbeddable> songs = new ArrayList();
    
    public AlbumRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void createAlbum(){
        
        albumRepo = ctx.getBean(AlbumRepository.class);
        
        songsEmbeddable s1 = new songsEmbeddable();
        s1.setTitle("Open your Eyes and Look North");
        s1.setAlbum("Downtown Battle Mountain");
        s1.setTrackNum(9);
       
        
        Album a = new Album();
        a.setName("Downtown Battle Mountain");
        a.setSongs(s1);
                
        albumRepo.save(a);
        Assert.assertNotNull(a);
        
    }
    
    @Test
    public void deleteAlbum(){
        albumRepo = ctx.getBean(AlbumRepository.class);
        List<Album> a = new ArrayList();
        a = albumRepo.findAll();
            for(int x = 0; x < a.size(); x++)
                a.get(x).display();
        //albumRepo.deleteAllInBatch();
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
