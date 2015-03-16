package com.guaraniexpress.tracking.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "com.guaraniexpress.tracking.dao.i18n.messages";
	private static ResourceBundle resourceBundle = null;

	static {
		
		try {
			resourceBundle = ResourceBundle
					.getBundle(BUNDLE_NAME, Locale.getDefault());
		} catch (MissingResourceException e) {
			resourceBundle = ResourceBundle
					.getBundle(BUNDLE_NAME);
		}
		
	}
	
	private Messages() {
	}

	public static String getString(String key) {
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String getString(String key, Object... arguments) {
		try {
			return MessageFormat.format(resourceBundle.getString(key), arguments);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
