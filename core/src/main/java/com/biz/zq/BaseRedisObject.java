package com.biz.zq;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Redis实体基础类
 * @author ZhengQin
 */
public class BaseRedisObject<ID extends Serializable> {

    private ID id;

    private Timestamp createTime;

    private Timestamp updateTime;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 将属性和值放进一个Map
     */
    public Map<Object, Object> toMap() throws Exception {
        Map<Object, Object> map = Maps.newHashMap();
        Class clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
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
                Method m = this.getClass().getMethod(field.getName());
                boolean val = (boolean)m.invoke(this);
                map.put(field.getName(), val);
            }
        }
        return map;
    }

    private Object getFieldValue(Field field) throws Exception {
        Method m = this.getClass().getMethod("get" + getMethodName(field.getName()));
        Object val = (Object)m.invoke(this);
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
}
