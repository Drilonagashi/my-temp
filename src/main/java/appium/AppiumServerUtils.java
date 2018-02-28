package appium;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumServerUtils {
    private static final String HOST_ADDRESS = "http://0.0.0.0";
    private static final int PORT = 4724;
    private static final String SERVER_URL = String.format(HOST_ADDRESS + ":%d/wd/hub", PORT);

    private static DriverService appiumServerHandling() throws IOException {
        DriverService service = new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/bin/appium"))
                .withIPAddress(HOST_ADDRESS.split("//")[1])
                .usingPort(PORT).build();
        return service;
    }

    public static void startAppiumServer() throws IOException {
        System.out.println("Starting Appium Server..");
        appiumServerHandling().start();
    }

    public static void stopAppiumServer() throws IOException {
        System.out.println("Stopping Appium Server..");
        appiumServerHandling().stop();
    }

    public static boolean isAppiumServerRunning() throws Exception {
        final URL status = new URL(SERVER_URL + "/sessions");
        long timeout = 10;
        try {
            new UrlChecker().waitUntilAvailable(timeout, TimeUnit.SECONDS, status);
            return true;
        } catch (UrlChecker.TimeoutException e) {
            return false;
        }
    }
}