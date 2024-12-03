package a3;

import androidx.annotation.NonNull;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public interface c extends Closeable {
    String g0();

    boolean isSuccessful();

    String j();

    @NonNull
    InputStream l0() throws IOException;
}
