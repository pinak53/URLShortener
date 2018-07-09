package com.goldbely.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import com.goldbely.dao.KeyGeneratorDAO;
import com.goldbely.dao.KeyGeneratorDAOImpl;
import com.goldbely.dao.UrlShortenerDAO;
import com.goldbely.dao.UrlShortenerDAOImpl;
import com.goldbely.util.UrlHelper;
import com.goldbely.util.UrlValidator;

public class UrlShortenerController
{

  //The domain could be made configurable using properties.  
  private static final String DOMAIN = "http://goldbely.us";
  private UrlShortenerDAO urlShortenerDAO;
  private KeyGeneratorDAO keyGeneratorDAO;
  private String domain;
  
  //Using the singleton design pattern for the controller.
  //This could be done via dependency injection.  
  public static final UrlShortenerController INSTANCE = new UrlShortenerController();
  
  private UrlShortenerController(){

    this.urlShortenerDAO = new UrlShortenerDAOImpl();    
    this.keyGeneratorDAO = new KeyGeneratorDAOImpl(urlShortenerDAO);    
    this.domain = DOMAIN;
  }
  
  private String getKey(String longURL)
  {
    String key;
    key = keyGeneratorDAO.generateKey();
    urlShortenerDAO.addKeyLongUrlMapping(key, longURL);
    urlShortenerDAO.addLongUrlKeyMapping(longURL, key);   
    return key;
  }
  
  public String getShortUrl(String longURL, String slug)
  {
    if(!UrlValidator.validateURL(longURL)){
      return null;
    }
    if(slug != null){
      urlShortenerDAO.addKeyLongUrlMapping(slug, longURL);
      urlShortenerDAO.addLongUrlKeyMapping(longURL, slug);
      return domain + "/" + slug;
    }
    if (urlShortenerDAO.isExistingLongUrl(longURL))
    {
      return domain + "/" + urlShortenerDAO.getKey(longURL);
    }
    return domain + "/" + getKey(longURL);
  }
  
  public URI getLongUrl(String key) {
    String longUrl = urlShortenerDAO.getLongUrl(key);
    URI redirectUrl = null;
    try
    {
      redirectUrl = UrlHelper.getRedirectUrl(longUrl);
    }
    catch (URISyntaxException e){
      System.out.println("Invalid redirect url" + e);
    }
    return redirectUrl;
  }

}
