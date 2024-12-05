package com.rosenzest.base.enums;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 枚举工具类</br>
 * 使用方式</br>
 * <code>
 * LoginType loginType = EnumUtils.init(LoginType.class).fromCode("1");</br>
 * String name = EnumUtils.init(LoginType.class).getNamefromCode("1");</br>
 * boolean inEnum = EnumUtils.init(LoginType.class).isInEnum("1");</br>
 * </code>
 * 
 * @author fronttang
 * @date 2021/07/22
 */
public final class EnumUtils {

    private static final ConcurrentHashMap<Class<?>, EnumHolder<?>> CACHE =
        new ConcurrentHashMap<Class<?>, EnumHolder<?>>();


    @SuppressWarnings("unchecked")
    public static <E extends IEnum<?>> EnumHolder<E> init(Class<E> clazz) {
    	EnumHolder<E> enumUtil = (EnumHolder<E>)CACHE.get(clazz);
        if (Objects.isNull(enumUtil)) {
            enumUtil = new EnumHolder<E>(clazz);
            CACHE.put(clazz, enumUtil);
        }
        return enumUtil;
    }
}
