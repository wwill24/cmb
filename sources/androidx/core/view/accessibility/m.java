package androidx.core.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;

public class m {

    static class a {
        static int a(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        static int b(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        static void c(AccessibilityRecord accessibilityRecord, int i10) {
            accessibilityRecord.setMaxScrollX(i10);
        }

        static void d(AccessibilityRecord accessibilityRecord, int i10) {
            accessibilityRecord.setMaxScrollY(i10);
        }
    }

    static class b {
        static void a(AccessibilityRecord accessibilityRecord, View view, int i10) {
            accessibilityRecord.setSource(view, i10);
        }
    }

    public static void a(@NonNull AccessibilityRecord accessibilityRecord, int i10) {
        a.c(accessibilityRecord, i10);
    }

    public static void b(@NonNull AccessibilityRecord accessibilityRecord, int i10) {
        a.d(accessibilityRecord, i10);
    }

    public static void c(@NonNull AccessibilityRecord accessibilityRecord, View view, int i10) {
        b.a(accessibilityRecord, view, i10);
    }
}
