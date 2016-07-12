package org.nazymko.mailer;

import com.google.gson.Gson;
import org.nazymko.GmailService;
import org.nazymko.UserImpl;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "mailer" path)
 */
@Path("mailer")
public class Mailer {
    private Session session = GmailService.getInstance().session(new UserImpl("", ""));

    @GET
    @Path("test")
    public String test() {
        return "success";
    }

    @POST
    @Path("/send")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String send(Message body) throws MessagingException {

        GmailService.getInstance().send(body, session);

        return "{\"message\":\"ok\"}";
    }


    @GET
    @Path("/example")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message example() throws MessagingException {

        Message message = new Message();
        message.setBcc(new String[]{"Bcc1", "bcc2"});
        message.setCc(new String[]{"Bcc1", "bcc2"});
        message.setTo(new String[]{"Bcc1", "bcc2"});
        message.setFrom("from");

        return message;
    }
}
