package b2;

import androidx.annotation.NonNull;

public abstract class e {

    class a extends e {
        a() {
        }

        public d a(@NonNull String str) {
            return null;
        }
    }

    @NonNull
    public static e c() {
        return new a();
    }

    public abstract d a(@NonNull String str);

    public final d b(@NonNull String str) {
        d a10 = a(str);
        if (a10 == null) {
            return d.a(str);
        }
        return a10;
    }
}
