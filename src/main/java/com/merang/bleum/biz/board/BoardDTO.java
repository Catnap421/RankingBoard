package com.merang.bleum.biz.board;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data // getter & setter 생성 
@RequiredArgsConstructor
public class BoardDTO {
    private final String title;
    private final String contents;
    private final int like;

}
