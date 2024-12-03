package androidx.core.os;

import androidx.core.util.c;

public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException(String str) {
        super(c.e(str, "The operation has been canceled."));
    }
}
