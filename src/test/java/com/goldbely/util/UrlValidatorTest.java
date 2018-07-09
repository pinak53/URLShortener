package com.goldbely.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UrlValidatorTest
{
  
  @Test
  public void testValidUrl(){
    assertTrue(UrlValidator.validateURL("http://www.google.com"));
  }
  
  @Test
  public void testInValidUrl(){
    assertFalse(UrlValidator.validateURL("1234"));
  }
  
  @Test
  public void testEmptyUrl(){
    assertFalse(UrlValidator.validateURL(""));
  }
  
  @Test
  public void testNullUrl(){
    assertFalse(UrlValidator.validateURL(null));
  }
  
}
