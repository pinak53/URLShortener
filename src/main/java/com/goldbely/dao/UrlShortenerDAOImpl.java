package com.goldbely.dao;

import java.util.HashMap;

public class UrlShortenerDAOImpl implements UrlShortenerDAO
{
  private HashMap<String, String> keyMap;
  private HashMap<String, String> longUrlMap;
  
  public UrlShortenerDAOImpl(){
    this.keyMap = new HashMap<String, String>();
    this.longUrlMap = new HashMap<String, String>();
  }
  
  public String getKey(String longUrl)
  {
    return longUrlMap.get(longUrl);
    
  }

  public String getLongUrl(String key)
  {
    
    return keyMap.get(key);
  }

  public boolean isExistingKey(String key)
  {    
    return keyMap.containsKey(key);
  }

  public void addKeyLongUrlMapping(String key,
                          String longUrl)
  {
    keyMap.put(key, longUrl);
  }

  public void addLongUrlKeyMapping(String longUrl,
                          String key)
  {
    longUrlMap.put(longUrl, key);
  }

  public boolean isExistingLongUrl(String longUrl)
  {  
    return longUrlMap.containsKey(longUrl);
  }

}
