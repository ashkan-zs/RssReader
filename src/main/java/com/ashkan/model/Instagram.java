package com.ashkan.model;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEnclosure;
import com.rometools.rome.feed.synd.SyndEntry;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramUploadPhotoRequest;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Instagram {
    private String username;
    private String password;
    private Instagram4j instagram;

    public Instagram() {
    }

    public Instagram(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void instaLogin() throws IOException {
        instagram = Instagram4j.builder().username(username).password(password).build();
        instagram.setup();
        instagram.login();
    }

    public void uploadPhoto(List<SyndEntry> syndEntries) throws IOException {

        for (SyndEntry syndEntry : syndEntries) {
            SyndEnclosure enclosure = syndEntry.getEnclosures().get(0);
            SyndContent syndContent = syndEntry.getDescription();
            if (syndContent == null || enclosure == null) continue;
//            System.out.println(enclosure.getUrl() + " " + syndContent.getValue());
            instagram.sendRequest(new InstagramUploadPhotoRequest(
                    new URL(enclosure.getUrl())
                    , syndContent.getValue()));
        }
    }

    public String getUsername() {
        return username;
    }

    public Instagram setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Instagram setPassword(String password) {
        this.password = password;
        return this;
    }
}
