package com.goldbely.dao;

import java.util.Random;

public class KeyGeneratorDAOImpl implements KeyGeneratorDAO
{
  private UrlShortenerDAO urlShortenerDAO;
  private char myChars[];
  private Random myRand;
  private int keyLength;
  
  public KeyGeneratorDAOImpl(UrlShortenerDAO urlShortenerDAO)
  {
    this.urlShortenerDAO = urlShortenerDAO;    
    this.myRand = new Random();
    this.keyLength = 8;
    
    this.myChars = new char[62];
    for (int i = 0; i < 62; i++)
    {
      int j = 0;
      if (i < 10)
      {
        j = i + 48;
      }
      else if (i > 9 && i <= 35)
      {
        j = i + 55;
      }
      else
      {
        j = i + 61;
      }
      myChars[i] = (char) j;
    }
  }
  
  public String generateKey()
  {
    String key = "";
    boolean flag = true;
    while (flag)
    {
      key = "";
      for (int i = 0; i <= keyLength; i++)
      {
        key += myChars[myRand.nextInt(62)];
      }
      if (!urlShortenerDAO.isExistingKey(key))
      {
        flag = false;
      }
    }
    System.out.println("Key generated :- " + key);
    return key;
  }

}
