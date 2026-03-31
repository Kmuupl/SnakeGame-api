package com.snakegame.snakegame_api.service;

import com.snakegame.snakegame_api.model.Score;
import com.snakegame.snakegame_api.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> getTopScores() {
        return scoreRepository.getTopScores();
    }

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

    public Score update(Long id, Score score) {
        return scoreRepository.update(id, score);
    }
}
