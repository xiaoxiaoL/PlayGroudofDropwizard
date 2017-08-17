package com.leeeee.dwgreetings;

import com.leeeee.dwgreetings.health.TemplateHealthCheck;
import com.leeeee.dwgreetings.resources.DWGreetingsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DWGreetingsApplication extends Application<DWGreetingsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DWGreetingsApplication().run(args);
    }

    @Override
    public String getName() {
        return "DWGreetings";
    }

    @Override
    public void initialize(final Bootstrap<DWGreetingsConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DWGreetingsConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        final DWGreetingsResource resource = new DWGreetingsResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
