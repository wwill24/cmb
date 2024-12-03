package kotlin.io;

import com.facebook.appevents.codeless.internal.Constants;
import java.io.File;
import java.util.Iterator;

class j extends i {
    public static boolean k(File file) {
        kotlin.jvm.internal.j.g(file, "<this>");
        Iterator it = i.j(file).iterator();
        while (true) {
            boolean z10 = true;
            while (true) {
                if (!it.hasNext()) {
                    return z10;
                }
                File file2 = (File) it.next();
                if (file2.delete() || !file2.exists()) {
                    if (z10) {
                    }
                }
                z10 = false;
            }
        }
    }

    public static String l(File file) {
        kotlin.jvm.internal.j.g(file, "<this>");
        String name = file.getName();
        kotlin.jvm.internal.j.f(name, "name");
        return StringsKt__StringsKt.O0(name, '.', "");
    }

    public static final File m(File file, File file2) {
        boolean z10;
        kotlin.jvm.internal.j.g(file, "<this>");
        kotlin.jvm.internal.j.g(file2, Constants.PATH_TYPE_RELATIVE);
        if (g.b(file2)) {
            return file2;
        }
        String file3 = file.toString();
        kotlin.jvm.internal.j.f(file3, "this.toString()");
        if (file3.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || StringsKt__StringsKt.R(file3, File.separatorChar, false, 2, (Object) null)) {
            return new File(file3 + file2);
        }
        return new File(file3 + File.separatorChar + file2);
    }

    public static File n(File file, String str) {
        kotlin.jvm.internal.j.g(file, "<this>");
        kotlin.jvm.internal.j.g(str, Constants.PATH_TYPE_RELATIVE);
        return m(file, new File(str));
    }
}
