package com.myapp;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.*;

@Path("/helloWorldREST")
@Api(value = "/helloWorldREST", description = "pr accéder à helloWorldREST")
public class HelloWorldREST {
    
    @OPTIONS
    @Path("/{req}")
    public Response corsMaRessourceReq(@HeaderParam("Access-Control-Request-Headers") String requestH) {
        HandleCROS h = new HandleCROS(requestH);
        return h.makeCORS(Response.ok(), requestH);
   }

	@GET
	@Path("/{parameter}")
	@ApiOperation(value = "Trouver un param", notes = "More notes about this method")
	@ApiResponses(value = {
	  @ApiResponse(code = 400, message = "Invalid ID supplied"),
	  @ApiResponse(code = 404, message = "qqch not found") 
	})
	public Response responseMsg( @PathParam("parameter") String parameter,
			@DefaultValue("Nothing to say") @QueryParam("value") String value) {
		String output = "ca va ? Hello from: " + parameter + " : " + value;
		return Response.status(200).entity(output).build();
	}
	
	@POST
	public Response respPost() {
		String output = "";
		return Response.status(200).entity(output).build();
	}
	
	
}