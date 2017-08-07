package com.leeeee.dwgreetings;

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
    }

}
