/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb.test.repository;

import com.hendricks.musicstoreweb.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb.domain.Album;
import com.hendricks.musicstoreweb.domain.Artist;
import com.hendricks.musicstoreweb.domain.CD;
import com.hendricks.musicstoreweb.domain.Song;
import com.hendricks.musicstoreweb.domain.Vinyl;
import com.hendricks.musicstoreweb.repository.AlbumRepository;
import com.hendricks.musicstoreweb.repository.SongRepository;
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
/*
public class AlbumRepositoryTest {
    
    public static ApplicationContext ctx;
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private Long id;
    private Long songID;
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
        
        Album a = new Album.Builder("Downtown Battle Mountain II")
                .build();

        albumRepo.save(a);
        id = a.getId();
        
        Assert.assertNotNull(a);
        
    }
    
    @Test(dependsOnMethods = "createAlbum")
    public void readAlbum(){
        albumRepo = ctx.getBean(AlbumRepository.class);
        Album album = albumRepo.findOne(id);
        Assert.assertEquals(album.getName(), "Downtown Battle Mountain II");
    }
    
    @Test(dependsOnMethods = "createAlbum")
    private void updateAlbum(){
        albumRepo = ctx.getBean(AlbumRepository.class);
    }
    
    @Test(dependsOnMethods = "updateAlbum")
    private void deleteAlbum(){
        albumRepo = ctx.getBean(AlbumRepository.class);
        albumRepo.delete(id);
        Album album = albumRepo.findOne(id);
        Assert.assertNull(album);
        
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
}*/
