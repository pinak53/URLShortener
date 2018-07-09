package com.goldbely.util;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlHelper
{

  public static URI getRedirectUrl(String longUrl) throws URISyntaxException{
    if(longUrl == null || longUrl.equals("")){
      return null;
    }
    if(longUrl.startsWith("http://")){
      return new URI(longUrl);
    } 
    return new URI("http://" + longUrl);
  }
  
}
