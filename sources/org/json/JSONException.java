package org.json;

public class JSONException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public JSONException(String str) {
        super(str);
    }

    public JSONException(String str, Throwable th2) {
        super(str, th2);
    }

    public JSONException(Throwable th2) {
        super(th2.getMessage(), th2);
    }
}
