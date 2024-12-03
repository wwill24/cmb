package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.j;

class g {
    private static final int a(String str) {
        char c10;
        int a02;
        int a03 = StringsKt__StringsKt.a0(str, File.separatorChar, 0, false, 4, (Object) null);
        if (a03 == 0) {
            if (str.length() <= 1 || str.charAt(1) != (c10 = File.separatorChar) || (a02 = StringsKt__StringsKt.a0(str, c10, 2, false, 4, (Object) null)) < 0) {
                return 1;
            }
            int a04 = StringsKt__StringsKt.a0(str, File.separatorChar, a02 + 1, false, 4, (Object) null);
            if (a04 >= 0) {
                return a04 + 1;
            }
            return str.length();
        } else if (a03 > 0 && str.charAt(a03 - 1) == ':') {
            return a03 + 1;
        } else {
            if (a03 != -1 || !StringsKt__StringsKt.R(str, ':', false, 2, (Object) null)) {
                return 0;
            }
            return str.length();
        }
    }

    public static final boolean b(File file) {
        j.g(file, "<this>");
        String path = file.getPath();
        j.f(path, "path");
        return a(path) > 0;
    }
}
