package fi.fubar.bibtex;

import org.junit.rules.ExternalResource;
import org.springframework.context.ConfigurableApplicationContext;


class ServerRule extends ExternalResource{

    private final int port;
    ConfigurableApplicationContext app;

    public ServerRule(int port) {
        this.port = port;
    }

    @Override
    protected void before() throws Throwable {
        //this.app = SpringApplication.run(Main.class);
    }

    @Override
    protected void after() {
        app.close();
    }
}
