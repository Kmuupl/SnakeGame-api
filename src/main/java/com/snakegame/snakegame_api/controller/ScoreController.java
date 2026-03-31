package com.snakegame.snakegame_api.controller;

import com.snakegame.snakegame_api.model.Score;
import com.snakegame.snakegame_api.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }


    @GetMapping
    public ResponseEntity<List<Score>> getTopScores() {
        return ResponseEntity.ok(scoreService.getTopScores());
    }


    @PostMapping
    public ResponseEntity<Score> save(@RequestBody Score score) {
        return ResponseEntity.ok(scoreService.save(score));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Score> update(@PathVariable Long id, @RequestBody Score score) {
        return ResponseEntity.ok(scoreService.update(id, score));
    }
}
