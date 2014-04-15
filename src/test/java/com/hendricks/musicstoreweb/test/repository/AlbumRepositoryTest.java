/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb.test.repository;

import com.hendricks.musicstoreweb.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb.domain.Album;
import com.hendricks.musicstoreweb.domain.Song;
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
    public List<Song> songs = new ArrayList();
    
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
        
        Song s = new Song.Builder(1)
                .setAlbum("Downtown Battle Mountain II")
                .setName("Power To The People")
                .build();
        
        songs.add(s);
        
        Album a = new Album();
        a.setName(s.getAlbum());
                
        albumRepo.save(a);
        Assert.assertNotNull(a);
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
