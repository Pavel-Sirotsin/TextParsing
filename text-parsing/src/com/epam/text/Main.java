package com.epam.text;

import com.epam.text.view.MainViewer;
import com.epam.text.view.ViewerProvider;

/**
 * 2.Работа с текстом (In honor of String).
 * Создать консольное приложенеие, разбирающие текст по програмированию из файла
 * и позволяющие выполнять с текстом три различных операции:
 * - Вывести все предложения текста в порядке возрастания количества слов в каждом из них.
 * - В каждом предложении текста поменять местами первое слово с последним не изменяя длинны предложения.
 * - В некотором предложении текста слова заданной длинны заменить указанной подстрокой,
 * длинна которой может не совподать с длинной слова:
 * заданная длинна - 5 букв(for example), подстрака: "SUBSTRING"(for example).
 * - log4J2
 * - Patterns: Composite (partly applied in Text tree), Chain Of Responsibility(applied for content slicing)
 * <p>
 * 20 Aug 2021  * @author
 * Pavel Sirotsin
 */

public class Main {
    public static void main(String[] args) {
        ViewerProvider provider = ViewerProvider.getInstance();
        MainViewer mainViewer = provider.getMainViewer();

        String response = mainViewer.showMenu();
        System.out.println(response);

        mainViewer.chooseOperation();

        System.out.println("\n***************************************\n");
        mainViewer.reassembleQuestion();


    }


}


