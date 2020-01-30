package am.basic.web.util;

import am.basic.web.model.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MainReflect {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InstantiationException {


        String className = "am.basic.web.model.User";
        Class clazz = Class.forName(className);
        Object ob = clazz.newInstance();
        Field field = clazz.getDeclaredField("id");
        field.setAccessible(true);
        field.set(ob, 5);
        Field[] fields = clazz.getDeclaredFields();

        for (Field aField : fields) {
            System.out.println(aField.getName());
            Annotation []annotation = aField.getDeclaredAnnotations();
            for (Annotation annotation1: annotation) {
                System.out.println(annotation1.annotationType());
            }

        }

    }
}