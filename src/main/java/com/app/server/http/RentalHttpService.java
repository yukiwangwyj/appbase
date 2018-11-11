package com.app.server.http;

import com.app.server.http.utils.APPResponse;
import com.app.server.http.utils.PATCH;
//import com.app.server.models.Rental;
import com.app.server.services.RentalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("renters/{renterId}/rentals")
public class RentalHttpService {

    private RentalService service;
    private ObjectWriter ow;

    public RentalHttpService() {
        service = RentalService.getInstance();
        ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    }


    @OPTIONS
    @PermitAll
    public Response optionsById() {
        return Response.ok().build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public APPResponse getAll(@PathParam("renterId") String renterId) {

        return new APPResponse(service.getAllRentalsOf(renterId));
    }

    @GET
    @Path("renters")
    @Produces({MediaType.APPLICATION_JSON})
    public APPResponse getAllSent(@PathParam("renterId") String renterId) {

        return new APPResponse(service.getAllRentalsOfRenter(renterId));
    }

    @GET
    @Path("owners")
    @Produces({MediaType.APPLICATION_JSON})
    public APPResponse getAllReceived(@PathParam("ownerId") String ownerId) {

        return new APPResponse(service.getAllRentalsOfOwner(ownerId));
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public APPResponse create(Object request) {
        return new APPResponse(service.create(request));
    }

    @PATCH
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public APPResponse update(@PathParam("id") String id, Object request) {

        return new APPResponse(service.update(id, request));

    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public APPResponse delete(@PathParam("id") String id) {

        return new APPResponse(service.delete(id));
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public APPResponse delete() {

        return new APPResponse(service.deleteAll());
    }

}