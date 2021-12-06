package com.rlin.software_coursedesign.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "collection")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collectionID")
    int collectionID;

    int userID;
    @ManyToOne
    @JoinColumn(name="gameCircleID")
    private GameCircle gameCircle;
    //int gameCircleID;

    public int getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(int collectionID) {
        this.collectionID = collectionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public GameCircle getGameCircle() {
        return gameCircle;
    }

    public void setGameCircle(GameCircle gameCircle) {
        this.gameCircle = gameCircle;
    }
}

