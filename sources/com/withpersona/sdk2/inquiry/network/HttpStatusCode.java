package com.withpersona.sdk2.inquiry.network;

import kotlin.ranges.IntRange;

public final class HttpStatusCode {
    public static final int BAD_GATEWAY_502 = 502;
    private static final IntRange CLIENT_ERRORS = new IntRange(400, 499);
    public static final int CONFLICT_409 = 409;
    public static final HttpStatusCode INSTANCE = new HttpStatusCode();
    public static final int NETWORK_ERROR_0 = 0;
    public static final int NOT_FOUND_404 = 404;
    public static final int PAYLOAD_TOO_LARGE_413 = 413;
    private static final IntRange SERVER_ERRORS = new IntRange(500, 599);
    public static final int UNAUTHORIZED_401 = 401;
    public static final int UNPROCESSABLE_ENTITY_422 = 422;

    private HttpStatusCode() {
    }

    public final IntRange getCLIENT_ERRORS() {
        return CLIENT_ERRORS;
    }

    public final IntRange getSERVER_ERRORS() {
        return SERVER_ERRORS;
    }
}
