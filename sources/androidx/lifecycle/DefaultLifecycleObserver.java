package androidx.lifecycle;

import kotlin.jvm.internal.j;

public interface DefaultLifecycleObserver extends k {
    void onCreate(l lVar) {
        j.g(lVar, "owner");
    }

    void onDestroy(l lVar) {
        j.g(lVar, "owner");
    }

    void onPause(l lVar) {
        j.g(lVar, "owner");
    }

    void onResume(l lVar) {
        j.g(lVar, "owner");
    }

    void onStart(l lVar) {
        j.g(lVar, "owner");
    }

    void onStop(l lVar) {
        j.g(lVar, "owner");
    }
}
