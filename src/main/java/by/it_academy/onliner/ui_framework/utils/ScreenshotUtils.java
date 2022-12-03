package by.it_academy.onliner.ui_framework.utils;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Screenshots.takeScreenShotAsFile;
import static io.qameta.allure.Allure.addAttachment;
import static java.time.LocalDateTime.now;
import static org.apache.commons.io.FileUtils.openInputStream;

public final class ScreenshotUtils {

    public static void takeScreenshotAndAttachToAllureReport() {
        File screenshotAs = takeScreenShotAsFile();
        try {
            addAttachment("Screenshot " + now(), openInputStream(screenshotAs));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
