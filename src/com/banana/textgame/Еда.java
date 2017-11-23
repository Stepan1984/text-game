package com.banana.textgame;

public class Еда {

    public int getСтоимость() {
        return 0;
    }

    public int getЖирок() {
        return 0;
    }

    int дайОбщуюСтоимость(int количество) {
        return количество * getСтоимость();
    }

    int дайОбщийЖирок(int количество) {
        return количество * getЖирок();
    }
}
