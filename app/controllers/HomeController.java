package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Metrics;
import play.libs.Json;
import play.mvc.*;

import play.routing.JavaScriptReverseRouter;
import services.SystemMetrics;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    public Result javascriptRoutes() {
        return ok(
                JavaScriptReverseRouter.create("jsRoutes",
                        routes.javascript.HomeController.metrics()
                )
        ).as("text/javascript");
    }

    public Result index() {

        return ok(index.render("ok"));
    }

    public Result metrics(){
        SystemMetrics system = new SystemMetrics();
        long usableSpace = system.getDiskFreeSpace();
        long totalSpace = system.getDiskTotalSpace();
        long freeMem = system.getMemFreeSpace();
        long usedMem = system.getMemUsedSpace();
        double freeMemPercent = system.getFreeMemPercent();
        double  usedMemPercent = system.getUsedMemPercent();
        Metrics metrics = new Metrics(usableSpace, totalSpace, freeMem, usedMem, freeMemPercent, usedMemPercent);
        JsonNode metricsJson = Json.toJson(metrics);

        return ok(metricsJson);
    }

}
