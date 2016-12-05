package fr.quintipio.fr.quintipio.modelArchiAngularJs;

/**
 * Created by Quentin on 05/12/2016.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ModeleArchiAngularJsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(ModeleArchiAngularJsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ModeleArchiAngularJsApplication.class);
    }
}
