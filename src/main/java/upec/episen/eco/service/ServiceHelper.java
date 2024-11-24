package upec.episen.eco.service;

import java.lang.reflect.Field;
import java.util.Map;

public class ServiceHelper {

    public static <T> String genericUpdate(T target, Map<String, Object> updates) {

        for (Map.Entry<String, Object> entry : updates.entrySet()) {

            Field field;

            try {

                field = target.getClass().getDeclaredField(entry.getKey());

                field.setAccessible(true);

                field.set(target, entry.getValue());

            } catch (NoSuchFieldException e) {

                // Handle field not found in the entity

                return "Field not found: " + entry.getKey();

            } catch (IllegalArgumentException e) {

                // Handle illegal given value for the argument 

                return "Invalid value: " + entry.getKey() + " for the field: " + entry.getKey();

            } catch (IllegalAccessException e) {

                // Handle access denial to the field

                return "You don't have access to the field: " + entry.getKey();
            }

        }

        return "Updated Successfully";

    }


}