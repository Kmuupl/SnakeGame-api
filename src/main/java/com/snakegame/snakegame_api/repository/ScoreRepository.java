package com.snakegame.snakegame_api.repository;

import com.snakegame.snakegame_api.model.Score;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@Repository
public class ScoreRepository {
    private final DSLContext dsl;

    public ScoreRepository(DSLContext dsl){
        this.dsl = dsl;
    }

    public List <Score> getTopScores() {
        return dsl.select(
                        field("id"),
                        field("player_name"),
                        field("score"),
                        field("created_at"))
                .from(table("scores"))
                .orderBy(field("score").desc())
                .limit(10)
                .fetch(record -> new Score(
                        record.get(field("id"), Long.class),
                        record.get(field("player_name"), String.class),
                        record.get(field("score"), Integer.class),
                        record.get(field("created_at"), LocalDateTime.class)
                ));
    }


    public Score save(Score score) {
        return dsl.insertInto(table("scores"))
                .set(field("player_name"), score.getPlayerName())
                .set(field("score"), score.getScore())
                .set(field("created_at"), LocalDateTime.now())
                .returning(
                        field("id"),
                        field("player_name"),
                        field("score"),
                        field("created_at"))
                .fetchOne(record -> new Score(
                        record.get(field("id"), Long.class),
                        record.get(field("player_name"), String.class),
                        record.get(field("score"), Integer.class),
                        record.get(field("created_at"), LocalDateTime.class)
                ));
    }


    public Score update(Long id, Score score) {
        return dsl.update(table("scores"))
                .set(field("score"), score.getScore())
                .where(field("id").eq(id))
                .returning(
                        field("id"),
                        field("player_name"),
                        field("score"),
                        field("created_at"))
                .fetchOne(record -> new Score(
                        record.get(field("id"), Long.class),
                        record.get(field("player_name"), String.class),
                        record.get(field("score"), Integer.class),
                        record.get(field("created_at"), LocalDateTime.class)
                ));
    }
}

