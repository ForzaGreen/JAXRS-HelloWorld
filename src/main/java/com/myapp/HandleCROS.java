package com.myapp;

import javax.ws.rs.core.Response;

public class HandleCROS {

    private String _corsHeaders;
    
    public HandleCROS(String c){
        _corsHeaders = c;        
    }

    public Response makeCORS(Response.ResponseBuilder req, String returnMethod) {
         Response.ResponseBuilder rb = req.header("Access-Control-Allow-Origin", "*");
             rb.header("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE");
         
         rb.header("Access-Control-Allow-Headers", "origin, content-type, accept, Authorization");
         rb.header("Access-Control-Allow-Credentials", "true");
         rb.header("Access-Control-Allow-Origin", "*");
        if (!"".equals(returnMethod)) {
           rb.header("Access-Control-Allow-Headers", returnMethod);
        }

     return rb.build();
    }

    public Response makeCORS(Response.ResponseBuilder req) {
       return makeCORS(req, _corsHeaders);
    }
    
}
