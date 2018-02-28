package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExceed> list = new ArrayList<>();
        LocalTime localTime;
        LocalDate localDate;
        Map<LocalDate, Integer> map = new HashMap();
        for (UserMeal m :
                mealList) {

            localTime = m.getDateTime().toLocalTime();
            localDate = m.getDateTime().toLocalDate();
            if (map.get(localDate) != null)
                map.put(localDate, m.getCalories());
            map.put(localDate, map.get(localDate) + m.getCalories());


            if (startTime.isBefore(localTime) && (endTime.isAfter(localTime))) {

                list.add(new UserMealWithExceed(m.getDateTime(), m.getDescription(), m.getCalories(),
                        (map.get(localDate) > caloriesPerDay) ? true : false));
            }


        }


        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }


        for (UserMealWithExceed uEx :
                list) {
            System.out.println(uEx);
        }
        // TODO return filtered list with correctly exceeded field
        return list;
    }
}
