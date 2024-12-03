package io.sentry.android.ndk;

final class NativeScope implements b {
    NativeScope() {
    }

    public static native void nativeAddBreadcrumb(String str, String str2, String str3, String str4, String str5, String str6);

    public static native void nativeRemoveUser();

    public static native void nativeSetExtra(String str, String str2);

    public static native void nativeSetUser(String str, String str2, String str3, String str4);

    public void a(String str, String str2) {
        nativeSetExtra(str, str2);
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6) {
        nativeAddBreadcrumb(str, str2, str3, str4, str5, str6);
    }

    public void c() {
        nativeRemoveUser();
    }

    public void d(String str, String str2, String str3, String str4) {
        nativeSetUser(str, str2, str3, str4);
    }
}
