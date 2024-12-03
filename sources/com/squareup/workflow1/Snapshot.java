package com.squareup.workflow1;

import gk.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.BufferedSink;
import okio.ByteString;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\b\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001b\u0010\u0011\u001a\u00020\n8GX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/squareup/workflow1/Snapshot;", "", "", "toString", "other", "", "equals", "", "hashCode", "Lkotlin/Function0;", "Lokio/ByteString;", "a", "Lkotlin/jvm/functions/Function0;", "toByteString", "b", "Lgk/f;", "()Lokio/ByteString;", "bytes", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "c", "Companion", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
public final class Snapshot {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f23054c = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Function0<ByteString> f23055a;

    /* renamed from: b  reason: collision with root package name */
    private final f f23056b;

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0007J\u001c\u0010\f\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0007¨\u0006\u000f"}, d2 = {"Lcom/squareup/workflow1/Snapshot$Companion;", "", "Lokio/ByteString;", "byteString", "Lcom/squareup/workflow1/Snapshot;", "b", "Lkotlin/Function0;", "lazy", "a", "Lkotlin/Function1;", "Lokio/BufferedSink;", "", "c", "<init>", "()V", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Snapshot a(Function0<? extends ByteString> function0) {
            j.g(function0, "lazy");
            return new Snapshot(function0, (DefaultConstructorMarker) null);
        }

        public final Snapshot b(ByteString byteString) {
            j.g(byteString, "byteString");
            return new Snapshot(new Snapshot$Companion$of$2(byteString), (DefaultConstructorMarker) null);
        }

        public final Snapshot c(Function1<? super BufferedSink, Unit> function1) {
            j.g(function1, "lazy");
            return a(new Snapshot$Companion$write$1(function1));
        }
    }

    private Snapshot(Function0<? extends ByteString> function0) {
        this.f23055a = function0;
        this.f23056b = b.b(new Snapshot$bytes$2(this));
    }

    public /* synthetic */ Snapshot(Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0);
    }

    public final ByteString b() {
        return (ByteString) this.f23056b.getValue();
    }

    public boolean equals(Object obj) {
        Snapshot snapshot = obj instanceof Snapshot ? (Snapshot) obj : null;
        if (snapshot == null) {
            return false;
        }
        return j.b(b(), snapshot.b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return "Snapshot(" + b() + PropertyUtils.MAPPED_DELIM2;
    }
}
