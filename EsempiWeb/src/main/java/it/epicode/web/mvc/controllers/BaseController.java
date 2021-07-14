package it.epicode.web.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
      public String showErrorPageForMissingUrl(HttpServletRequest request, HttpServletResponse response) {
    	  return "missingUrl.jsp";
      }
}
