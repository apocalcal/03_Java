package com.ohgiraffers.hw2.controller;

import com.ohgiraffers.hw2.model.dto.BoardDTO;
import com.ohgiraffers.hw2.view.ResultPrinter;

import java.util.ArrayList;
import java.util.Comparator;

public class BoardManager {
    ArrayList<BoardDTO> boardList = new ArrayList<>();
    ResultPrinter rp = new ResultPrinter();

    public void insertBoard(BoardDTO b) {
        int boardNo = 0;

        if(boardList == null || boardList.isEmpty()) {
            boardList = new ArrayList<>();
            boardNo++;
        } else {
            boardNo = boardList.get(boardList.size() - 1).getBoardNo() + 1;
        }
        b.setBoardNo(boardNo);
        boardList.add(b);
        rp.successPage("insertBoard");
    }

    public void selectAllList() {
        for(BoardDTO b : boardList) {
            System.out.println(b);
        }
    }

    public void selectOneBoard(int boardNo) {
        BoardDTO selected = null;
        if (boardList != null) {
            for(int i = 0; i < boardList.size(); i++) {
                if (boardList.get(i).getBoardNo() == boardNo) {
                    selected = boardList.get(i);
                    boardList.get(i).setReadCount(boardList.get(i).getReadCount() + 1);
                    break;
                }
            }
        }
        if (selected != null) {
            rp.printBoard(selected);
        } else {
            rp.errorPage("selectOneBoard");
        }
    }

    public void updateBoardTitle(int boardNo, String title) {
        int result = 0;
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getBoardNo() == boardNo) {
                boardList.get(i).setBoardTitle(title);
            }
        }
        rp.successPage("updateBoardTitle");
    }

    public void updateBoardContent(int boardNo, String content) {
        int result = 0;
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getBoardNo() == boardNo) {
                boardList.get(i).setBoardContent(content);
            }
        }
        rp.successPage("updateBoardContent");
    }

    public void deleteBoard(int boardNo) {
        int result = 0;
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getBoardNo() == boardNo) {
                boardList.remove(i);
            }
        }
        rp.successPage("deleteBoard");
    }

    public void searchBoard(String title) {
        ArrayList<BoardDTO> searchList = new ArrayList<>();
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getBoardTitle().contains(title)) {
                searchList.add(boardList.get(i));
            }
        }
        if (searchList.isEmpty()) {
            rp.noSearchResult();
        } else {
            rp.printAllList(searchList);
        }
    }

    public void sortList(Comparator<BoardDTO> c) {
        boardList.sort(c);
        rp.printAllList(boardList);
    }
}
