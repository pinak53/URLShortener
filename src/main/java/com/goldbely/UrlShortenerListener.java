package com.goldbely;

//import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//import com.goldbely.controllers.UrlShortenerController;

public class UrlShortenerListener implements ServletContextListener {


  public void contextDestroyed(ServletContextEvent arg0){
    System.out.println("Stopping Listener....");
//    ServletContext context = arg0.getServletContext();
//    context.removeAttribute("controller");
  }

  public void contextInitialized(ServletContextEvent arg0){
    System.out.println("Started Listener....");
//    UrlShortenerController urlShortenerController = new UrlShortenerController();
//    ServletContext context = arg0.getServletContext();
//    context.setAttribute("controller", urlShortenerController);
  }

}