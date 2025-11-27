SHOW DATABASES LIKE 'bs_nbgms2025';
USE bs_nbgms2025;

-- 创建人事ヒアリング表
CREATE TABLE bs_nbgms2025.jinji_hiaringu (
    hiaringu_id INT AUTO_INCREMENT PRIMARY KEY,
    gakusei_id INT NOT NULL,
    tantousya VARCHAR(100) NOT NULL,
    hiaringu_nichiji DATETIME NOT NULL,
    hiaringu_jikan VARCHAR(10) DEFAULT NULL,
    hiaringu_basyo VARCHAR(255) NOT NULL,
    hiaringu_genin TEXT NOT NULL,
    hiaringu_naiyou TEXT NOT NULL,
    bikou TEXT DEFAULT NULL,
    delete_flag INT DEFAULT 0 NOT NULL,
    sakuseisha VARCHAR(100) NOT NULL,
    sakusei_nichiji DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    koushinsha VARCHAR(100) DEFAULT NULL,
    koushin_nichiji DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    yobi1 VARCHAR(255) DEFAULT NULL,
    yobi2 VARCHAR(255) DEFAULT NULL,
    yobi3 TEXT DEFAULT NULL,
    -- 索引
    INDEX idx_gakusei_id (gakusei_id),
    INDEX idx_hiaringu_nichiji (hiaringu_nichiji)
);
-- 外键约束
ALTER TABLE bs_nbgms2025.gakusei 
ADD FOREIGN KEY (kurasu_id) REFERENCES bs_nbgms2025.kurasu_info(KURASU_ID);

ALTER TABLE bs_nbgms2025.jinji_hiaringu 
ADD FOREIGN KEY (gakusei_id) REFERENCES bs_nbgms2025.gakusei(gakusei_id);