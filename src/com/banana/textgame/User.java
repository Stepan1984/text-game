package com.banana.textgame;

import java.util.ArrayList;

public class User {

    int ОбщийЗароботок = 0;
    int hapiness = 3;
    boolean[] изученныеЯзыки = {true, false, false, false, false};
    ArrayList<String> компании = new ArrayList<>();
    String[] доступныеЯзыки = {"Java", "Pithon", "Pascal", "C", "Kotlin"};

    void printMoney() {
        System.out.println("Ваш счёт " + ОбщийЗароботок + "$.");
    }

    void printMood() {
        String smiles = "";
        for (int i = 1; i <= hapiness; i = i + 1) {
            smiles = smiles + "☻";
        }
        System.out.println("Ваше настроение: " + smiles + ".");
    }

    void printLearnedLanguages() {
        for (int i = 0; i < изученныеЯзыки.length; i++) {
            if (изученныеЯзыки[i] == true) {
                System.out.println("*" + доступныеЯзыки[i]);
            }

        }
    }
}