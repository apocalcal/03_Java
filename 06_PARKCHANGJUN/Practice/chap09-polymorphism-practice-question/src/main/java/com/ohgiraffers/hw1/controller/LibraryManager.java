package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.dto.AniBook;
import com.ohgiraffers.hw1.model.dto.Book;
import com.ohgiraffers.hw1.model.dto.CookBook;
import com.ohgiraffers.hw1.model.dto.Member;

import java.util.Scanner;

public class LibraryManager {
    private Member mem = null;
    private Book[] bList = new Book[5];

    {
        bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
        bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
        bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
        bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
        bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
    }


    public void insertMember(Member mem) { // 멤버 자료형의 멤버 참조 변수를 매개 변수로 받음
        // 전달받은 mem 주소 값을 해당 회원 레퍼런스(mem)에 대입
        this.mem = mem; // 필드의 멤버 변수인 멤버에 매개 변수로 받은 변수를 초기화

    }

    public Member myInfo() {
        return mem;
    }

    public Book[] selectAll() {
        return bList;
    }

    public Book[] searchBook(String keyword) {
        // 검색 결과를 담아줄 새로운 Book 객체 배열 생성
        // 검색 결과 도서 목록이 최대 5개일 수 있으니 임의로 크기 5 할당
        Book[] myList = new Book[5];

        // for문을 이용하여 bList 도서 목록들의 도서명과 전달받은 keyword 비교
        // 전달받은 keyword를 포함하고 있으면 → HINT : String 클래스의 contains() 참고
        // 검색결과의 도서목록에 담기 → HINT : count 이용

        int count = 0;
        for (int i = 0; i < bList.length; i++) {
            if(bList[i].getTitle().contains(keyword)) {
                myList[count++] = bList[i];
            }
        }

        // 해당 검색결과의 도서목록 주소 값 리턴
        return myList;
    }

    public int rentBook(int index) {
        int result = 0;
        Book book = bList[index];

        if (book instanceof AniBook) {
            // 전달 받은 index의 bList 객체가 만화책을 참조하고 있고
            // 해당 만화책의 제한 나이와 회원의 나이를 비교하여 회원 나이가 적을 경우
            // result를 1로 초기화 → 나이제한으로 대여 불가
            if(((AniBook) book).getAccessAge() > mem.getAge()) {
                result = 1;
            }
        } else if (book instanceof CookBook) {
            // 전달 받은 index의 bList 객체가 요리책을 참조하고 있고
            // 해당 요리책의 쿠폰유무가 “유”일 경우
            // 회원의 couponCount 1 증가 처리 후
            // result를 2로 초기화 → 성공적으로 대여 완료, 요리학원 쿠폰 발급

            if (((CookBook) book).isCoupon()) {
                mem.setCouponCount(mem.getCouponCount() + 1);
                result = 2;
            }
        }

        // result 값 리턴
        return result;
    }
}