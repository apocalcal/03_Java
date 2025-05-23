/* 국어, 영어, 수학 점수를 입력받아
 * 평균 점수가 60점 이상이면서 각 과목이 40점 이상인 조건이 만족하면 "합격입니다!" 를 출력하세요,
 * 단, 합격이 아닌 경우 불합격 사유가 무엇인지를 모두 출력해주어야 합니다.
 * 평균점수 미달인 경우 "평균점수 미달로 불합격입니다." 라고 출력하고,
 * 과목당 과락 점수가 있는 경우 "xx 과목의 점수 미달로 불합격 입니다." 출력하세요
 * -- 입력 예시 --
 * 국어 점수를 입력하세요 : 60
 * 영어 점수를 입력하세요 : 30
 * 수학 점수를 입력하세요 : 20
 * -- 출력 예시 --
 * 평균 점수 미달로 불합격입니다.
 * 영어 점수 미달로 불합격입니다.
 * 수학 점수 미달로 불합격입니다.
 * */
package com.ohgiraffers.section01.conditional.level03;

import java.util.Scanner;

public class Application3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("국어 점수를 입력하세요 : ");
        int korean = getValidScore(sc);

        System.out.print("영어 점수를 입력하세요 : ");
        int english = getValidScore(sc);

        System.out.print("수학 점수를 입력하세요 : ");
        int math = getValidScore(sc);

        double average = (korean + english + math) / 3.0;

        boolean isPassed = true;
        StringBuilder result = new StringBuilder();

        if (average < 60) {
            result.append("평균 점수 미달로 불합격입니다.\n");
            isPassed = false;
        }

        if (korean < 40) {
            result.append("국어 점수 미달로 불합격입니다.\n");
            isPassed = false;
        }
        if (english < 40) {
            result.append("영어 점수 미달로 불합격입니다.\n");
            isPassed = false;
        }
        if (math < 40) {
            result.append("수학 점수 미달로 불합격입니다.\n");
            isPassed = false;
        }

        if (isPassed) {
            System.out.println("합격입니다!");
        } else {
            System.out.print(result.toString());
        }

        sc.close();
    }

    public static int getValidScore(Scanner sc) {
        int score = -1;
        while (true) {
            try {
                score = sc.nextInt();
                if (score < 0 || score > 100) {
                    System.out.println("잘못된 입력입니다. 0 이상 100 이하의 점수를 입력하세요.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                sc.next();
            }
        }
        return score;
    }
}

