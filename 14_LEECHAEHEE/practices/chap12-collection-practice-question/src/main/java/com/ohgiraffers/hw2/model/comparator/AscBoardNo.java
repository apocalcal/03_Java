package com.ohgiraffers.hw2.model.comparator;

import com.ohgiraffers.hw2.model.dto.BoardDTO;

import java.util.Comparator;

public class AscBoardNo implements Comparator<BoardDTO> {

    @Override
    public int compare(BoardDTO b1, BoardDTO b2) {
        return b1.getBoardNo() - b2.getBoardNo();
    }
}
