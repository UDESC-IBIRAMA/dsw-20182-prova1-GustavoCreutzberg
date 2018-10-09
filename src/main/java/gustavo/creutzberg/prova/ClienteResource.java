/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gustavo.creutzberg.prova;

import gustavo.creutzberg.dao.ClienteDAO;
import static gustavo.creutzberg.dao.ClienteDAO.listar;
import gustavo.creutzberg.modules.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Gustavo
 */
@Path("Cliente")
public class ClienteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClienteResource
     */
    public ClienteResource() {
    }

    /**
     * Retrieves representation of an instance of gustavo.creutzberg.prova.ClienteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getJson(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes = ClienteDAO.listar();
        return clientes;
    }

    /**
     * PUT method for updating or creating an instance of ClienteResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente putJson(Cliente cli, String desc) {
        ClienteDAO d = new ClienteDAO();
        Cliente c = new Cliente();
        d.lerClienteId(cli.getId());
        c = cli;
        c.setNome(desc);
        return c;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente postJson(Cliente cli) {
        
        Cliente c = new Cliente();
        c = cli;
        return c;
    }
}
