package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {

    public static void main(String[] args) {
        Address address = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields = Validator.advancedValidate(address);
        System.out.println(notValidFields); // =>  {country=[length less than 4], street=[can not be null]}
    }

    public static List<String> validate(Address address) {
        List<String> stringList = new ArrayList<>();
        var fields = address.getClass().getDeclaredFields();
        for (var field : fields) {
            var anotat = field.getDeclaredAnnotations();
            for (var anotation : anotat) {
                if (anotation.annotationType().getName().equals("exercise.NotNull"))
                    field.setAccessible(true);
                try {
                    if (field.get(address) == null)
                        stringList.add(field.getName());
                        break;
                } catch (IllegalAccessException e) {
                    System.out.println("Не удалось получить значение поля с помощью рефлексии");
                }
            }
        }

        return stringList;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> map = new HashMap<>();
        String messageOfErrorsNull = "can not be null";
        String messageOfErrorsLength = "length less than ";
        var fields = address.getClass().getDeclaredFields();
        for (var field : fields) {
            field.setAccessible(true);
            List<String> messagesOfErrors = new ArrayList<>();

            var anotat = field.getDeclaredAnnotations();
            for (var anotation : anotat) {
                if(anotation instanceof NotNull){
                    try {
                        if (field.get(address) == null){
                            messagesOfErrors.add(messageOfErrorsNull);
                            map.put(field.getName(), messagesOfErrors);
                            break;
                        }
                    } catch (IllegalAccessException e) {
                        System.out.println("Не удалось получить значение поля с помощью рефлексии");
                    }
                }
                else {
                    MinLength length = (MinLength) anotation;
                    int min = length.minLength();
                    String fildValue = "";
                    try {
                        fildValue = (String) field.get(address);
                    } catch (IllegalAccessException e) {
                        System.out.println("Не удалось получить значение поля с помощью рефлексии");
                    }
                    if(fildValue.length()<min){
                        messageOfErrorsLength = String.format(messageOfErrorsLength+ "%d", min);
                        messagesOfErrors.add(messageOfErrorsLength);
                        map.put(field.getName(), messagesOfErrors);
                    }
                }
            }
        }
        return map;
    }
}
// END
