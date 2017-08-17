package com.leeeee.dwgreetings.resources;

import com.codahale.metrics.annotation.Timed;
import com.leeeee.dwgreetings.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/Greeting")
@Produces(MediaType.APPLICATION_JSON)
public class DWGreetingsResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public DWGreetingsResource(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name){
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(),value);
    }
}
