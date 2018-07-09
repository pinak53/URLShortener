package com.goldbely.util;


import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

public class JsonHelperTest
{
  @Test
  public void testNullJsonDataForLongUrl(){
    assertEquals("", JsonHelper.getLongUrl(null));
  }
  
  @Test
  public void testNullJsonDataForSlug(){
    assertEquals(null, JsonHelper.getSlug(null));
  }
  
  @Test
  public void testEmptyJsonDataForLongUrl(){
    assertEquals("", JsonHelper.getLongUrl(null));
  }
  
  @Test
  public void testEmptyJsonDataForSlug(){
    assertEquals(null, JsonHelper.getSlug(null));
  }
  
  @Test
  public void testValidJsonDataForLongUrl(){
    JSONObject json = new JSONObject();
    json.put("url", "www.google.com");  
    String jsonData = json.toString();
    assertEquals("www.google.com", JsonHelper.getLongUrl(jsonData));
  }
  
  @Test
  public void testValidJsonDataForSlug(){
    JSONObject json = new JSONObject();
    json.put("slug", "12345678");  
    String jsonData = json.toString();
    assertEquals("12345678", JsonHelper.getSlug(jsonData));
  }
  
  @Test
  public void testShortenUrlResponse(){
    JSONObject json = new JSONObject();
    json.put("shortUrl", "http://goldbely.us/123456789");
    json.put("longUrl", "http://www.google.com");
    String jsonData = json.toString();
    assertEquals(jsonData, JsonHelper.buildShortenUrlResponse("http://goldbely.us/123456789", "http://www.google.com"));
  }
}
