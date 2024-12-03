package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException {
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i10) {
        this("Http request failed with status code: " + i10, i10);
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i10) {
        this(str, i10, (Throwable) null);
    }

    public HttpException(String str, int i10, Throwable th2) {
        super(str, th2);
        this.statusCode = i10;
    }
}
