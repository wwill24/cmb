package nj;

import androidx.annotation.NonNull;

public abstract class a {

    private static class b extends a {
        private b() {
        }

        @NonNull
        public String b(@NonNull String str) {
            return str;
        }
    }

    @NonNull
    public static a a() {
        return new b();
    }

    @NonNull
    public abstract String b(@NonNull String str);
}
