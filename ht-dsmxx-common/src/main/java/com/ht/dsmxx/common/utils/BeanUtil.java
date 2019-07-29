package com.ht.dsmxx.common.utils;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ht.dsmxx.common.page.HtPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BeanUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanUtil.class);

    public BeanUtil() {
    }

    public static <T> HtPage<T> convertPage(HtPage<?> sourcePage, Class<T> clazz) {
        if (sourcePage == null) {
            return null;
        } else {
            List<T> targetList = convertList(sourcePage.getRecords(), clazz);
            HtPage<T> targetPage = new HtPage(sourcePage.getPageIndex(), sourcePage.getPageSize(), targetList, sourcePage.getTotal());
            return targetPage;
        }
    }

    public static <T> List<T> convertList(List<?> list, Class<T> targetClass) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList();
        } else {
            List<T> listDest = new ArrayList();
            Iterator var3 = list.iterator();

            while (var3.hasNext()) {
                Object source = var3.next();
                T target = convert(source, targetClass);
                listDest.add(target);
            }

            return listDest;
        }
    }

    public static <T> T convert(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        } else {
            try {
                T result = targetClass.newInstance();
                copyProperties(source, result);
                return result;
            } catch (IllegalAccessException | InstantiationException var3) {
                LOGGER.warn(source.getClass().getSimpleName() + " convert to " + targetClass.getSimpleName() + " fail");
                throw new RuntimeException(var3);
            }
        }
    }

    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
        if (target instanceof BeanUtil.ConversionCustomizble) {
            ((BeanUtil.ConversionCustomizble) target).convertOthers(source);
        }

    }

    public static Object getPropValue(Object obj, String prop) {
        if (obj != null && prop != null) {
            PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(obj.getClass(), prop);

            try {
                Method readMethod = propertyDescriptor.getReadMethod();
                return readMethod.invoke(obj);
            } catch (Exception var4) {
                return null;
            }
        } else {
            return null;
        }
    }

    public interface ConversionCustomizble {
        void convertOthers(Object srcObj);
    }

}
