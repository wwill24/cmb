package com.squareup.workflow1;

import com.squareup.workflow1.internal.h;
import gk.f;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.Buffer;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0001\u0016B-\b\u0000\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00000\u000f0\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\t8@X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00000\u000f8@X\u0002¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/squareup/workflow1/TreeSnapshot;", "", "Lokio/ByteString;", "c", "other", "", "equals", "", "hashCode", "Lcom/squareup/workflow1/Snapshot;", "a", "Lgk/f;", "b", "()Lcom/squareup/workflow1/Snapshot;", "workflowSnapshot", "", "Lcom/squareup/workflow1/internal/h;", "()Ljava/util/Map;", "childTreeSnapshots", "Lkotlin/Function0;", "<init>", "(Lcom/squareup/workflow1/Snapshot;Lkotlin/jvm/functions/Function0;)V", "Companion", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class TreeSnapshot {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f23059c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final f f23060a;

    /* renamed from: b  reason: collision with root package name */
    private final f f23061b;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/squareup/workflow1/TreeSnapshot$Companion;", "", "Lokio/ByteString;", "bytes", "Lcom/squareup/workflow1/TreeSnapshot;", "a", "<init>", "()V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TreeSnapshot a(ByteString byteString) {
            j.g(byteString, "bytes");
            Buffer S = new Buffer().K1(byteString);
            return new TreeSnapshot(Snapshot.f23054c.b(g.a(S)), new TreeSnapshot$Companion$parse$1$1(S));
        }
    }

    public TreeSnapshot(Snapshot snapshot, Function0<? extends Map<h, TreeSnapshot>> function0) {
        j.g(function0, "childTreeSnapshots");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f23060a = b.a(lazyThreadSafetyMode, new TreeSnapshot$workflowSnapshot$2(snapshot));
        this.f23061b = b.a(lazyThreadSafetyMode, function0);
    }

    public final Map<h, TreeSnapshot> a() {
        return (Map) this.f23061b.getValue();
    }

    public final Snapshot b() {
        return (Snapshot) this.f23060a.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x002a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okio.ByteString c() {
        /*
            r7 = this;
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            com.squareup.workflow1.Snapshot r1 = r7.b()
            r2 = 0
            if (r1 != 0) goto L_0x000e
            r1 = r2
            goto L_0x0012
        L_0x000e:
            okio.ByteString r1 = r1.b()
        L_0x0012:
            if (r1 != 0) goto L_0x0016
            okio.ByteString r1 = okio.ByteString.f33309d
        L_0x0016:
            com.squareup.workflow1.g.c(r0, r1)
            java.util.Map r1 = r7.a()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x002a:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x006a
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            com.squareup.workflow1.internal.h r5 = (com.squareup.workflow1.internal.h) r5
            java.lang.Object r4 = r4.getValue()
            com.squareup.workflow1.TreeSnapshot r4 = (com.squareup.workflow1.TreeSnapshot) r4
            okio.ByteString r5 = r5.d()
            if (r5 != 0) goto L_0x004a
        L_0x0048:
            r6 = r2
            goto L_0x0063
        L_0x004a:
            okio.ByteString r4 = r4.c()
            int r6 = r4.H()
            if (r6 != 0) goto L_0x0056
            r6 = 1
            goto L_0x0057
        L_0x0056:
            r6 = 0
        L_0x0057:
            if (r6 != 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r4 = r2
        L_0x005b:
            if (r4 != 0) goto L_0x005e
            goto L_0x0048
        L_0x005e:
            kotlin.Pair r6 = new kotlin.Pair
            r6.<init>(r5, r4)
        L_0x0063:
            if (r6 != 0) goto L_0x0066
            goto L_0x002a
        L_0x0066:
            r3.add(r6)
            goto L_0x002a
        L_0x006a:
            int r1 = r3.size()
            r0.writeInt(r1)
            java.util.Iterator r1 = r3.iterator()
        L_0x0075:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0094
            java.lang.Object r2 = r1.next()
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r3 = r2.a()
            okio.ByteString r3 = (okio.ByteString) r3
            java.lang.Object r2 = r2.b()
            okio.ByteString r2 = (okio.ByteString) r2
            com.squareup.workflow1.g.c(r0, r3)
            com.squareup.workflow1.g.c(r0, r2)
            goto L_0x0075
        L_0x0094:
            okio.ByteString r0 = r0.y1()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.TreeSnapshot.c():okio.ByteString");
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof TreeSnapshot)) {
                return false;
            }
            TreeSnapshot treeSnapshot = (TreeSnapshot) obj;
            if (!j.b(treeSnapshot.b(), b()) || !j.b(treeSnapshot.a(), a())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i10;
        Snapshot b10 = b();
        if (b10 == null) {
            i10 = 0;
        } else {
            i10 = b10.hashCode();
        }
        return (i10 * 31) + a().hashCode();
    }
}
