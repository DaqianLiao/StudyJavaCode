package com.ldq.study.annotation.table;



import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by diligent_leo on 2016/12/24.
 */
public class AnnotationCase {
    private static String query(Filter filter1) {
        StringBuilder stringBuilder = new StringBuilder();
        //1
        Class bClass = filter1.getClass();

        boolean isAnnotation = bClass.isAnnotationPresent(Table.class);
        if (!isAnnotation) {
            return null;
        }
        //
        Table table = (Table) bClass.getAnnotation(Table.class);
        String tableName = table.name();

        stringBuilder.append("select * from ").append(tableName).append(" where 1=1");

        //
        Field[] fieldList = bClass.getDeclaredFields();
        for (Field field : fieldList) {
            //
            //
            boolean isFileAnn = field.isAnnotationPresent(Column.class);
            if (!isFileAnn) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.name();
            //
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method getMethod = bClass.getMethod(getMethodName);
                fieldValue = (Object) getMethod.invoke(filter1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //
            if (fieldValue == null || fieldValue instanceof Integer && (Integer) fieldValue == 0) {
                continue;
            }
            stringBuilder.append(" and ").append(fieldName).append(" = ");
            if (fieldValue instanceof String) {
                if (((String) fieldValue).contains(",")) {
                    stringBuilder.deleteCharAt(stringBuilder.length()- 2);
                    String[] valueList = ((String) fieldValue).split(",");
                    stringBuilder.append("in(");
                    for (String value : valueList) {
                        stringBuilder.append("'").append(value).append("'").append(",");
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                    stringBuilder.append(")");
                } else {
                    stringBuilder.append("'").append(fieldValue).append("'");
                }
            }
            if (fieldValue instanceof Integer) {
                stringBuilder.append(fieldValue);
            }

        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Filter filter1 = new Filter();
        filter1.setId(10);

        Filter filter2 = new Filter();
        filter2.setUserName("lucy");

        Filter filter3 = new Filter();
        filter3.setEmail("liu@sina.com,zh@163.com,1234567@qq.com");

        String sql1 = query(filter1);
        System.out.println(sql1);
        String sql2 = query(filter2);
        System.out.println(sql2);
        String sql3 = query(filter3);
        System.out.println(sql3);

    }


}
