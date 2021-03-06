/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caisa.planilla.entity.services;

import com.caisa.planilla.entity.HorasTrabajadas;
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
@Path("/horastrabajadas")
public class HorasTrabajadasFacadeREST extends AbstractFacade<HorasTrabajadas> {
    @PersistenceContext(unitName = "ServiciosCaisaPlanillaPU")
    private EntityManager em;

    public HorasTrabajadasFacadeREST() {
        super(HorasTrabajadas.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(HorasTrabajadas entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(HorasTrabajadas entity) {
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
    public HorasTrabajadas find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<HorasTrabajadas> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<HorasTrabajadas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("/idEmpleadoNumero/{idEmpleadoNumero}")
    @Consumes({"application/json"})
    @Produces({"application/xml", "application/json"})
    public List<HorasTrabajadas> findHorasTrabajadas(@PathParam("idEmpleadoNumero") int idEmpleadoNumero)
    {
         
       return super.find1Paramater("HorasTrabajadas.findByIdEmpleadoNumero", "idEmpleadoNumero", idEmpleadoNumero);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
