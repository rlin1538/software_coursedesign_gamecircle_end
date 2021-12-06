package com.rlin.software_coursedesign.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "gamecircle")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class GameCircle {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameCircleID")
    int gameCircleID;

    String gameCircleTitle;
    String gameCircleContent;
    String gameCirclePicture;

    public int getGameCircleID() {
        return gameCircleID;
    }

    public void setGameCircleID(int gameCircleID) {
        this.gameCircleID = gameCircleID;
    }

    public String getGameCircleTitle() {
        return gameCircleTitle;
    }

    public void setGameCircleTitle(String gameCircleTitle) {
        this.gameCircleTitle = gameCircleTitle;
    }

    public String getGameCircleContent() {
        return gameCircleContent;
    }

    public void setGameCircleContent(String gameCircleContent) {
        this.gameCircleContent = gameCircleContent;
    }

    public String getGameCirclePicture() {
        return gameCirclePicture;
    }

    public void setGameCirclePicture(String gameCirclePicture) {
        this.gameCirclePicture = gameCirclePicture;
    }
}

