package com.rosenzest.base.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cn.hutool.core.util.StrUtil;

/**
 * 枚举类持有者
 * 
 * @author fronttang
 * @date 2021/07/22
 */
public final class EnumHolder<E extends IEnum<?>> {

	private Class<E> clazz;

	public EnumHolder(Class<E> clazz) {
		this.clazz = clazz;
	}

	/**
	 * 获取所有枚举对象
	 *
	 * @return 枚举对象数组
	 */
	public E[] items() {
		return clazz.getEnumConstants();
	}

	/**
	 * 根据code获取
	 * 
	 * @param code
	 * @return
	 */
	public E fromCode(String code) {
		if (StrUtil.isBlank(code)) {
			return null;
		}
		E[] items = items();
		for (E e : items) {
			if (e.code().equals(code)) {
				return e;
			}
		}
		return null;
	}

	/**
	 * 获取所有的code
	 * @return
	 */
	public List<String> getCodes() {
		List<String> list = new ArrayList<>();
		E[] enums = items();
		if (enums != null) {
			for (E e : enums) {
				list.add(e.code());
			}
		}
		return list;
	}

	/**
	 * 获取所有的desc
	 * @return
	 */
	public List<String> getDescs() {
		List<String> list = new ArrayList<>();
		E[] enums = items();
		if (enums != null) {
			for (E e : enums) {
				list.add(e.desc());
			}
		}
		return list;
	}

	/**
	 * 根据code获取名称
	 * 
	 * @param code
	 * @return
	 */
	public String desc(String code) {
		E item = fromCode(code);
		return Objects.nonNull(item) ? item.desc() : null;
	}

	/**
	 * 是否在枚举常量里
	 * 
	 * @param code
	 * @return
	 */
	public boolean contains(String code) {
		return getCodes().contains(code);
	}
}
