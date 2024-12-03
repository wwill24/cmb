package q1;

import android.annotation.SuppressLint;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Ljava/nio/channels/ReadableByteChannel;", "input", "Ljava/nio/channels/FileChannel;", "output", "", "a", "room-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class c {
    @SuppressLint({"LambdaLast"})
    public static final void a(ReadableByteChannel readableByteChannel, FileChannel fileChannel) throws IOException {
        j.g(readableByteChannel, "input");
        j.g(fileChannel, "output");
        try {
            fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
