CREATE TABLE user_scores (
 id BIGSERIAL PRIMARY KEY,
 user_email VARCHAR(255) UNIQUE,
 win_count INTEGER DEFAULT 0,
 lose_count INTEGER DEFAULT 0,
 draw_count INTEGER DEFAULT 0
);
