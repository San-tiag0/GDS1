package servicedrawyourroute.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import control.Controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Coordinate;
import model.Draw;
import model.Route;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import request.LoginRequest;

@Path("userResource")
public class UserResource {

    private Controller controller;
    private Gson converterJavaToJson;

    public UserResource() {
        GsonBuilder b = new GsonBuilder();
        controller = new Controller();
        converterJavaToJson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    }

    @GET
    @Path("user/{nickName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuariosByNickName(@PathParam("nickName") String nickName) {
        User user = controller.getUserByNickName(nickName);
        String json = converterJavaToJson.toJson(user);
        return Response.ok(json).build();
    }

    @GET
    @Path("friends/{nickName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFriendsByNickName(@PathParam("nickName") String nickName) {
        Set<User> friends = controller.getFriendsByNickName(nickName);
        String json = converterJavaToJson.toJson(friends);
        return Response.ok(json).build();
    }

    @POST
    @Path("loggedUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loggedUser(HashMap<String, Object> request) {
        String nickName = (String) request.get("nickName");
        String password = (String) request.get("password");
        User loggedUser = controller.login(nickName, password);
        loggedUser.setPassword("");
        String json = converterJavaToJson.toJson(loggedUser);
        return Response.ok(json).build();
    }

    @POST
    @Path("addUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(HashMap<String, Object> request) {
        String name = (String) request.get("name");
        String lastName = (String) request.get("lastName");
        String nickName = (String) request.get("nickName");
        String password = (String) request.get("password");
        String email = (String) request.get("email");
        try {
            controller.addUser(new User(name, lastName, nickName, password, email));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.noContent().build();
        }
    }

    @POST
    @Path("addFriend")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFriend(HashMap<String, Object> request) {
        String nickNameLoggedUser = (String) request.get("nickNameLoggedUser");
        String nickNameFriend = (String) request.get("nickNameFriend");
        User loggedUser = controller.getUserByNickName(nickNameLoggedUser);
        User friendUser = controller.getUserByNickName(nickNameFriend);
        try {
            controller.addFriend(loggedUser, friendUser);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.noContent().build();
        }
    }

    @POST
    @Path("addRoute")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRoute(HashMap<String, Object> request) {
        JSONObject jsnobject = new JSONObject(request);      
        String nameRoute = (String) jsnobject.getString("name");
        String dateRoute = (String) jsnobject.getString("date");
        String nickNameLoggedUser = (String) jsnobject.getString("nickNameLoggedUser");
        BigDecimal idDraw = (BigDecimal) jsnobject.getBigDecimal("idDraw");
        JSONArray jsonArray = jsnobject.getJSONArray("coordinates");   
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject objectJSON = jsonArray.getJSONObject(i);
            coordinates.add(new Coordinate(objectJSON.getDouble("lat"), objectJSON.getDouble("lng")));
        }
        try {
            controller.addRoute(nameRoute, dateRoute, nickNameLoggedUser, coordinates, idDraw.intValue());
            return Response.ok().build();
        } catch (Exception e) {
            return Response.noContent().build();
        }
    }
    
    @POST
    @Path("addDraw")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDraw(HashMap<String, Object> request) {
        JSONObject jsnobject = new JSONObject(request);      
        String nameRoute = (String) jsnobject.getString("name");
        String dateRoute = (String) jsnobject.getString("date");
        String nickNameLoggedUser = (String) jsnobject.getString("nickNameLoggedUser");
        JSONArray jsonArray = jsnobject.getJSONArray("coordinates");   
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject objectJSON = jsonArray.getJSONObject(i);
            coordinates.add(new Coordinate(objectJSON.getDouble("lat"), objectJSON.getDouble("lng")));
        }
        try {
            controller.addDraw(nameRoute, dateRoute, nickNameLoggedUser, coordinates);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.noContent().build();
        }
    }
    
    @GET
    @Path("draw/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrawById(@PathParam("id") int id) {
        Draw draw = controller.getDrawById(id);
        String json = converterJavaToJson.toJson(draw);
        return Response.ok(draw).build();
    }

}