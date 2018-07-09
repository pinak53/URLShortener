package com.goldbely.rest;

import java.net.URI;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.goldbely.controllers.UrlShortenerController;
import com.goldbely.util.JsonHelper;

  
@Path("/")
public class UrlShortenerService {
     
    @Context
    private ServletContext context;
    
    @POST
    @Path("/shorten")
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response shortenUrl(String jsonData)
    {  
      String longUrl = JsonHelper.getLongUrl(jsonData);
      String slug = JsonHelper.getSlug(jsonData);
      
      System.out.println("Generating short url for :- " + longUrl);
      String shortUrl = UrlShortenerController.INSTANCE.getShortUrl(longUrl, slug);     
      if(shortUrl == null){
        return Response.status(400).entity("URL Invalid..").build();    
      } 
      String response = JsonHelper.buildShortenUrlResponse(shortUrl, longUrl);
      System.out.println("Successfully generated short url :- " + response);
      return Response.status(200).entity(response).build();
    }
       
    @GET
    @Path("/{key}")
    public Response expandUrl(@PathParam("key") String key) {
      System.out.println("Generating long url for key :- " + key); 
      URI longUrl = UrlShortenerController.INSTANCE.getLongUrl(key);
      if(longUrl == null){
        return Response.status(404).entity("Long URL for this Key doesn't exist..").build();
      }       
      System.out.println("Successfully generated long url :- " + longUrl);     
      return Response.temporaryRedirect(longUrl).status(302).build();
    }
    
}

