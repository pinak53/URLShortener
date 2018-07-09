package com.goldbely.dao;

public interface UrlShortenerDAO
{
  String getKey(String longUrl);
  
  String getLongUrl(String key);
  
  boolean isExistingKey(String key);
  
  boolean isExistingLongUrl(String longUrl);
  
  void addKeyLongUrlMapping(String key, String longUrl);
  
  void addLongUrlKeyMapping(String longUrl, String key);
}
