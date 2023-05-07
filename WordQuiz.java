import java.util.Vector;
import java.util.Scanner;
import java.util.Collections;

class Word {
    String x;
    String y;

    public Word(String x, String y) {
        this.x = x;
        this.y = y;
    }

//    @Override
//    public String toString() {
//        return y;
//    }

}

public class WordQuiz {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Vector<Word> v = new Vector<Word>();
        Scanner scanner = new Scanner(System.in);

        v.add(new Word("love","사랑"));
        v.add(new Word("animal","동물"));
        v.add(new Word("eye","눈"));
        v.add(new Word("emotion","감정"));
        v.add(new Word("human","인간"));
        v.add(new Word("fault","오류"));
        v.add(new Word("trade","거래"));
        v.add(new Word("painting","그림"));
        v.add(new Word("society","사회"));
        v.add(new Word("house","집"));
        v.add(new Word("water","물"));
        v.add(new Word("nose","코"));
        v.add(new Word("mouth","입"));
        v.add(new Word("baby","아기"));
        v.add(new Word("lion","사자"));
        v.add(new Word("cat","고양이"));
        v.add(new Word("map","지도"));


        System.out.println("****영어 단어 테스트 프로그램 \"명품영어\"입니다.****");

        while (true) {
            System.out.println("단어 테스트: 1, 단어 삽입: 2, 종료:3>>");
            int n = scanner.nextInt();
            if (n == 1) {
                int randomCount = (int)(Math.random()*v.size());
                Word selectedWord = v.get(randomCount);

                System.out.println("현재"+v.size()+"개의 단어가 들어있습니다. -1을 입력하면 테스트를 종료합니다.");
                int n2 = scanner.nextInt();
                if (n2 == -1) {
                    continue;
                }
                else {
                    Vector<String> choices = new Vector<String>();
                    choices.add(selectedWord.y);
                    while (choices.size() < 4) {
                        int i = (int)(Math.random()*v.size());
                        String choice = v.get(i).y;
                        if (!choices.contains(choice)) {
                            choices.add(choice);
                        }
                    } 

                    System.out.println(choices);

                    Collections.shuffle(choices); // 보기 순서 섞기

                    // 문제와 보기 출력
                    System.out.println(selectedWord.x+"?");
                    for(int i1 = 0; i1 < 4; i1++) {
                        System.out.println((i1+1) + ". " + choices.get(i1));
                    }
                    
                } // 중괄호 추가
            }
        }
    }
}
