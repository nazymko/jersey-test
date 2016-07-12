package org.nazymko.mailer;

import org.nazymko.mailer.test.Pojo;

import javax.ws.rs.*;

/**
 * Created by Andrew Nazymko
 */
@Path("/tests")
public class Testing {
    @POST
    @Path("object")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Pojo testJson(Pojo pojo) {
        return pojo;
    }

    @POST
    @Path("string")
    public String testObject(String pojo) {
        return pojo;
    }

    @GET
    @Path("ok")
    public String testOk() {
        return "ok";
    }
}
