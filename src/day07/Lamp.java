package day07;

public class Lamp {

    boolean isOn = false; // 멤버변수

    void turnOn(){          // 메소드 turnOn
        isOn = true;
        System.out.println(isOn);
    }

    void turnOff(){         // 메소드 turnOff
        isOn = false;
        System.out.println(isOn);
    }

}
