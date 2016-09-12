package org.workspace7.msa.calculator;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.logging.LoggingFraction;
import org.wildfly.swarm.swagger.SwaggerArchive;

/**
 * @author kameshs
 */
public class SimpleCalculatorApplication {
    public static void main(String[] args) {
        try {
            Swarm swarm  = new Swarm(args);
            SwaggerArchive archive = ShrinkWrap.create(SwaggerArchive.class,"swagger-app.war");
            JAXRSArchive deployment = archive.as(JAXRSArchive.class)
                    .addPackage(SimpleCalculatorApplication.class.getPackage());
            deployment.addAllDependencies();
            archive.setResourcePackages("org.workspace7.msa.calculator");
            swarm
                    .fraction(LoggingFraction.createDebugLoggingFraction())
                    .start()
                    .deploy(deployment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
