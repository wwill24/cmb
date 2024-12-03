package com.squareup.workflow1.ui;

import android.os.Parcelable;
import com.squareup.workflow1.Snapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Landroid/os/Parcelable;", "Lcom/squareup/workflow1/Snapshot;", "a", "wf1-core-android"}, k = 2, mv = {1, 6, 0})
public final class SnapshotParcelsKt {
    public static final Snapshot a(Parcelable parcelable) {
        j.g(parcelable, "<this>");
        return Snapshot.f23054c.c(new SnapshotParcelsKt$toSnapshot$1(parcelable));
    }
}
