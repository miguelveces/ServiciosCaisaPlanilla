/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caisa.planilla.entity.services;

import com.caisa.planilla.entity.Contrato;
import com.caisa.planilla.entity.PagosRegulares;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author NCN00973
 */
@Stateless
@Path("/pagosregulares")
public class PagosRegularesFacadeREST extends AbstractFacade<PagosRegulares> {
    @PersistenceContext(unitName = "ServiciosCaisaPlanillaPU")
    private EntityManager em;

    public PagosRegularesFacadeREST() {
        super(PagosRegulares.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(PagosRegulares entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(PagosRegulares entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public PagosRegulares find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<PagosRegulares> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<PagosRegulares> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
          //metodo de busqueda por numero de empleado
    
    @GET
    @Path("/idEmpleado/{idEmpleado}")
    @Consumes({"application/json"})
    @Produces({"application/xml", "application/json"})
    public List<PagosRegulares> findPagosRegulares(@PathParam("idEmpleado") int idEmpleado)
    {
         
       return super.find1Paramater("PagosRegulares.findByIdEmpleado", "idEmpleado", idEmpleado);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
