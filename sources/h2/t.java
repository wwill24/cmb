package h2;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public class t implements Executor {
    public void execute(@NonNull Runnable runnable) {
        runnable.run();
    }
}
