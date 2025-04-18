package com.ohgiraffers.hw2.view;

import com.ohgiraffers.hw2.model.dto.BoardDTO;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InputBoard {
    BoardDTO board;
    Scanner sc = new Scanner(System.in);
    public BoardDTO inputBoard() {
        board = new BoardDTO();
        System.out.println("**** 새 게시글 쓰기 ****");
        System.out.print("글 제목 : ");
        String title = sc.nextLine();
        board.setBoardTitle(title);

        System.out.print("글 작성자 : ");
        String writer = sc.nextLine();
        board.setBoardWriter(writer);
        board.setBoardDate(new Date());

        System.out.print("글 내용 (exit 입력 시 종료) : ");
        String content = "";
        while (true) {
            String str = sc.nextLine();
            if (str.contains("exit")) {
                break;
            }
            content = content + str + "\n";
        }
        board.setBoardContent(content);
        return board;
    }

    public int inputBoardNo() {
        System.out.print("글 번호를 입력하세요 : ");
        int num = sc.nextInt();
        return num;
    }

    public String inputBoardTitle() {
        System.out.print("글 제목을 입력하세요 : ");
        String title = sc.next();
        return title;

    }

    public String inputBoardContent() {
        System.out.print("글 내용을 입력하세요 : ");
        String content = sc.nextLine();
        return content;
    }

}
