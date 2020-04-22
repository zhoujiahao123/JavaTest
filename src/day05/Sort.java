package day05;

import java.util.List;

public class Sort {
    public static void sortByNumber(List<Person> list, int start, int end) {
        if (start >= end) return;
        Person basePerson = list.get(end);
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && list.get(i).getNumber() <= basePerson.getNumber()) i++;
            if (i < j) {
                Person tempPerson = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tempPerson);
                j--;
            }
            while (i < j && list.get(j).getNumber() >= basePerson.getNumber()) j--;
            if (i < j) {
                Person tempPerson = list.get(j);
                list.set(j, list.get(i));
                list.set(i, tempPerson);
                i++;
            }
        }
        sortByNumber(list, start, j - 1);
        sortByNumber(list, j + 1, end);
    }
}
