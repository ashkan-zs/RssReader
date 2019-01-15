package com.ashkan.starter;

import com.ashkan.model.Feed;
import com.ashkan.model.FeedItem;
import com.rometools.rome.io.FeedException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    public static Stage stage;

    public static void main(String[] args) {

        launch();

//        RssReader rssReader = new RssReader("http://talaangor.ir/fa/rss/allnews");
//        Instagram instagram = new Instagram()
//                .setUsername("zs.ashkan@yahoo.com")
//                .setPassword("dev13717510");
//        try {
//            instagram.instaLogin();
//            Feed feed = new Feed("http://talaangor.ir/fa/rss/allnews");
//            for (FeedItem feedItem : feed.feesItems()) {
//                System.out.println(feedItem.getTitle());
//                System.out.println(feedItem.getPublishDate());
//                System.out.println(feedItem.getImgURL());
//                System.out.println(feedItem.getCaption());
//                System.out.println(feedItem.getPageURL());
//                System.out.println("--------------");
//            }
//            instagram.uploadPhoto(rssReader.feedsList());
//
//        } catch (IOException | FeedException e) {
//            e.printStackTrace();
//        }


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.stage = primaryStage;
        primaryStage.setTitle("Post app");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/mainForm.fxml"))));
        primaryStage.show();
    }
}
