package com.kdn.bitedu.test.test08;

import com.kdn.bitedu.test.test07.Calculator2;

/* 수퍼 클래스의 메서드를 서브 클래스의 목적에 맞추어 재정의하기
 * - Overriding
 */

public class Calculator3 extends Calculator2 {
  public void modular(int a) {
    result %= a;
  }
  
  public void divide(int a) {
    if (a == 0) {
      System.err.println("0으로 나눌 수 없습니다.");
      //return -1; //호출자에게 오류 상황을 알릴 방법이 없다!
    } else {
      //super 키워드를 사용하면 재정의 하기 직적의 메서드를 가리킬 수 있다.
      super.divide(a);
      //return 0; //호출자에게 오류 상황을 알릴 방법이 없다!
    }
    
  }
  
}






