package com.squareup.workflow1.ui;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import okio.BufferedSink;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lokio/BufferedSink;", "bufferedSink", "", "a", "(Lokio/BufferedSink;)V"}, k = 3, mv = {1, 6, 0})
final class SnapshotParcelsKt$toSnapshot$1 extends Lambda implements Function1<BufferedSink, Unit> {
    final /* synthetic */ Parcelable $this_toSnapshot;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotParcelsKt$toSnapshot$1(Parcelable parcelable) {
        super(1);
        this.$this_toSnapshot = parcelable;
    }

    public final void a(BufferedSink bufferedSink) {
        j.g(bufferedSink, "bufferedSink");
        Parcel obtain = Parcel.obtain();
        j.f(obtain, "obtain()");
        obtain.writeParcelable(this.$this_toSnapshot, 0);
        byte[] marshall = obtain.marshall();
        j.f(marshall, "byteArray");
        bufferedSink.write(marshall);
        obtain.recycle();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((BufferedSink) obj);
        return Unit.f32013a;
    }
}
