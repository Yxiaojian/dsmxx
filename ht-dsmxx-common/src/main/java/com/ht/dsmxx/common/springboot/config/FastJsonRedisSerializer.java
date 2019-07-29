package com.ht.dsmxx.common.springboot.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import com.alibaba.fastjson.JSON;

public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    public FastJsonRedisSerializer() {
    }

    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        } else {
            try {
                return JSON.toJSONBytes(t, new SerializerFeature[]{SerializerFeature.WriteClassName});
            } catch (Exception var3) {
                throw new SerializationException("Could not write JSON: " + var3.getMessage(), var3);
            }
        }
    }

    public T deserialize(byte[] bytes) throws SerializationException {
        String data = new String(bytes);
        return (T) JSON.parse(data);
    }
}
