package com.ashkan.model;

import com.rometools.rome.feed.synd.SyndEnclosure;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Feed {

    private String feedURL;
    private Date lastUpdate;
    private String title;
    private String description;

    private RssReader rssReader;
    private SyndFeed syndFeed;

    public Feed() {
    }

    public Feed(String feedURL) throws IOException, FeedException {
        this.feedURL = feedURL;
        rssReader = new RssReader(feedURL);
        syndFeed = rssReader.initFeeds();
    }

    public String getFeedURL() {
        return feedURL;
    }

    public void setFeedURL(String feedURL) throws IOException, FeedException {
        this.feedURL = feedURL;
        rssReader = new RssReader(feedURL);
        syndFeed = rssReader.initFeeds();

    }

    public Date getLastUpdate() throws IOException, FeedException {
        return syndFeed.getPublishedDate();
    }


    public String getTitle() {
        return syndFeed.getTitle();
    }


    public String getDescription() {
        return syndFeed.getDescription();
    }

    public List<FeedItem> feesItems() throws IOException, FeedException {
        List<FeedItem> feedItemList = new ArrayList<>();
        for (SyndEntry syndEntry : rssReader.feedsList()) {
            FeedItem feedItem = new FeedItem();
            feedItem.setTitle(syndEntry.getTitle());
            feedItem.setPublishDate(syndEntry.getPublishedDate());
            feedItem.setPageURL(syndEntry.getLink());
            feedItem.setCaption(syndEntry.getDescription() == null ? null : syndEntry.getDescription().getValue());
            for (SyndEnclosure syndEnclosure : syndEntry.getEnclosures()) {
                feedItem.setImgURL(syndEnclosure.getUrl());
            }
            feedItemList.add(feedItem);
        }
        return feedItemList;
    }
}
