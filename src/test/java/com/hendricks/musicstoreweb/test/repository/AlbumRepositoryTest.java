/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb.test.repository;

import com.hendricks.musicstoreweb.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb.domain.Album;
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
        songRepo = ctx.getBean(SongRepository.class);
        
        
        Album a = new Album.Builder()
                .setName("Downtown Battle Mountain II")
                .build();
        
        Song s = new Song.Builder()
                .setAlbum(a.getName())
                .setTitle("Carve")
                .setTrackNum(05)
                .build();
        
        songRepo.save(s);
        songID = s.getId();
        songs.add(s);
        
        CD c = new CD.Builder()
                .setAlbum(a.getName())
                .setArtist("Dance Gavin Dance")
                .setSongID(songID)
                .build();
        
        Vinyl v = new Vinyl.Builder()
                .setAlbum(a.getName())
                .setArtist("Dance Gavin Dance")
                //.setSongList(songs)
                .build();
        
        Album b = new Album.Builder()
                .Album(a)
                .setCd(c)
                .setVinyl(v)
                .build();
                
        albumRepo.save(b);
        id = b.getId();
        Assert.assertNotNull(b);
        
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
        songRepo.delete(songID);
        Song song = songRepo.findOne(songID);
        Album album = albumRepo.findOne(id);
        Assert.assertNull(song);
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
}
