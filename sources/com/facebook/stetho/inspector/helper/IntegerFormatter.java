package com.facebook.stetho.inspector.helper;

import android.annotation.TargetApi;
import android.view.ViewDebug;

public class IntegerFormatter {
    private static IntegerFormatter cachedFormatter;

    private static class IntegerFormatterWithHex extends IntegerFormatter {
        private IntegerFormatterWithHex() {
            super();
        }

        @TargetApi(21)
        public String format(Integer num, ViewDebug.ExportedProperty exportedProperty) {
            if (exportedProperty == null || !exportedProperty.formatToHexString()) {
                return IntegerFormatter.super.format(num, exportedProperty);
            }
            return "0x" + Integer.toHexString(num.intValue());
        }
    }

    public static IntegerFormatter getInstance() {
        if (cachedFormatter == null) {
            synchronized (IntegerFormatter.class) {
                if (cachedFormatter == null) {
                    cachedFormatter = new IntegerFormatterWithHex();
                }
            }
        }
        return cachedFormatter;
    }

    public String format(Integer num, ViewDebug.ExportedProperty exportedProperty) {
        return String.valueOf(num);
    }

    private IntegerFormatter() {
    }
}
