package com.banana.textgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    String[] доступныеЯзыки = {"Java", "Pithon", "Pascal", "C", "Kotlin"};
    Scanner клавиатура = new Scanner(System.in);
    User пользователь = new User();


    public static void main(String[] args) {
        // вызывает метод start()
        new Main().start();
    }

    /*
     * Метод с логикой игры.
     */
    private void start() {
        onStart();
        for (int i = 1; i <= 5; ++i) {
            onNewDay(i);
        }
        onFinish();
    }

    /*
     * Метод вызывается один раз при старте игры.
     */
    void onStart() {
        System.out.println("привет,");

        Scanner клавиатура = new Scanner(System.in);
        String[] варианты = {"Как тебя зовут?", "Хэй, вот из ё нейм?", "Скажите ваше имя."};
        int числоОт0До2 = (int) (Math.random() * варианты.length);
        System.out.println(варианты[числоОт0До2]);
        String имя = клавиатура.nextLine();
        System.out.println("Привет " + имя);

    }

    /*
     * Метод вызывается каждый игровый день.
     * Единственный параметр: dayNumber - номер текущего игрового дня.
     */
    void onNewDay(int dayNumber) {
        System.out.println("День номер " + dayNumber + ".");
        String smiles = "";
        for (int i = 1; i <= пользователь.hapiness; i = i + 1) {
            smiles = smiles + "☻";
        }
        System.out.println("Ваше настроение: " + smiles + ".");
        System.out.println("Вы знаете языки:");
        printLearnedLanguages();
        System.out.println("Компании, в каторых вы работаете:" + пользователь.компании + ".");


        System.out.println("Что будем делать?");
        String action = клавиатура.nextLine();
        switch (action.toLowerCase()) {
            case "код":
                System.out.println("Введите код");
                String код = клавиатура.nextLine();
                код = код.replace(" ", "");
                int зароботок = код.length();
                пользователь.ОбщийЗароботок = пользователь.ОбщийЗароботок + зароботок;
                пользователь.hapiness = пользователь.hapiness - 1;
                System.out.println("За день ты зароботал " + пользователь.ОбщийЗароботок + "$.");

                break;
            case "скакалка":
                System.out.println("Окей, вы попрыгали на скакалке");
                пользователь.hapiness = пользователь.hapiness + 1;
                break;
            case "изучить":
                learnLanguage();
                break;
            case ("пельмешки"):
                скушатьПельмешки();
             break;
            case "работа":
                 найтиРаботу();
                 break;
            case "уволиться":
               увольнение();
                break;
            case "кости":
                броситьКости();
                break;
            default:
                System.out.println("Ошибка");
        }



    /*
     * Метод вызывается по завершению игры.
     */
    }

    void onFinish() {
        System.out.println("Вы набрали " + финальныеОчки() + "очков.");
        System.out.println("Пока!");

    }

    void learnLanguage() {
        System.out.println("Выбери язык для изучения.");
        String выбранныйЯзык = клавиатура.nextLine();

        for (int i = 0; i < доступныеЯзыки.length; i++) {
            if (доступныеЯзыки[i] .equals(выбранныйЯзык) && пользователь.изученныеЯзыки[i] == false
            && пользователь.hapiness > 0
            && пользователь.ОбщийЗароботок > 20)   {
                пользователь.изученныеЯзыки[i] = true;
                пользователь.hapiness -= 1;
                пользователь.ОбщийЗароботок -= 20;
            } else if (пользователь.hapiness == 0){
                System.out.println("Вам слишком грустно.");
            } else if (пользователь.ОбщийЗароботок < 20) {
                System.out.println("У вас не хватает денег");
            }else if (пользователь.изученныеЯзыки[i] == true){
                System.out.println("Вы уже знаете этот язык.");
            }


        }

    }

    void printLearnedLanguages() {
        for (int i = 0; i < пользователь.изученныеЯзыки.length; i++) {
            if (пользователь.изученныеЯзыки[i] == true) {
                System.out.println("*" + доступныеЯзыки[i]);
            }
        }

    }
    void скушатьПельмешки() {
        boolean данныеВведённыеВерно = false;
        while (данныеВведённыеВерно == false) {
            System.out.println("Сколько пельмешек?");
            String строка = клавиатура.nextLine();
            try {
                int количествоПельмешек = Integer.parseInt(строка);
                скушатьПельмешки(количествоПельмешек);
                данныеВведённыеВерно = true;
            } catch (Exception e) {
                System.out.println("Ошибка парсинга, :c");
            }
        }

    }

    void скушатьПельмешки(int количествоПельмешек) {
        пользователь.ОбщийЗароботок=пользователь.ОбщийЗароботок - 5 * количествоПельмешек;
        пользователь.hapiness=пользователь.hapiness + 5 * количествоПельмешек;
    }

    int финальныеОчки(){
        int очки = пользователь.ОбщийЗароботок * 2 + пользователь.hapiness * 3;
        for (int i = 0; i < пользователь.изученныеЯзыки.length; i++) {
            if (пользователь.изученныеЯзыки[i] == true) {
                очки = очки + 5;
            }
        }
        return очки;
    }

    void найтиРаботу() {
        System.out.println("В какой кампании будете работать?");
        String компания = клавиатура.nextLine();
        пользователь.компании.add(компания);
    }
    void увольнение() {
        System.out.println("Из какой компании хотите уволиться?");
        String компания = клавиатура.nextLine();
        пользователь.компании.remove(компания);
        }
        void броситьКости(){
        int число = (int) (Math.random() * 6 + 1);
        System.out.println("Вам выпало число " + число);
        if ( число % 2 == 0 ) {
                System.out.println("Вы выиграли деньги");
            пользователь.ОбщийЗароботок = пользователь.ОбщийЗароботок + 2;
        }else {
                System.out.println("Вы победитель по жизни");
            пользователь.hapiness = пользователь.hapiness + 3;
            }
        }
}