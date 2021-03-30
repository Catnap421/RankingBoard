package com.merang.bleum.biz.board;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data // getter & setter 생성 
public class BoardDTO {
    private int seq;
    private String title;
    private String contents;
    private String writer;
    private String imagePath;
    private int like;
    private int pageView;
}
