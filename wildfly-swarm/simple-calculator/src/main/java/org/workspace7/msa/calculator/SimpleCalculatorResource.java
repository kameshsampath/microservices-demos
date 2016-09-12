package org.workspace7.msa.calculator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.workspace7.msa.calculator.CalculatorService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author kameshs
 */
@Path("/calculator")
@Api(value = "/calculator",description = "Simple Calculator",tags = "calculator")
@Produces(MediaType.TEXT_PLAIN)
public class SimpleCalculatorResource {

    @Inject
    CalculatorService calculatorService;

    @GET
    @Produces("text/plain")
    @Path("/whoami")
    @ApiOperation("Says whoami ")
    public String whoami() {
        String hostname = System.getenv().getOrDefault("HOSTNAME", "Unknown");
        return String.format("Hare Krishna! from %s", hostname);
    }

    @GET
    @Produces("text/plain")
    @Path("/add/{num1}/{num2}")
    @ApiOperation("Adds two numbers passed as path parameters")
    public String add(@PathParam("num1") Integer num1, @PathParam("num2") Integer num2) {
        return String.format("%d + %d = %d", num1, num2, calculatorService.calculate("+",num1,num2));
    }

    @GET
    @Produces("text/plain")
    @Path("/sub/{num1}/{num2}")
    @ApiOperation("Subtracts two numbers passed as path parameters")
    public String sub(@PathParam("num1") Integer num1, @PathParam("num2") Integer num2) {
        return String.format("%d - %d = %d", num1, num2, calculatorService.calculate("-",num1,num2));
    }

    @GET
    @Produces("text/plain")
    @Path("/mul/{num1}/{num2}")
    @ApiOperation("Multiplies two numbers passed as path parameters")
    public String mul(@PathParam("num1") Integer num1, @PathParam("num2") Integer num2) {
        return String.format("%d x %d = %d", num1, num2, calculatorService.calculate("*",num1,num2));
    }

    @GET
    @Produces("text/plain")
    @Path("/div/{num1}/{num2}")
    @ApiOperation("Divides two numbers passed as path parameters")
    public String div(@PathParam("num1") Integer num1, @PathParam("num2") Integer num2) {
        return String.format("%d / %d = %d", num1, num2, calculatorService.calculate("/",num1,num2));
    }
}
