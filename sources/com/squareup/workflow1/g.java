package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0004\u001a\u0012\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0004¨\u0006\n"}, d2 = {"Lokio/BufferedSink;", "", "str", "d", "Lokio/BufferedSource;", "b", "Lokio/ByteString;", "bytes", "c", "a", "wf1-workflow-core"}, k = 2, mv = {1, 6, 0})
public final class g {
    public static final ByteString a(BufferedSource bufferedSource) {
        j.g(bufferedSource, "<this>");
        return bufferedSource.O0((long) bufferedSource.readInt());
    }

    public static final String b(BufferedSource bufferedSource) {
        j.g(bufferedSource, "<this>");
        return a(bufferedSource).Q();
    }

    public static final BufferedSink c(BufferedSink bufferedSink, ByteString byteString) {
        j.g(bufferedSink, "<this>");
        j.g(byteString, "bytes");
        bufferedSink.writeInt(byteString.H()).K1(byteString);
        return bufferedSink;
    }

    public static final BufferedSink d(BufferedSink bufferedSink, String str) {
        j.g(bufferedSink, "<this>");
        j.g(str, "str");
        return c(bufferedSink, ByteString.f33308c.c(str));
    }
}
