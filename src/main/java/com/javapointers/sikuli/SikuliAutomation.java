package com.javapointers.sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;

import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class SikuliAutomation {

    private Screen screen;
    private String basePath;

    public SikuliAutomation() throws URISyntaxException {
        screen = new Screen();
        URL resourceFolderURL = this.getClass().getClassLoader().getResource("images");
        basePath = resourceFolderURL.toURI().getPath() + "/";
    }

    private String getElement(String name){
        return basePath + name;
    }

    private void startTest() throws FindFailed {
        screen.wait(getElement("telegram.png"), 15);
        screen.click(getElement("telegram.png"));
        screen.wait(getElement("chat_with_bot.png"), 15);
        screen.click(getElement("chat_with_bot.png"));
        screen.click(getElement("hide_telegram.png"));
        while (true){
            if (screen.has(getElement("bot_alarm.png"))){
                try {
                    Thread.sleep(Duration.ofSeconds(2L));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                screen.click(getElement("bot_alarm.png"));
                if (screen.has(getElement("last_message_not_accepted.png"), 15)
                        && !screen.has(getElement("last_message_accepted.png"))){
                    screen.click(getElement("accept_button.png"));
                }
                screen.click(getElement("hide_telegram.png"));
            }
            try {
                Thread.sleep(Duration.ofSeconds(2L));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String... args) throws FindFailed, URISyntaxException {
        SikuliAutomation sikuliAutomation = new SikuliAutomation();
        sikuliAutomation.startTest();
    }
}
