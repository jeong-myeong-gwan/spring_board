package org.example.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "spring_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255, columnDefinition = "VARCHAR(255) COMMENT '제목'")
    private String title;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '내용'")
    private String content;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '글 작성자'")
    private String writer;

    @Column(name = "create_dt", updatable = false, columnDefinition = "DATETIME COMMENT '등록일'")
    private LocalDateTime createDt = LocalDateTime.now();

    @Column(name = "meta_data", columnDefinition = "JSON COMMENT '파일 메타데이터'")
    @JsonIgnoreProperties
    private String metaData;

    public Board() {
    }

    // Getter와 Setter 메서드 추가
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }


}
