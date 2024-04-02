package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// fast rush final 3rd sprint task
public class DinnerConstructor {

    //генерим хэш-мапу
    HashMap<String, ArrayList<String>> dishWithCategories;

    DinnerConstructor() {
        dishWithCategories = new HashMap<>();
    }

    public void storeDishes(String dishType, String dishName) {
        ArrayList<String> dishesList;
        if (dishWithCategories.containsKey(dishType)) {
            dishesList = dishWithCategories.get(dishType);
            dishesList.add(dishName);
        } else {
            dishesList = new ArrayList<>();
            dishesList.add(dishName);
            dishWithCategories.put(dishType, dishesList);
        }
        System.out.println("Список сохраненных блюд:");
        for (String category : dishWithCategories.keySet()) {
            System.out.println("Категория: "+ category);
            for (String dish : dishWithCategories.get(category)) {
                System.out.println(dish);
            }
        }

    }

    // по заданию используем булеву проверку, но упрощаем ее, чтобы не возвращать false and true
    boolean typeChecks(String dishType) {
        return dishWithCategories.containsKey(dishType);
    }

    public void comboGenerator(int numberOfCombos, ArrayList<String> dishType) {
        for (int i = 1; i <= numberOfCombos; i++) {
            ArrayList<String> listOfCombo = new ArrayList<>();
            for (String typeOfDish : dishType) {
                ArrayList<String> dishesWithCategory = dishWithCategories.get(typeOfDish);
                int randomIndexDish = new Random().nextInt(dishesWithCategory.size());
                // забрали рандом элемент с рандом индексом
                listOfCombo.add(dishesWithCategory.get(randomIndexDish));
            }
            // выводим получившиеся комбов
            System.out.println("Комбо " + i);
            System.out.println(listOfCombo);
        }
    }
}