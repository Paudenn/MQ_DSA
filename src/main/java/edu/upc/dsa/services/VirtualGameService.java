package edu.upc.dsa.services;


import edu.upc.dsa.VirtualGameManager;
import edu.upc.dsa.VirtualGameManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/VirtualGame", description = "Endpoint to Track Service")
@Path("/VirtualGame")
public class VirtualGameService {

    private VirtualGameManager scenario;

    public VirtualGameService() {

        scenario = VirtualGameManagerImpl.getInstance();
        scenario.addPlace("Tokio");
        scenario.addPlace("Paris");
        scenario.addPlace("Roma");
        scenario.addPlace("Stambul");
        scenario.addUser("Pau", "321");
        scenario.addUser("Laura", "123");
        scenario.addUser("Alba", "213");

        /*PassPlace placeSeen = new PassPlace(scenario.getUser("Pau"));

        placeSeen.addP(new Place("Tokio", "Pau"));
        scenario.placeSeenByUser(placeSeen);

         */
    }


    @POST
    @ApiOperation(value = "Add a new place", notes = "Add a new place")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Place.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/addPlace")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPlace(Place place) {

        if (place.getPlaceName() == null) return Response.status(500).entity(place).build();
        this.scenario.addPlace(place.getPlaceName());
        return Response.status(201).entity(place).build();

    }

    @POST
    @ApiOperation(value = "Create a new Order", notes = "Create a new Order")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = PassPlace.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/PassPlaceByAUser/")
    @Consumes(MediaType.APPLICATION_JSON)

    public Response placeSeenByUser(PassPlace passPlace) {

        if (passPlace.getUserName() == null || passPlace.getPlaceList() == null)
            return Response.status(500).entity(passPlace).build(); // solo funciona con usuarios ya establecido mas arriba!!
        this.scenario.placeSeenByUser(passPlace);
        return Response.status(201).entity(passPlace).build();
    }

    @GET
    @ApiOperation(value = "Get users sort by name", notes = "Get")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Products not found")
    })
    @Path("/UsersByName/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersByName() {
        List<User> users = scenario.getUsersByID();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(users) {
        };
        if (users.size() == 0) return Response.status(404).build();
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Get Places by users that seen it", notes = "Get")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Products not found")
    })
    @Path("/usersThatSeenThisPlace/{placeName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response usersThatSeenThisPlace(@PathParam("placName")String placeName) {
        List<User> list = scenario.usersThatSeenThisPlace(placeName);
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(list) {
        };
        if (list.size() == 0) return Response.status(404).build();
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Get all places seen by user", notes = "Get")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Place.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Products not found")
    })

    @Path("/allPlacesSeenByUser/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPlacesSeenByUser(@PathParam("user") String user) {
        List<Place> list = scenario.allPlacesSeenByUser(user);
        if (list.size() == 0) return Response.status(404).build();

        GenericEntity<List<Place>> entity = new GenericEntity<List<Place>>(list) {
        };
        return Response.status(201).entity(entity).build();


    }
}


/*
    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })

    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteTrack(id);
        return Response.status(201).build();
    }



    @PUT
    @ApiOperation(value = "New order", notes = "New order")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Track track) {

        Track t = this.tm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }

 */






