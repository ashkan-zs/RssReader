package com.ashkan.controller;

import com.ashkan.model.Feed;
import com.ashkan.model.FeedItem;
import com.ashkan.model.RssReader;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableView dataTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            Feed feed = new Feed("http://talaangor.ir/fa/rss/allnews");

            ObservableList<FeedItem> data = FXCollections.observableArrayList(feed.feesItems());

            TableColumn titleCol = new TableColumn("عنوان");
            titleCol.setMinWidth(100);
            titleCol.setCellValueFactory(new PropertyValueFactory<FeedItem, String>("title"));

            TableColumn captionCol = new TableColumn("موضوع");
            captionCol.setMinWidth(100);
            captionCol.setCellValueFactory(new PropertyValueFactory<FeedItem, String>("caption"));

            TableColumn imgCol = new TableColumn("عکس");
            imgCol.setMinWidth(100);
            imgCol.setCellValueFactory(new PropertyValueFactory<FeedItem, String>("imgURL"));

            dataTable.setItems(data);
            dataTable.getColumns().addAll(titleCol,imgCol,captionCol);
        } catch (IOException | FeedException e) {
            e.printStackTrace();
        }


    }
}
