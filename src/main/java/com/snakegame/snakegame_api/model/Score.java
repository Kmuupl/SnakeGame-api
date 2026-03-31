package com.snakegame.snakegame_api.model;
import java.time.LocalDateTime;

public class Score {
    private Long id;
    private String playerName;
    private Integer score;
    private LocalDateTime createdAt;

    public Score() {}

    public Score(Long id, String playerName, Integer score, LocalDateTime createdAt){
        this.id = id;
        this.playerName = playerName;
        this.score = score;
        this.createdAt = createdAt;
    }

    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;}

    public String getPlayerName() { return playerName;}
    public void setPlayerName(String playerName) { this.playerName = playerName;}

    public Integer getScore() { return score;}
    public void setScore(Integer score) { this.score = score;}

    public LocalDateTime getCreatedAt() { return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt;}

}
