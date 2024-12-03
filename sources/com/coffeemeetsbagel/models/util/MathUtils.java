package com.coffeemeetsbagel.models.util;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class MathUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Integer convertForApi(Integer num, boolean z10) {
            if (num == null) {
                return null;
            }
            return z10 ? num : Integer.valueOf((int) Math.floor(((double) num.intValue()) * 1.609344d));
        }

        public final Integer convertForDisplay(Integer num, boolean z10) {
            if (num == null) {
                return null;
            }
            return z10 ? num : Integer.valueOf((int) Math.ceil(((double) num.intValue()) * 0.6213711922d));
        }
    }
}
