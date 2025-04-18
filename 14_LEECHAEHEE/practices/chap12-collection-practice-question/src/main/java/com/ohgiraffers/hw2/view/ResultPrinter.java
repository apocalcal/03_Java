package com.ohgiraffers.hw2.view;

import com.ohgiraffers.hw2.model.dto.BoardDTO;

import java.util.ArrayList;

public class ResultPrinter {
    public void printAllList(ArrayList<BoardDTO> list) {
      if (list != null) {
          System.out.println("출력할 내용이 없습니다.");
      } else {
          for (BoardDTO board : list) {
              printBoard(board);
          }
      }
    }

    public void printBoard(BoardDTO b) {
        System.out.println(b);
    }

    public void errorPage(String msg) {
        switch (msg) {
            case "insertBoard" :
                System.out.println("게시물이 없습니다.");
                break;
            case "selectOne" :
                System.out.println("조회된 글이 없습니다.");
                break;
            case "updateTitle" :
                System.out.println("게시물 제목 수정 실패!");
                break;
            case "updateContent" :
                System.out.println("게시글 내용 수정 실패!");
                break;
            case "deleteBoard" :
                System.out.println("게시글 삭제 실패");
                break;
        }
    }

    public void successPage(String msg) {
        switch (msg) {
            case "insertBoard" :
                System.out.println("게시글 등록 성공!");
                break;
            case "updateTitle" :
                System.out.println("게시글 제목 수정 성공!");
                break;
            case "updateContent" :
                System.out.println("게시글 내용 수정 성공!");
                break;
            case "deleteBoard" :
                System.out.println("게시글 삭제 성공!");
                break;
        }
    }

    public void noSearchResult() {
        System.out.println("검색 결과가 없습니다.");
    }
}
