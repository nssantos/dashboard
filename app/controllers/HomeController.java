package controllers;

import play.mvc.*;

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
    public Result index() {
        SystemMetrics system = new SystemMetrics();
        String usableSpace = system.getDiskFreeSpace();
        String totalSpace = system.getDiskTotalSpace();
        long freeMem = system.getMemFreeSpace();
        long usedMem = system.getMemUsedSpace();
        double freeMemPercent = system.getFreeMemPercent();
        double  usedMemPercent = system.getUsedMemPercent();
        return ok(index.render("ok", usableSpace, totalSpace, freeMemPercent, usedMemPercent));
    }

}
