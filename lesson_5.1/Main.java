package com.kozyar;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        //********************************************//
        //******** Работа с парсингом страниц ********//
        //********************************************//
        Document doc = Jsoup.connect("https://robinhood.com/collections/100-most-popular").get(); // получение всей страницы

        // решение через таблицы
        //Elements eles = doc.select("tbody > tr");
        //System.out.println(eles.get(0).getElementsByTag("td").get(2));
        //System.out.println(eles.get(1).getElementsByTag("td").get(2));



        //Elements content = doc.getElementsByClass("rh-hyperlink _2uFNhgQu5JhaCtiNU8posI _2fax8HRY62uCbHnshxhsBl");
        Elements content = doc.getElementsByTag("tbody"); // выбираем элементы с тегом tbody
        String contentToString = content.toString();
        Scanner in = new Scanner(System.in); // создание экземпляра класса для сканирования ввода в консоль

        System.out.println("Input company (or stop to exit): ");
        String aim_comp = "";
        while (true) {
            try {
                aim_comp = in.nextLine(); // считать из консоли всю строку
                aim_comp = aim_comp.toUpperCase();

                if (aim_comp.equals("STOP")) break;

                Pattern patternComp = Pattern.compile(">" + aim_comp + "<"); // так как они всегда окружены тегом
                Matcher matcherComp = patternComp.matcher(contentToString);
                matcherComp.find();                         // найти первое совпадение
                int startComp = matcherComp.end();          // конец вхождения названия компании

                String pricePattern = "[\\$][\\d,]+\\.[\\d]+"; // паттерн для поиска дробных чисел, которые начинаются с $
                Pattern patternPrice = Pattern.compile(pricePattern);
                Matcher matcherPrice = patternPrice.matcher(contentToString.substring(startComp));
                matcherPrice.find(); // найти первое вхождение
                System.out.println(matcherPrice.group(0)); // вывести
            } catch (Exception e) {
                System.out.println("Company does not exist, try again");
            }
        }
    }
}
