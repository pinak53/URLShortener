package com.goldbely.util;

import org.json.JSONObject;

public class JsonHelper
{
  public static String getLongUrl(String jsonData){
    
    String longUrl = "";
    if(jsonData == null) return longUrl;
    final JSONObject obj = new JSONObject(jsonData);
    if(obj.has("url")){
      longUrl = (String) obj.get("url");
    }   
    return longUrl;
  }
  
  public static String getSlug(String jsonData){
    String slug = null;
    if(jsonData == null) return slug;
    final JSONObject obj = new JSONObject(jsonData);
    if(obj.has("slug")){
      slug = (String) obj.get("slug");
    }
    return slug;
  }
  
  public static String buildShortenUrlResponse(String shortUrl, String longUrl){
    JSONObject json = new JSONObject();
    json.put("shortUrl", shortUrl);
    json.put("longUrl", longUrl);
    return json.toString();
  }
  
}
