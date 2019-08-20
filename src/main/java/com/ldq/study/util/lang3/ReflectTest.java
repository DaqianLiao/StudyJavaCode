package com.ldq.study.util.lang3;

import com.sun.tools.internal.xjc.model.CClass;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.reflect.TypeLiteral;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static java.lang.System.out;

public class ReflectTest {
    public class AClass {
        private String name;
        private String firstName;
        private String lastName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }



    @Test
    public void classTest() throws Exception {
        out.println("name: " + ClassUtils.getName(AClass.class));//全名
        out.println("shortName: " + ClassUtils.getShortClassName(AClass.class));//没有包名，包含外部类的名称
        out.println("simpleName: " + ClassUtils.getSimpleName(AClass.class));//只有类名，甚至没有外部类的名称
        out.println("isInner: " + ClassUtils.isInnerClass(AClass.class));
        out.println("abbreviate: " + ClassUtils.getAbbreviatedName(Integer.class, 4));
        out.println("canonical: " + ClassUtils.getCanonicalName(Integer.class));
        out.println("package:" + ClassUtils.getPackageName(Integer.class));
        out.println("short canonical: " + ClassUtils.getShortCanonicalName(Integer.class));
        out.println("primitive wrapper: " + ClassUtils.isPrimitiveWrapper(Integer.class));
        out.println("assignable: " + ClassUtils.isAssignable(CClass.class, Object.class));
        out.println("hierarchy: " + ClassUtils.hierarchy(AClass.class));
    }

    @Test
    public void type() throws Exception {
        out.println(TypeUtils.getTypeArguments(getClass(), TypeLiteral.class));
    }

    @Test
    public void field() throws Exception {
        Field[] fields = FieldUtils.getAllFields(AClass.class);
        System.out.println(fields.length);
        Field declaredFields = FieldUtils.getDeclaredField(AClass.class, "name", true);
        System.out.println(declaredFields.getName());
    }

    @Test
    public void method() throws Exception {
        Method getName = MethodUtils.getAccessibleMethod(AClass.class, "getName");
        out.println(getName.getReturnType().getName());
    }

    @Test
    public void constructor() throws Exception {

    }
}
