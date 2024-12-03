package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.android.datatransport.cct.internal.e;

public abstract class ClientInfo {

    public enum ClientType {
        f37982a(0),
        ANDROID_FIREBASE(23);
        
        private final int value;

        private ClientType(int i10) {
            this.value = i10;
        }
    }

    public static abstract class a {
        @NonNull
        public abstract ClientInfo a();

        @NonNull
        public abstract a b(a aVar);

        @NonNull
        public abstract a c(ClientType clientType);
    }

    @NonNull
    public static a a() {
        return new e.b();
    }

    public abstract a b();

    public abstract ClientType c();
}
