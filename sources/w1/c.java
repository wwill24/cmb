package w1;

import android.os.Trace;
import androidx.annotation.NonNull;

final class c {
    public static void a(@NonNull String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
