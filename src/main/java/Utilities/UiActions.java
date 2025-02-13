package Utilities;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UiActions {
    private static final String OBJECT_REPO_PATH = "resources/ObjectRepositories";

    private JSONObject loadJson(String fileName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(OBJECT_REPO_PATH + fileName + ".json")));
            return new JSONObject(content);
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to load JSON file: " + fileName, e);
        }
    }

    public WebElement getElement(String fileName, String elementName) {
        JSONObject jsonObject = loadJson(fileName);
        if (jsonObject.has(elementName)) {
            JSONObject elementDetails = jsonObject.getJSONObject(elementName);
            String locatorType = elementDetails.getString("locatorType");
            String locatorValue = elementDetails.getString("locatorValue");
            return DriverFactory.getInstance().getDriver().findElement(getLocator(locatorType, locatorValue));
        }
        throw new RuntimeException("❌ Element not found: " + elementName);
    }

    public List<WebElement> getElements(String jsonFile, String elementName) {
        JSONObject jsonObject = loadJson(jsonFile);

        if (jsonObject.has(elementName)) {
            JSONObject elementDetails = jsonObject.getJSONObject(elementName);
            String locatorType = elementDetails.getString("locatorType");
            String locatorValue = elementDetails.getString("locatorValue");

            return DriverFactory.getInstance().getDriver().findElements(getLocator(locatorType, locatorValue));
        }
        throw new RuntimeException("❌ Elements not found: " + elementName);
    }

    private By getLocator(String locatorType, String locatorValue) {
        return switch (locatorType.toLowerCase()) {
            case "css" -> By.cssSelector(locatorValue);
            case "xpath" -> By.xpath(locatorValue);
            case "id" -> By.id(locatorValue);
            case "name" -> By.name(locatorValue);
            case "classname" -> By.className(locatorValue);
            default -> throw new IllegalArgumentException("❌ Unsupported locator type: " + locatorType);
        };
    }
}
