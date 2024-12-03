package androidx.startup;

import androidx.annotation.NonNull;

public final class StartupException extends RuntimeException {
    public StartupException(@NonNull String str) {
        super(str);
    }

    public StartupException(@NonNull Throwable th2) {
        super(th2);
    }
}
