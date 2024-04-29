package utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("src/main/resources/config.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBrowserName(){
        String prop = properties.getProperty("Browser");
        if(prop != null) return prop;
        else throw new RuntimeException("Failed to load property for browser name");
    }

    public String getEmailId(){
        String prop = properties.getProperty("EmailId");
        if(prop != null) return prop;
        else throw new RuntimeException("Failed to load property for user name");
    }

    public String getPassword(){
        String prop = properties.getProperty("Password");
        if(prop != null) return prop;
        else throw new RuntimeException("Failed to load property for password");
    }

    public String getUrl(){
        String prop = properties.getProperty("Url");
        if(prop != null) return prop;
        else throw new RuntimeException("Failed to load property for Url");
    }

    public String getUserName(){
        String prop = properties.getProperty("UserName");
        if(prop != null) return prop;
        else throw new RuntimeException("Failed to load property for Username");
    }

    public String getDesignation(){
        String prop = properties.getProperty("UserDesignation");
        if(prop != null) return prop;
        else throw new RuntimeException("Failed to load property for User Designation");
    }


}
