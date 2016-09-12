package org.workspace7.msa.calculator;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;

/**
 * @author kameshs
 */
@RestController
@RequestMapping("/api")
public class SimpleCalculatorController {

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/whoami", produces = "text/plain")
    @ApiOperation("Says whoami ")
    public String whoami() {
        String hostname = System.getenv().getOrDefault("HOSTNAME", "Unknown");
        return String.format("Hare Krishna! from %s", hostname);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/add/{num1}/{num2}", produces = "text/plain")
    @ApiOperation("Adds two numbers passed as path parameters")
    public String add(@PathVariable("num1") Integer num1, @PathVariable("num2") Integer num2) {
        return String.format("%d + %d = %d", num1, num2, (num1 + num2));
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/sub/{num1}/{num2}", produces = "text/plain")
    @ApiOperation("Subtracts two numbers passed as path parameters")
    public String sub(@PathVariable("num1") Integer num1, @PathVariable("num2") Integer num2) {
        return String.format("%d - %d = %d", num1, num2, (num1 - num2));
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/mul/{num1}/{num2}", produces = "text/plain")
    @ApiOperation("Multiplies two numbers passed as path parameters")
    public String mul(@PathVariable("num1") Integer num1, @PathVariable("num2") Integer num2) {
        return String.format("%d x %d = %d", num1, num2, (num1 * num2));
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/div/{num1}/{num2}", produces = "text/plain")
    @ApiOperation("Divides two numbers passed as path parameters")
    public String div(@PathVariable("num1") Integer num1, @PathVariable("num2") Integer num2) {
        return String.format("%d / %d = %d", num1, num2, (num1 / num2));
    }
}
