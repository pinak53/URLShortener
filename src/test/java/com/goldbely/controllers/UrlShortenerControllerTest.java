package com.goldbely.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.junit.Test;

public class UrlShortenerControllerTest
{
  private static final int KEY_LENGTH = 9;
  private static final String DOMAIN = "http://goldbely.us";
    
  @Test
  public void testUrlShorteningForNullUrl(){
    String slug = null;
    String shortUrl = UrlShortenerController.INSTANCE.getShortUrl(null, slug);
    assertTrue(shortUrl == null);
  }
  
  @Test
  public void testUrlShorteningForEmptyString(){
    String slug = null;
    String shortUrl = UrlShortenerController.INSTANCE.getShortUrl("", slug);
    assertTrue(shortUrl == null);
  }
  
  @Test
  public void testUrlShorteningWithSlug(){
    String slug = "123456789";
    String shortUrl = UrlShortenerController.INSTANCE.getShortUrl("http://www.google.com", slug);
    String[] splittedShortUrl = shortUrl.split("/");   
    String key = splittedShortUrl[splittedShortUrl.length - 1];
    assertTrue(key!=null);
    assertEquals(slug, key);
    assertEquals(DOMAIN + "/" + key, shortUrl);
  }
  
  @Test
  public void testUrlShorteningWithoutSlug(){
    String slug = null;
    String shortUrl = UrlShortenerController.INSTANCE.getShortUrl("http://www.google.com", slug);
    String[] splittedShortUrl = shortUrl.split("/");   
    String key = splittedShortUrl[splittedShortUrl.length - 1];
    assertTrue(key!=null);
    assertEquals(KEY_LENGTH, key.length());
    assertEquals(DOMAIN + "/" + key, shortUrl);  
  }
   
  @Test
  public void testExpandUrlForNullUrl(){
    URI longUrl = UrlShortenerController.INSTANCE.getLongUrl(null);
    assertTrue(longUrl == null);
  }
  
  @Test
  public void testExpandUrlForEmptyString(){
    URI longUrl = UrlShortenerController.INSTANCE.getLongUrl("");
    assertTrue(longUrl == null);
  }
  
  @Test
  public void testExpandUrlForInValidKey(){
    URI longUrl = UrlShortenerController.INSTANCE.getLongUrl("123456");
    assertTrue(longUrl == null);
  }
  
  @Test
  public void testExpandUrlForValidKey(){
    String shortUrl = UrlShortenerController.INSTANCE.getShortUrl("www.amazon.com", null);
    String[] splittedShortUrl = shortUrl.split("/");   
    String key = splittedShortUrl[splittedShortUrl.length - 1];
    URI longUrl = UrlShortenerController.INSTANCE.getLongUrl(key);
    assertEquals("http://www.amazon.com", longUrl.toString());
  }
}
