package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.j;

public class FileSystemException extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemException(File file2, File file3, String str) {
        super(c.a(file2, file3, str));
        j.g(file2, "file");
        this.file = file2;
        this.other = file3;
        this.reason = str;
    }
}
