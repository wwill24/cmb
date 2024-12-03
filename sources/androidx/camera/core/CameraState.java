package androidx.camera.core;

import androidx.annotation.NonNull;

public abstract class CameraState {

    public enum Type {
        PENDING_OPEN,
        OPENING,
        OPEN,
        CLOSING,
        CLOSED
    }

    public static abstract class a {
        @NonNull
        public static a a(int i10) {
            return b(i10, (Throwable) null);
        }

        @NonNull
        public static a b(int i10, Throwable th2) {
            return new g(i10, th2);
        }

        public abstract Throwable c();

        public abstract int d();
    }

    @NonNull
    public static CameraState a(@NonNull Type type) {
        return b(type, (a) null);
    }

    @NonNull
    public static CameraState b(@NonNull Type type, a aVar) {
        return new f(type, aVar);
    }

    public abstract a c();

    @NonNull
    public abstract Type d();
}
