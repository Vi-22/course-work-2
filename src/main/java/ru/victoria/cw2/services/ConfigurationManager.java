package ru.victoria.cw2.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import ru.victoria.cw2.scenario.Paragraph;

import java.io.*;
import java.util.*;

public class ConfigurationManager {
    private final static String PROP_PATH_NAME = "src/main/resources/application.properties";
    public static String getProperty(String propertyKey) {
        File propertiesFile = new File(PROP_PATH_NAME);
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(propertiesFile);
            properties.load(fileInputStream);
            fileInputStream.close();
            return properties.getProperty(propertyKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Paragraph> getScenarioConfiguration() {
        try {
            File configFile = new File(getProperty("SC_CONFIG_URL"));
            ObjectMapper objectMapper = new YAMLMapper();
            List<Paragraph> paragraphList = Arrays.asList(objectMapper.readValue(configFile, Paragraph[].class));
            return paragraphList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
