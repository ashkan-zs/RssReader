package com.ashkan.model;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class RssReader {

    private String rssUrl;

    public RssReader() {
    }

    public RssReader(String rssUrl) {
        this.rssUrl = rssUrl;
    }

    public String getRssUrl() {
        return rssUrl;
    }

    public RssReader setRssUrl(String rssUrl) {
        this.rssUrl = rssUrl;
        return this;
    }

    public SyndFeed initFeeds() throws IOException, FeedException {
        return new SyndFeedInput().build(new XmlReader(new URL(rssUrl)));
    }


    public List<SyndEntry> feedsList() throws IOException, FeedException {
        return initFeeds().getEntries();
    }

}
