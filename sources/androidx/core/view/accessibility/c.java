package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;

public final class c {

    static class a {
        static boolean a(AccessibilityManager accessibilityManager, b bVar) {
            return accessibilityManager.addTouchExplorationStateChangeListener(new C0045c(bVar));
        }

        static boolean b(AccessibilityManager accessibilityManager, b bVar) {
            return accessibilityManager.removeTouchExplorationStateChangeListener(new C0045c(bVar));
        }
    }

    public interface b {
        void onTouchExplorationStateChanged(boolean z10);
    }

    /* renamed from: androidx.core.view.accessibility.c$c  reason: collision with other inner class name */
    private static final class C0045c implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final b f4754a;

        C0045c(@NonNull b bVar) {
            this.f4754a = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0045c)) {
                return false;
            }
            return this.f4754a.equals(((C0045c) obj).f4754a);
        }

        public int hashCode() {
            return this.f4754a.hashCode();
        }

        public void onTouchExplorationStateChanged(boolean z10) {
            this.f4754a.onTouchExplorationStateChanged(z10);
        }
    }

    public static boolean a(@NonNull AccessibilityManager accessibilityManager, @NonNull b bVar) {
        return a.a(accessibilityManager, bVar);
    }

    public static boolean b(@NonNull AccessibilityManager accessibilityManager, @NonNull b bVar) {
        return a.b(accessibilityManager, bVar);
    }
}
