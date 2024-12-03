package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.j;

class i extends h {
    public static final e i(File file, FileWalkDirection fileWalkDirection) {
        j.g(file, "<this>");
        j.g(fileWalkDirection, "direction");
        return new e(file, fileWalkDirection);
    }

    public static final e j(File file) {
        j.g(file, "<this>");
        return i(file, FileWalkDirection.BOTTOM_UP);
    }
}
