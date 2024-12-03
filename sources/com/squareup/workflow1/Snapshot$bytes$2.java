package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lokio/ByteString;", "a", "()Lokio/ByteString;"}, k = 3, mv = {1, 6, 0})
final class Snapshot$bytes$2 extends Lambda implements Function0<ByteString> {
    final /* synthetic */ Snapshot this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Snapshot$bytes$2(Snapshot snapshot) {
        super(0);
        this.this$0 = snapshot;
    }

    /* renamed from: a */
    public final ByteString invoke() {
        return (ByteString) this.this$0.f23055a.invoke();
    }
}
