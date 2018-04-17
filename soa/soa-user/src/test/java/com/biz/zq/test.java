package com.biz.zq;

import com.biz.zq.dao.mysql.po.UserInfo;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class test<T> {

    private Field[] fields;

    private T t = (T)new UserInfo();

    /**
     * 这个map用来放属性名 + 值  例如 userName + 张三
     */
    private Map<String, Object> map = Maps.newHashMap();

    public static void main(String[] args) throws Exception {
       test<UserInfo> test = new test<>();
       Map<String, Object> map = test.getMap();
        System.out.println(map.keySet());
    }
    public test() throws Exception {
        this.getFields();
        this.getValue();
    }

    private void getFields(){
        Class clazz = t.getClass();
        //获取t类型的所有属性值
        Field[] fields = clazz.getDeclaredFields();
        this.fields = fields;
//        for (Field field : fields) {
//            map.put(field.getName(), field.get)
//        }
    }

    /**
     * 获取每个字段的属性值
     */
    private void getValue() throws Exception {
        for (Field field : fields) {

            //field的类型为String
            if (field.getGenericType().toString().equals("class java.lang.String")) {
                map.put(field.getName(), getFieldValue(field));
            }

            //field的类型为Integer
            if (field.getGenericType().toString().equals("class java.lang.Integer")) {
                map.put(field.getName(), getFieldValue(field));
            }

            //field的类型为如果类型是Double
            if (field.getGenericType().toString().equals("class java.lang.Double")) {
                map.put(field.getName(), getFieldValue(field));
            }

            //field的类型如果为Boolean
            if (field.getGenericType().toString().equals("class java.lang.Double")) {
                map.put(field.getName(), getFieldValue(field));
            }

            //field类型为boolean
            if (field.getGenericType().toString().equals("boolean")) {
                Method m = t.getClass().getMethod(field.getName());
                boolean val = (boolean)m.invoke(t);
                map.put(field.getName(), val);
            }
        }
    }

    private T getFieldValue(Field field) throws Exception {
        Method m = t.getClass().getMethod("get" + getMethodName(field.getName()));
        T val = (T)m.invoke(t);
        return val;
    }

    /**
     *  把一个字符串的第一个字母大写、效率是最高的、
     * @param fieldName
     * @return
     * @throws Exception
     */
    private static String getMethodName(String fieldName) throws Exception{
        byte[] items = fieldName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setT(T t) {
        this.t = t;
    }
}
