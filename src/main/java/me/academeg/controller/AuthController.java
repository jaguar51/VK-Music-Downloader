package me.academeg.controller;

import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import me.academeg.api.VkData;

public class AuthController {

    private VkData vkData;

    @FXML
    private WebView webView;

    @FXML
    private void initialize() {
        vkData = new VkData();
        WebEngine engine = webView.getEngine();
        engine.load(vkData.getLogInUrl());
        engine.setJavaScriptEnabled(true);
        engine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == Worker.State.SUCCEEDED) {
                String accessToken = VkData.parseAccessToken(engine.getLocation());
                if (accessToken != null) {
                    vkData.setAccessToken(accessToken);
                    System.out.println(vkData.getAccessToken());
                    System.out.println("OK");
                }
            }
        });

    }
}
