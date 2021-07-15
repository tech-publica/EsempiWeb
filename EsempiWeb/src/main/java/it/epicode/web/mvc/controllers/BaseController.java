package it.epicode.web.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
      public Destination showErrorPageForMissingUrl(HttpServletRequest request, HttpServletResponse response) {
    	  return new Destination("missingUrl.jsp", false);
      }
}
