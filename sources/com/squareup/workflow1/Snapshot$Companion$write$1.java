package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lokio/ByteString;", "a", "()Lokio/ByteString;"}, k = 3, mv = {1, 6, 0})
final class Snapshot$Companion$write$1 extends Lambda implements Function0<ByteString> {
    final /* synthetic */ Function1<BufferedSink, Unit> $lazy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Snapshot$Companion$write$1(Function1<? super BufferedSink, Unit> function1) {
        super(0);
        this.$lazy = function1;
    }

    /* renamed from: a */
    public final ByteString invoke() {
        Buffer buffer = new Buffer();
        this.$lazy.invoke(buffer);
        return buffer.y1();
    }
}
