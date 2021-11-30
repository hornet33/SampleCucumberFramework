package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.*;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/config.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitWaitTime");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitWaitTime not specified in the config.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("baseURL");
        if (url != null) return url;
        else throw new RuntimeException("baseURL not specified in the config.properties file.");
    }

    public EnvType getEnvironment() {
        String env = properties.getProperty("environment");
        if (env == null) return EnvType.LOCAL; //default environment
        env = env.toLowerCase();
        switch (env) {
            case "local":
                return EnvType.LOCAL;
            case "remote":
                return EnvType.REMOTE;
            default:
                throw new RuntimeException("Incorrect environment specified in config.properties file.");
        }
    }

    public DriverType getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser == null) return DriverType.CHROME; //default browser
        browser = browser.toLowerCase();
        switch (browser) {
            case "chrome":
                return DriverType.CHROME;
            case "firefox":
                return DriverType.FIREFOX;
            case "edge":
                return DriverType.EDGE;
            default:
                throw new RuntimeException("Incorrect browser specified in config.properties file.");
        }
    }

    public Boolean getWindowMaximizeSetting() {
        String windowMaximize = properties.getProperty("windowMaximize");
        if (windowMaximize != null) return Boolean.valueOf(windowMaximize);
        else throw new RuntimeException("windowMaximize not specified in the config.properties file.");
    }
}