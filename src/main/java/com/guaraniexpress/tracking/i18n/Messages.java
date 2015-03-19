package com.guaraniexpress.tracking.i18n;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "trk_exception_messages";

	private Messages() {
		
	}

	public static String getString(String key) {
		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static String getString(String key, Object... arguments) {
		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
			return MessageFormat.format(resourceBundle.getString(key),
					arguments);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
