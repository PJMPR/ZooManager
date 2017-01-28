package rest;

/**
 * Created by TKK on 2017-01-28.
 */
import dao.model.Zwierze;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import rest.dto.ZwierzeDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

    @Path("zwierze")
    @Stateless
    public class ZwierzeResources {

        Mapper mapper = new DozerBeanMapper();

        @PersistenceContext
        EntityManager entityManager;

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response getAll(){

            List<ZwierzeDto> result = new ArrayList<ZwierzeDto>();

            for(Zwierze p: entityManager.createNamedQuery("zwierze.all",Zwierze.class).getResultList()){

                result.add(mapper.map(p, ZwierzeDto.class));

            }
            return Response.ok(new GenericEntity<List<ZwierzeDto>>(result){}).build();
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response Add(Zwierze zwierze) {

            entityManager.persist(zwierze);

            return Response.ok(zwierze.getId()).build();

        }

        @PUT
        @Path("/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response update(@PathParam("id") int id, Zwierze p) {

            Zwierze result = entityManager.createNamedQuery("Zwierze.id", Zwierze.class)
                    .setParameter("id", id)
                    .getSingleResult();

            if (result == null) {

                return Response.status(404).build();

            }

            p.setNazwa(p.getNazwa());

            p.setTempoJedzenia(p.getTempoJedzenia());

            p.setPoziomNajedzenia(p.getPoziomNajedzenia());

            entityManager.persist(result);

            return Response.ok().build();

        }



        @GET

        @Path("/{id}")

        @Produces(MediaType.APPLICATION_JSON)

        public Response get(@PathParam("id") int id) {

            Zwierze result = entityManager.createNamedQuery("Zwierze.id", Zwierze.class)

                    .setParameter("id", id)

                    .getSingleResult();

            if (result == null) {

                return Response.status(404).build();

            }

            return Response.ok(result).build();

        }



        @DELETE

        @Path("/{id}")

        public Response delete(@PathParam("id") int id) {

            Zwierze result = entityManager.createNamedQuery("Zwierze.id", Zwierze.class)

                    .setParameter("id", id)

                    .getSingleResult();

            if (result == null)

                return Response.status(404).build();

            entityManager.remove(result);

            return Response.ok().build();

        }

    }
