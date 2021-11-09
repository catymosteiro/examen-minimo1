package edu.upc.dsa.services;


import edu.upc.dsa.UsuariosManager;
import edu.upc.dsa.UsuariosManagerImpl;
import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/tracks", description = "Endpoint to Track Service")
@Path("/tracks")
public class TracksService {

    private UsuariosManager cm;

    public TracksService() {
        this.cm = UsuariosManagerImpl.getInstance();
        if (!this.cm.isDirty()) {

            PuntoInteres p1 = new PuntoInteres("CasillaX");
            PuntoInteres p2 = new PuntoInteres("Puerta");
            PuntoInteres p3 = new PuntoInteres("Puente");

            Usuario u1= new Usuario("Juan");
            Usuario u2= new Usuario("Maria");

            cm.añadirUsuario(u1,p2);
            cm.añadirUsuario(u1,p3);
            cm.añadirUsuario(u2,p1);

            cm.dirty();
        }

    }

    @GET
    @ApiOperation(value = "Listado de usuarios por orden alf.", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
    })
    @Path("/listAlf")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAlf() {

        List<Usuario> listUsuarios = this.cm.ListaUsuariosAlf();

        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(listUsuarios) {};
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Listado de usuarios por orden desc.", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
    })
    @Path("/listDesc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listVac() {

        List<Usuario> listUsuarios = this.cm.ListaUsuariosDesc();

        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(listUsuarios) {};
        return Response.status(201).entity(entity).build();
    }


    @GET
    @ApiOperation(value = "Listado de usuarios por orden desc.", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
    })
    @Path("/listDesc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPuntos() {

        List<PuntoInteres> listPuntos = this.cm.ListaPuntoInteres();

        GenericEntity<List<PuntoInteres>> entity = new GenericEntity<List<PuntoInteres>>(listPuntos) {};
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Listado de usuarios  que pasan por punto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/listPunto/{p}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getlistPuntos (@PathParam("p") String id) {
        List<Usuario> listUsuarios = cm.ListaUsuariosPunto("p");

        if (listUsuarios.size()==0) return Response.status(404).build();
        else {
            GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(listUsuarios) {};
            return Response.status(201).entity(entity).build();
        }
    }

    @POST
    @ApiOperation(value = "Añadir usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response nuevaUsuario(Usuario u, PuntoInteres s) {
        if (u.getName()==null)  return Response.status(500).entity(u).build();
        this.cm.añadirUsuario(u,s);
        return Response.status(201).build();
    }

}