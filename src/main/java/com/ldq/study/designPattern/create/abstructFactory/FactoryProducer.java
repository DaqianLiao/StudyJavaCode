package com.ldq.study.designPattern.create.abstructFactory;

public class FactoryProducer {

    public static PCFactory createFactory(String name) {
        //需要程序显示开启才能生效  java -ea *.jar
        assert name != null;
        if (name == null) {
            throw new IllegalArgumentException("工厂不存在");
        }
        PCFactory factory;
        switch (name.toLowerCase()) {
            case "dell":
                factory = new DellFactory();
                break;
            case "hp":
                factory = new HpFactory();
                break;
            default:
                throw new IllegalArgumentException("工厂不存在");
        }
        return factory;
    }

    /**
     * 通过反射获取工厂对象，简化switch操作
     * 反射大法好
     * @param name
     * @return
     * @throws Exception
     */
    public static PCFactory createFactoryByFeflex(String name) throws Exception {
        return (PCFactory) Class.forName(name).newInstance();
    }
}
