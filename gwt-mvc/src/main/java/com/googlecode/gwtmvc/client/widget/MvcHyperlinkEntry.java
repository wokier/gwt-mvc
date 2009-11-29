package com.googlecode.gwtmvc.client.widget;

import java.util.Map;
//import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

/**
 * Mvc Hyperlink entry
 * 
 * @see SimpleEntry
 */
public class MvcHyperlinkEntry implements Entry<String, String> {

	private String key;
	private String value;

	/**
	 * Builds a Mvc Hyperlink entry
	 * 
	 * @param key
	 * @param value
	 */
	public MvcHyperlinkEntry(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * Builds a Mvc Hyperlink entry from another entry
	 * 
	 * @param e
	 */
	public MvcHyperlinkEntry(Entry<String, String> e) {
		this.key = e.getKey();
		this.value = e.getValue();
	}

	/**
	 * @see java.util.Map$Entry#getKey()
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @see java.util.Map$Entry#getValue()
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @see java.util.Map$Entry#setValue(java.lang.Object)
	 */
	public String setValue(String value) {
		String oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Map.Entry))
			return false;
		Map.Entry e = (Map.Entry) o;
		return eq(key, e.getKey()) && eq(value, e.getValue());
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return ((key == null) ? 0 : key.hashCode()) ^ ((value == null) ? 0 : value.hashCode());
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return key + "=" + value;
	}

	private static boolean eq(Object o1, Object o2) {
		return (o1 == null ? o2 == null : o1.equals(o2));
	}

}
