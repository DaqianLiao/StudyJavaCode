package com.ldq.study.serializable.kryo;

public interface Serializer {

    public byte[] serialzer(Object obj);

    public <T> T deserializer(byte[] bytes);
}
