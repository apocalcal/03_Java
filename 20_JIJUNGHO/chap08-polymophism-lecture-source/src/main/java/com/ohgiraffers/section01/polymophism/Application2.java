package com.ohgiraffers.section01.polymophism;

public class Application2 {
    public static void main(String[] args) {

        Animal[] animals = new Animal[5];

        animals[0] = new Rabbit(); // 다형성 적용, 업 캐스팅
        animals[1] = new Tiger();
        animals[2] = new Rabbit();
        animals[3] = new Tiger();
        animals[4] = new Rabbit();

        // Animal 클래스가 가진 메소드를 오버라이딩한 메소드 호출 시 동적바인딩을 이용하여 출력
        for (int i = 0; i < animals.length; i++) {
            animals[i].cry();
        }

        for (int i = 0; i < animals.length; i++) {
            if (animals[i] instanceof Rabbit) {
                ((Rabbit) animals[i]).jump();
            } else if (animals[i] instanceof Tiger) {
                ((Tiger) animals[i]).bite();
            } else {
                System.out.println("호랑이, 토끼가 아닙니다.");
            }
        }
    }
}
