package com.goldbely.util;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

public class UrlHelperTest
{

  @Test
  public void testRedirectUrlWithHttp() throws URISyntaxException{
    URI output = new URI("http://www.google.com");
    assertEquals(output, UrlHelper.getRedirectUrl("http://www.google.com"));
  }
  
  @Test
  public void testRedirectUrlWithoutHttp() throws URISyntaxException{
    URI output = new URI("http://www.google.com");
    assertEquals(output, UrlHelper.getRedirectUrl("www.google.com"));
  }
  
  @Test
  public void testEmptyLongUrl() throws URISyntaxException{
    assertEquals(null, UrlHelper.getRedirectUrl(""));
  }
  
  @Test
  public void testNullLongUrl() throws URISyntaxException{
    assertEquals(null, UrlHelper.getRedirectUrl(null));
  }
  
}
