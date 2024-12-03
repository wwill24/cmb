package q;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import o.c0;
import x.e;

public final class x implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f17092a = new HashSet(Arrays.asList(new String[]{"heroqltevzw", "heroqltetmo", "k61v1_basic_ref"}));

    static boolean b(@NonNull c0 c0Var) {
        return f17092a.contains(Build.DEVICE.toLowerCase(Locale.US));
    }
}
