package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.j;

public final class c {
    /* access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb2 = new StringBuilder(file.toString());
        if (file2 != null) {
            sb2.append(" -> " + file2);
        }
        if (str != null) {
            sb2.append(": " + str);
        }
        String sb3 = sb2.toString();
        j.f(sb3, "sb.toString()");
        return sb3;
    }
}
