package defpackage;

import kotlin.jvm.internal.j;

/* renamed from: JsonLogicException  reason: default package */
public final class JsonLogicException extends Exception {
    private final String message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonLogicException(String str) {
        super(str);
        j.g(str, "message");
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }
}
