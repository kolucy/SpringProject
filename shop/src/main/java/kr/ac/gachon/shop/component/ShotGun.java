package kr.ac.gachon.shop.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // 사용자 정의 빈 등록 (클래스 형태의 객체로 Bean 등록)
@Qualifier("basicShotGun") // Bean의 구체적인 선별 방법
@Primary // 같은 Bean 객체 주입시 우선 순위로 지정
public class ShotGun implements Weapon { // ShotGun 타입의 객체가 Bean으로 등록된다(by @Component)
    private String model = "Basic ShotGun";

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void fire() {
        System.out.println(model + " fire!!");
    }
}
