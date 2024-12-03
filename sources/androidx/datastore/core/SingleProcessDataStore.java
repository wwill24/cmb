package androidx.datastore.core;

import com.coffeemeetsbagel.models.NetworkProfile;
import gk.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.s;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 S*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0003\u0007%)Br\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0!\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000$\u00120\b\u0002\u0010P\u001a*\u0012&\u0012$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000G\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030F\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000(\u0012\b\b\u0002\u0010/\u001a\u00020,ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ7\u0010\u0007\u001a\u00028\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\u0013\u0010\u0019\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0016J\u0013\u0010\u001a\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0016J?\u0010\u001d\u001a\u00028\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u001c\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\f\u0010 \u001a\u00020\n*\u00020\u001fH\u0002R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000(8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R \u00105\u001a\b\u0012\u0004\u0012\u00028\u0000008\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002XD¢\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010>\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R&\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000@0?8\u0002X\u0004¢\u0006\f\n\u0004\bA\u0010B\u0012\u0004\bC\u0010DRC\u0010J\u001a,\u0012&\u0012$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000G\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0018\u00010F8\u0002@\u0002X\u000eø\u0001\u0000¢\u0006\u0006\n\u0004\bH\u0010IR \u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000L0K8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010N\u0002\u0004\n\u0002\b\u0019¨\u0006T"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore;", "T", "Landroidx/datastore/core/d;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "transform", "a", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "newData", "", "z", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/datastore/core/SingleProcessDataStore$b$a;", "read", "r", "(Landroidx/datastore/core/SingleProcessDataStore$b$a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/datastore/core/SingleProcessDataStore$b$b;", "update", "s", "(Landroidx/datastore/core/SingleProcessDataStore$b$b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "u", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "v", "t", "x", "w", "Lkotlin/coroutines/CoroutineContext;", "callerContext", "y", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/io/File;", "p", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "produceFile", "Landroidx/datastore/core/i;", "b", "Landroidx/datastore/core/i;", "serializer", "Landroidx/datastore/core/a;", "c", "Landroidx/datastore/core/a;", "corruptionHandler", "Lkotlinx/coroutines/k0;", "d", "Lkotlinx/coroutines/k0;", "scope", "Lkotlinx/coroutines/flow/b;", "e", "Lkotlinx/coroutines/flow/b;", "getData", "()Lkotlinx/coroutines/flow/b;", "data", "", "f", "Ljava/lang/String;", "SCRATCH_SUFFIX", "g", "Lgk/f;", "q", "()Ljava/io/File;", "file", "Lkotlinx/coroutines/flow/i;", "Landroidx/datastore/core/j;", "h", "Lkotlinx/coroutines/flow/i;", "getDownstreamFlow$annotations", "()V", "downstreamFlow", "", "Landroidx/datastore/core/g;", "i", "Ljava/util/List;", "initTasks", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/SingleProcessDataStore$b;", "j", "Landroidx/datastore/core/SimpleActor;", "actor", "initTasksList", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/datastore/core/i;Ljava/util/List;Landroidx/datastore/core/a;Lkotlinx/coroutines/k0;)V", "k", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class SingleProcessDataStore<T> implements d<T> {

    /* renamed from: k  reason: collision with root package name */
    public static final a f5003k = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Set<String> f5004l = new LinkedHashSet();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Object f5005m = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Function0<File> f5006a;

    /* renamed from: b  reason: collision with root package name */
    private final i<T> f5007b;

    /* renamed from: c  reason: collision with root package name */
    private final a<T> f5008c;

    /* renamed from: d  reason: collision with root package name */
    private final k0 f5009d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlinx.coroutines.flow.b<T> f5010e = d.v(new SingleProcessDataStore$data$1(this, (kotlin.coroutines.c<? super SingleProcessDataStore$data$1>) null));

    /* renamed from: f  reason: collision with root package name */
    private final String f5011f = ".tmp";

    /* renamed from: g  reason: collision with root package name */
    private final f f5012g = b.b(new SingleProcessDataStore$file$2(this));
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final i<j<T>> f5013h = s.a(k.f5034a);

    /* renamed from: i  reason: collision with root package name */
    private List<? extends Function2<? super g<T>, ? super kotlin.coroutines.c<? super Unit>, ? extends Object>> f5014i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final SimpleActor<b<T>> f5015j;

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00018\u0000X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$a;", "", "", "", "activeFiles", "Ljava/util/Set;", "a", "()Ljava/util/Set;", "activeFilesLock", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "<init>", "()V", "datastore-core"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<String> a() {
            return SingleProcessDataStore.f5004l;
        }

        public final Object b() {
            return SingleProcessDataStore.f5005m;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$b;", "T", "", "<init>", "()V", "a", "b", "Landroidx/datastore/core/SingleProcessDataStore$b$a;", "Landroidx/datastore/core/SingleProcessDataStore$b$b;", "datastore-core"}, k = 1, mv = {1, 5, 1})
    private static abstract class b<T> {

        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0017\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\n"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$b$a;", "T", "Landroidx/datastore/core/SingleProcessDataStore$b;", "Landroidx/datastore/core/j;", "a", "Landroidx/datastore/core/j;", "()Landroidx/datastore/core/j;", "lastState", "<init>", "(Landroidx/datastore/core/j;)V", "datastore-core"}, k = 1, mv = {1, 5, 1})
        public static final class a<T> extends b<T> {

            /* renamed from: a  reason: collision with root package name */
            private final j<T> f5019a;

            public a(j<T> jVar) {
                super((DefaultConstructorMarker) null);
                this.f5019a = jVar;
            }

            public j<T> a() {
                return this.f5019a;
            }
        }

        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002BT\u0012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR6\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00038\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000eR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00108\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\f\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$b$b;", "T", "Landroidx/datastore/core/SingleProcessDataStore$b;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "a", "Lkotlin/jvm/functions/Function2;", "d", "()Lkotlin/jvm/functions/Function2;", "transform", "Lkotlinx/coroutines/w;", "b", "Lkotlinx/coroutines/w;", "()Lkotlinx/coroutines/w;", "ack", "Landroidx/datastore/core/j;", "c", "Landroidx/datastore/core/j;", "()Landroidx/datastore/core/j;", "lastState", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "()Lkotlin/coroutines/CoroutineContext;", "callerContext", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/w;Landroidx/datastore/core/j;Lkotlin/coroutines/CoroutineContext;)V", "datastore-core"}, k = 1, mv = {1, 5, 1})
        /* renamed from: androidx.datastore.core.SingleProcessDataStore$b$b  reason: collision with other inner class name */
        public static final class C0050b<T> extends b<T> {

            /* renamed from: a  reason: collision with root package name */
            private final Function2<T, kotlin.coroutines.c<? super T>, Object> f5020a;

            /* renamed from: b  reason: collision with root package name */
            private final w<T> f5021b;

            /* renamed from: c  reason: collision with root package name */
            private final j<T> f5022c;

            /* renamed from: d  reason: collision with root package name */
            private final CoroutineContext f5023d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0050b(Function2<? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> function2, w<T> wVar, j<T> jVar, CoroutineContext coroutineContext) {
                super((DefaultConstructorMarker) null);
                j.g(function2, "transform");
                j.g(wVar, "ack");
                j.g(coroutineContext, "callerContext");
                this.f5020a = function2;
                this.f5021b = wVar;
                this.f5022c = jVar;
                this.f5023d = coroutineContext;
            }

            public final w<T> a() {
                return this.f5021b;
            }

            public final CoroutineContext b() {
                return this.f5023d;
            }

            public j<T> c() {
                return this.f5022c;
            }

            public final Function2<T, kotlin.coroutines.c<? super T>, Object> d() {
                return this.f5020a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$c;", "Ljava/io/OutputStream;", "", "b", "", "write", "", "bytes", "off", "len", "close", "flush", "Ljava/io/FileOutputStream;", "a", "Ljava/io/FileOutputStream;", "getFileOutputStream", "()Ljava/io/FileOutputStream;", "fileOutputStream", "<init>", "(Ljava/io/FileOutputStream;)V", "datastore-core"}, k = 1, mv = {1, 5, 1})
    private static final class c extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final FileOutputStream f5024a;

        public c(FileOutputStream fileOutputStream) {
            j.g(fileOutputStream, "fileOutputStream");
            this.f5024a = fileOutputStream;
        }

        public void close() {
        }

        public void flush() {
            this.f5024a.flush();
        }

        public void write(int i10) {
            this.f5024a.write(i10);
        }

        public void write(byte[] bArr) {
            j.g(bArr, NetworkProfile.BISEXUAL);
            this.f5024a.write(bArr);
        }

        public void write(byte[] bArr, int i10, int i11) {
            j.g(bArr, "bytes");
            this.f5024a.write(bArr, i10, i11);
        }
    }

    public SingleProcessDataStore(Function0<? extends File> function0, i<T> iVar, List<? extends Function2<? super g<T>, ? super kotlin.coroutines.c<? super Unit>, ? extends Object>> list, a<T> aVar, k0 k0Var) {
        j.g(function0, "produceFile");
        j.g(iVar, "serializer");
        j.g(list, "initTasksList");
        j.g(aVar, "corruptionHandler");
        j.g(k0Var, "scope");
        this.f5006a = function0;
        this.f5007b = iVar;
        this.f5008c = aVar;
        this.f5009d = k0Var;
        this.f5014i = CollectionsKt___CollectionsKt.x0(list);
        this.f5015j = new SimpleActor<>(k0Var, new SingleProcessDataStore$actor$1(this), SingleProcessDataStore$actor$2.f5018a, new SingleProcessDataStore$actor$3(this, (kotlin.coroutines.c<? super SingleProcessDataStore$actor$3>) null));
    }

    private final void p(File file) {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException(j.p("Unable to create parent directories of ", file));
            }
        }
    }

    /* access modifiers changed from: private */
    public final File q() {
        return (File) this.f5012g.getValue();
    }

    /* access modifiers changed from: private */
    public final Object r(b.a<T> aVar, kotlin.coroutines.c<? super Unit> cVar) {
        j<T> value = this.f5013h.getValue();
        if (!(value instanceof b)) {
            if (value instanceof h) {
                if (value == aVar.a()) {
                    Object v10 = v(cVar);
                    if (v10 == b.d()) {
                        return v10;
                    }
                    return Unit.f32013a;
                }
            } else if (j.b(value, k.f5034a)) {
                Object v11 = v(cVar);
                if (v11 == b.d()) {
                    return v11;
                }
                return Unit.f32013a;
            } else if (value instanceof f) {
                throw new IllegalStateException("Can't read in final state.".toString());
            }
        }
        return Unit.f32013a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(androidx.datastore.core.SingleProcessDataStore.b.C0050b<T> r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$handleUpdate$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 r0 = (androidx.datastore.core.SingleProcessDataStore$handleUpdate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 r0 = new androidx.datastore.core.SingleProcessDataStore$handleUpdate$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r5) goto L_0x004a
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.w r9 = (kotlinx.coroutines.w) r9
            goto L_0x004e
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.w r9 = (kotlinx.coroutines.w) r9
            java.lang.Object r2 = r0.L$1
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore$b$b r4 = (androidx.datastore.core.SingleProcessDataStore.b.C0050b) r4
            gk.g.b(r10)     // Catch:{ all -> 0x0052 }
            r10 = r9
            r9 = r4
            goto L_0x00a0
        L_0x004a:
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.w r9 = (kotlinx.coroutines.w) r9
        L_0x004e:
            gk.g.b(r10)     // Catch:{ all -> 0x0052 }
            goto L_0x00b8
        L_0x0052:
            r10 = move-exception
            goto L_0x00d9
        L_0x0055:
            gk.g.b(r10)
            kotlinx.coroutines.w r10 = r9.a()
            kotlin.Result$a r2 = kotlin.Result.f32010a     // Catch:{ all -> 0x00d5 }
            kotlinx.coroutines.flow.i<androidx.datastore.core.j<T>> r2 = r8.f5013h     // Catch:{ all -> 0x00d5 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00d5 }
            androidx.datastore.core.j r2 = (androidx.datastore.core.j) r2     // Catch:{ all -> 0x00d5 }
            boolean r6 = r2 instanceof androidx.datastore.core.b     // Catch:{ all -> 0x00d5 }
            if (r6 == 0) goto L_0x0081
            kotlin.jvm.functions.Function2 r2 = r9.d()     // Catch:{ all -> 0x00d5 }
            kotlin.coroutines.CoroutineContext r9 = r9.b()     // Catch:{ all -> 0x00d5 }
            r0.L$0 = r10     // Catch:{ all -> 0x00d5 }
            r0.label = r5     // Catch:{ all -> 0x00d5 }
            java.lang.Object r9 = r8.y(r2, r9, r0)     // Catch:{ all -> 0x00d5 }
            if (r9 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00b8
        L_0x0081:
            boolean r6 = r2 instanceof androidx.datastore.core.h     // Catch:{ all -> 0x00d5 }
            if (r6 == 0) goto L_0x0086
            goto L_0x0088
        L_0x0086:
            boolean r5 = r2 instanceof androidx.datastore.core.k     // Catch:{ all -> 0x00d5 }
        L_0x0088:
            if (r5 == 0) goto L_0x00c4
            androidx.datastore.core.j r5 = r9.c()     // Catch:{ all -> 0x00d5 }
            if (r2 != r5) goto L_0x00bd
            r0.L$0 = r9     // Catch:{ all -> 0x00d5 }
            r0.L$1 = r8     // Catch:{ all -> 0x00d5 }
            r0.L$2 = r10     // Catch:{ all -> 0x00d5 }
            r0.label = r4     // Catch:{ all -> 0x00d5 }
            java.lang.Object r2 = r8.u(r0)     // Catch:{ all -> 0x00d5 }
            if (r2 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r2 = r8
        L_0x00a0:
            kotlin.jvm.functions.Function2 r4 = r9.d()     // Catch:{ all -> 0x00d5 }
            kotlin.coroutines.CoroutineContext r9 = r9.b()     // Catch:{ all -> 0x00d5 }
            r0.L$0 = r10     // Catch:{ all -> 0x00d5 }
            r5 = 0
            r0.L$1 = r5     // Catch:{ all -> 0x00d5 }
            r0.L$2 = r5     // Catch:{ all -> 0x00d5 }
            r0.label = r3     // Catch:{ all -> 0x00d5 }
            java.lang.Object r9 = r2.y(r4, r9, r0)     // Catch:{ all -> 0x00d5 }
            if (r9 != r1) goto L_0x007d
            return r1
        L_0x00b8:
            java.lang.Object r10 = kotlin.Result.b(r10)     // Catch:{ all -> 0x0052 }
            goto L_0x00e3
        L_0x00bd:
            androidx.datastore.core.h r2 = (androidx.datastore.core.h) r2     // Catch:{ all -> 0x00d5 }
            java.lang.Throwable r9 = r2.a()     // Catch:{ all -> 0x00d5 }
            throw r9     // Catch:{ all -> 0x00d5 }
        L_0x00c4:
            boolean r9 = r2 instanceof androidx.datastore.core.f     // Catch:{ all -> 0x00d5 }
            if (r9 == 0) goto L_0x00cf
            androidx.datastore.core.f r2 = (androidx.datastore.core.f) r2     // Catch:{ all -> 0x00d5 }
            java.lang.Throwable r9 = r2.a()     // Catch:{ all -> 0x00d5 }
            throw r9     // Catch:{ all -> 0x00d5 }
        L_0x00cf:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x00d5 }
            r9.<init>()     // Catch:{ all -> 0x00d5 }
            throw r9     // Catch:{ all -> 0x00d5 }
        L_0x00d5:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00d9:
            kotlin.Result$a r0 = kotlin.Result.f32010a
            java.lang.Object r10 = gk.g.a(r10)
            java.lang.Object r10 = kotlin.Result.b(r10)
        L_0x00e3:
            kotlinx.coroutines.y.c(r9, r10)
            kotlin.Unit r9 = kotlin.Unit.f32013a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.s(androidx.datastore.core.SingleProcessDataStore$b$b, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0114 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(kotlin.coroutines.c<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInit$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.datastore.core.SingleProcessDataStore$readAndInit$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInit$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$1
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x007b
            if (r2 == r6) goto L_0x0067
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r1 = r0.L$3
            kotlinx.coroutines.sync.c r1 = (kotlinx.coroutines.sync.c) r1
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref$BooleanRef) r2
            java.lang.Object r3 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref$ObjectRef) r3
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            gk.g.b(r14)
            goto L_0x0117
        L_0x0042:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x004a:
            java.lang.Object r2 = r0.L$5
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r8 = r0.L$4
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1 r8 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1) r8
            java.lang.Object r9 = r0.L$3
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref$BooleanRef) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref$ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.sync.c r11 = (kotlinx.coroutines.sync.c) r11
            java.lang.Object r12 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r12 = (androidx.datastore.core.SingleProcessDataStore) r12
            gk.g.b(r14)
            goto L_0x00d8
        L_0x0067:
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r8 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref$ObjectRef) r8
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.sync.c r9 = (kotlinx.coroutines.sync.c) r9
            java.lang.Object r10 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r10 = (androidx.datastore.core.SingleProcessDataStore) r10
            gk.g.b(r14)
            goto L_0x00b8
        L_0x007b:
            gk.g.b(r14)
            kotlinx.coroutines.flow.i<androidx.datastore.core.j<T>> r14 = r13.f5013h
            java.lang.Object r14 = r14.getValue()
            androidx.datastore.core.k r2 = androidx.datastore.core.k.f5034a
            boolean r14 = kotlin.jvm.internal.j.b(r14, r2)
            if (r14 != 0) goto L_0x0099
            kotlinx.coroutines.flow.i<androidx.datastore.core.j<T>> r14 = r13.f5013h
            java.lang.Object r14 = r14.getValue()
            boolean r14 = r14 instanceof androidx.datastore.core.h
            if (r14 == 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r14 = r5
            goto L_0x009a
        L_0x0099:
            r14 = r6
        L_0x009a:
            if (r14 == 0) goto L_0x0138
            kotlinx.coroutines.sync.c r9 = kotlinx.coroutines.sync.d.b(r5, r6, r7)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r0.L$0 = r13
            r0.L$1 = r9
            r0.L$2 = r2
            r0.L$3 = r2
            r0.label = r6
            java.lang.Object r14 = r13.x(r0)
            if (r14 != r1) goto L_0x00b6
            return r1
        L_0x00b6:
            r10 = r13
            r8 = r2
        L_0x00b8:
            r2.element = r14
            kotlin.jvm.internal.Ref$BooleanRef r14 = new kotlin.jvm.internal.Ref$BooleanRef
            r14.<init>()
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1 r2 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1
            r2.<init>(r9, r14, r8, r10)
            java.util.List<? extends kotlin.jvm.functions.Function2<? super androidx.datastore.core.g<T>, ? super kotlin.coroutines.c<? super kotlin.Unit>, ? extends java.lang.Object>> r11 = r10.f5014i
            if (r11 != 0) goto L_0x00ce
            r2 = r1
            r1 = r9
            r9 = r14
            r14 = r0
            r0 = r10
            goto L_0x00fe
        L_0x00ce:
            java.util.Iterator r11 = r11.iterator()
            r12 = r10
            r10 = r8
            r8 = r2
            r2 = r11
            r11 = r9
            r9 = r14
        L_0x00d8:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00f9
            java.lang.Object r14 = r2.next()
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r10
            r0.L$3 = r9
            r0.L$4 = r8
            r0.L$5 = r2
            r0.label = r4
            java.lang.Object r14 = r14.invoke(r8, r0)
            if (r14 != r1) goto L_0x00d8
            return r1
        L_0x00f9:
            r14 = r0
            r2 = r1
            r8 = r10
            r1 = r11
            r0 = r12
        L_0x00fe:
            r0.f5014i = r7
            r14.L$0 = r0
            r14.L$1 = r8
            r14.L$2 = r9
            r14.L$3 = r1
            r14.L$4 = r7
            r14.L$5 = r7
            r14.label = r3
            java.lang.Object r14 = r1.b(r7, r14)
            if (r14 != r2) goto L_0x0115
            return r2
        L_0x0115:
            r3 = r8
            r2 = r9
        L_0x0117:
            r2.element = r6     // Catch:{ all -> 0x0133 }
            kotlin.Unit r14 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0133 }
            r1.c(r7)
            kotlinx.coroutines.flow.i<androidx.datastore.core.j<T>> r14 = r0.f5013h
            androidx.datastore.core.b r0 = new androidx.datastore.core.b
            T r1 = r3.element
            if (r1 == 0) goto L_0x012a
            int r5 = r1.hashCode()
        L_0x012a:
            r0.<init>(r1, r5)
            r14.setValue(r0)
            kotlin.Unit r14 = kotlin.Unit.f32013a
            return r14
        L_0x0133:
            r14 = move-exception
            r1.c(r7)
            throw r14
        L_0x0138:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.t(kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            gk.g.b(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0045
        L_0x002d:
            r5 = move-exception
            goto L_0x004a
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            gk.g.b(r5)
            r0.L$0 = r4     // Catch:{ all -> 0x0048 }
            r0.label = r3     // Catch:{ all -> 0x0048 }
            java.lang.Object r5 = r4.t(r0)     // Catch:{ all -> 0x0048 }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            kotlin.Unit r5 = kotlin.Unit.f32013a
            return r5
        L_0x0048:
            r5 = move-exception
            r0 = r4
        L_0x004a:
            kotlinx.coroutines.flow.i<androidx.datastore.core.j<T>> r0 = r0.f5013h
            androidx.datastore.core.h r1 = new androidx.datastore.core.h
            r1.<init>(r5)
            r0.setValue(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.u(kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            gk.g.b(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0051
        L_0x002d:
            r5 = move-exception
            goto L_0x0047
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            gk.g.b(r5)
            r0.L$0 = r4     // Catch:{ all -> 0x0045 }
            r0.label = r3     // Catch:{ all -> 0x0045 }
            java.lang.Object r5 = r4.t(r0)     // Catch:{ all -> 0x0045 }
            if (r5 != r1) goto L_0x0051
            return r1
        L_0x0045:
            r5 = move-exception
            r0 = r4
        L_0x0047:
            kotlinx.coroutines.flow.i<androidx.datastore.core.j<T>> r0 = r0.f5013h
            androidx.datastore.core.h r1 = new androidx.datastore.core.h
            r1.<init>(r5)
            r0.setValue(r1)
        L_0x0051:
            kotlin.Unit r5 = kotlin.Unit.f32013a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.v(kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0064, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0069, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        kotlin.io.b.a(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006d, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:24:0x0060, B:30:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object w(kotlin.coroutines.c<? super T> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readData$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r1 = r0.L$2
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = r0.L$1
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            gk.g.b(r6)     // Catch:{ all -> 0x0035 }
            goto L_0x0060
        L_0x0035:
            r6 = move-exception
            goto L_0x0068
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003f:
            gk.g.b(r6)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006e }
            java.io.File r6 = r5.q()     // Catch:{ FileNotFoundException -> 0x006e }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x006e }
            r6 = 0
            androidx.datastore.core.i<T> r4 = r5.f5007b     // Catch:{ all -> 0x0066 }
            r0.L$0 = r5     // Catch:{ all -> 0x0066 }
            r0.L$1 = r2     // Catch:{ all -> 0x0066 }
            r0.L$2 = r6     // Catch:{ all -> 0x0066 }
            r0.label = r3     // Catch:{ all -> 0x0066 }
            java.lang.Object r0 = r4.b(r2, r0)     // Catch:{ all -> 0x0066 }
            if (r0 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r1 = r6
            r6 = r0
            r0 = r5
        L_0x0060:
            kotlin.io.b.a(r2, r1)     // Catch:{ FileNotFoundException -> 0x0064 }
            return r6
        L_0x0064:
            r6 = move-exception
            goto L_0x0070
        L_0x0066:
            r6 = move-exception
            r0 = r5
        L_0x0068:
            throw r6     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r1 = move-exception
            kotlin.io.b.a(r2, r6)     // Catch:{ FileNotFoundException -> 0x0064 }
            throw r1     // Catch:{ FileNotFoundException -> 0x0064 }
        L_0x006e:
            r6 = move-exception
            r0 = r5
        L_0x0070:
            java.io.File r1 = r0.q()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x0081
            androidx.datastore.core.i<T> r6 = r0.f5007b
            java.lang.Object r6 = r6.getDefaultValue()
            return r6
        L_0x0081:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.w(kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x(kotlin.coroutines.c<? super T> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r1 = r0.L$1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            gk.g.b(r8)     // Catch:{ IOException -> 0x0035 }
            goto L_0x0087
        L_0x0035:
            r8 = move-exception
            goto L_0x008a
        L_0x0037:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003f:
            java.lang.Object r2 = r0.L$1
            androidx.datastore.core.CorruptionException r2 = (androidx.datastore.core.CorruptionException) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            gk.g.b(r8)
            goto L_0x0079
        L_0x004b:
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            gk.g.b(r8)     // Catch:{ CorruptionException -> 0x0053 }
            goto L_0x0063
        L_0x0053:
            r8 = move-exception
            goto L_0x0066
        L_0x0055:
            gk.g.b(r8)
            r0.L$0 = r7     // Catch:{ CorruptionException -> 0x0064 }
            r0.label = r5     // Catch:{ CorruptionException -> 0x0064 }
            java.lang.Object r8 = r7.w(r0)     // Catch:{ CorruptionException -> 0x0064 }
            if (r8 != r1) goto L_0x0063
            return r1
        L_0x0063:
            return r8
        L_0x0064:
            r8 = move-exception
            r2 = r7
        L_0x0066:
            androidx.datastore.core.a<T> r5 = r2.f5008c
            r0.L$0 = r2
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r4 = r5.a(r8, r0)
            if (r4 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r6 = r2
            r2 = r8
            r8 = r4
            r4 = r6
        L_0x0079:
            r0.L$0 = r2     // Catch:{ IOException -> 0x0088 }
            r0.L$1 = r8     // Catch:{ IOException -> 0x0088 }
            r0.label = r3     // Catch:{ IOException -> 0x0088 }
            java.lang.Object r0 = r4.z(r8, r0)     // Catch:{ IOException -> 0x0088 }
            if (r0 != r1) goto L_0x0086
            return r1
        L_0x0086:
            r1 = r8
        L_0x0087:
            return r1
        L_0x0088:
            r8 = move-exception
            r0 = r2
        L_0x008a:
            gk.b.a(r0, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.x(kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object y(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.c<? super T>, ? extends java.lang.Object> r8, kotlin.coroutines.CoroutineContext r9, kotlin.coroutines.c<? super T> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = (androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r5) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            java.lang.Object r8 = r0.L$1
            java.lang.Object r9 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            gk.g.b(r10)
            goto L_0x008e
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            java.lang.Object r8 = r0.L$2
            java.lang.Object r9 = r0.L$1
            androidx.datastore.core.b r9 = (androidx.datastore.core.b) r9
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            gk.g.b(r10)
            goto L_0x0073
        L_0x0049:
            gk.g.b(r10)
            kotlinx.coroutines.flow.i<androidx.datastore.core.j<T>> r10 = r7.f5013h
            java.lang.Object r10 = r10.getValue()
            androidx.datastore.core.b r10 = (androidx.datastore.core.b) r10
            r10.a()
            java.lang.Object r2 = r10.b()
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1 r6 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1
            r6.<init>(r8, r2, r3)
            r0.L$0 = r7
            r0.L$1 = r10
            r0.L$2 = r2
            r0.label = r5
            java.lang.Object r8 = kotlinx.coroutines.h.g(r9, r6, r0)
            if (r8 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r9 = r10
            r10 = r8
            r8 = r2
            r2 = r7
        L_0x0073:
            r9.a()
            boolean r9 = kotlin.jvm.internal.j.b(r8, r10)
            if (r9 == 0) goto L_0x007d
            goto L_0x00a0
        L_0x007d:
            r0.L$0 = r2
            r0.L$1 = r10
            r0.L$2 = r3
            r0.label = r4
            java.lang.Object r8 = r2.z(r10, r0)
            if (r8 != r1) goto L_0x008c
            return r1
        L_0x008c:
            r8 = r10
            r9 = r2
        L_0x008e:
            kotlinx.coroutines.flow.i<androidx.datastore.core.j<T>> r9 = r9.f5013h
            androidx.datastore.core.b r10 = new androidx.datastore.core.b
            if (r8 == 0) goto L_0x0099
            int r0 = r8.hashCode()
            goto L_0x009a
        L_0x0099:
            r0 = 0
        L_0x009a:
            r10.<init>(r8, r0)
            r9.setValue(r10)
        L_0x00a0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.y(kotlin.jvm.functions.Function2, kotlin.coroutines.CoroutineContext, kotlin.coroutines.c):java.lang.Object");
    }

    public Object a(Function2<? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> function2, kotlin.coroutines.c<? super T> cVar) {
        w b10 = y.b((s1) null, 1, (Object) null);
        this.f5015j.e(new b.C0050b(function2, b10, this.f5013h.getValue(), cVar.getContext()));
        return b10.v(cVar);
    }

    public kotlinx.coroutines.flow.b<T> getData() {
        return this.f5010e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c1, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        kotlin.io.b.a(r2, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c5, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c6, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c7, code lost:
        r9 = r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:26:0x0092, B:36:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2 A[SYNTHETIC, Splitter:B:31:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z(T r8, kotlin.coroutines.c<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.SingleProcessDataStore$writeData$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$writeData$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r8 = r0.L$4
            java.io.FileOutputStream r8 = (java.io.FileOutputStream) r8
            java.lang.Object r1 = r0.L$3
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = r0.L$2
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r3 = r0.L$1
            java.io.File r3 = (java.io.File) r3
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            gk.g.b(r9)     // Catch:{ all -> 0x003d }
            goto L_0x0089
        L_0x003d:
            r8 = move-exception
            goto L_0x00c0
        L_0x0040:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0048:
            gk.g.b(r9)
            java.io.File r9 = r7.q()
            r7.p(r9)
            java.io.File r9 = new java.io.File
            java.io.File r2 = r7.q()
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r4 = r7.f5011f
            java.lang.String r2 = kotlin.jvm.internal.j.p(r2, r4)
            r9.<init>(r2)
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c9 }
            r2.<init>(r9)     // Catch:{ IOException -> 0x00c9 }
            r4 = 0
            androidx.datastore.core.i<T> r5 = r7.f5007b     // Catch:{ all -> 0x00be }
            androidx.datastore.core.SingleProcessDataStore$c r6 = new androidx.datastore.core.SingleProcessDataStore$c     // Catch:{ all -> 0x00be }
            r6.<init>(r2)     // Catch:{ all -> 0x00be }
            r0.L$0 = r7     // Catch:{ all -> 0x00be }
            r0.L$1 = r9     // Catch:{ all -> 0x00be }
            r0.L$2 = r2     // Catch:{ all -> 0x00be }
            r0.L$3 = r4     // Catch:{ all -> 0x00be }
            r0.L$4 = r2     // Catch:{ all -> 0x00be }
            r0.label = r3     // Catch:{ all -> 0x00be }
            java.lang.Object r8 = r5.a(r8, r6, r0)     // Catch:{ all -> 0x00be }
            if (r8 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r0 = r7
            r3 = r9
            r8 = r2
            r1 = r4
        L_0x0089:
            java.io.FileDescriptor r8 = r8.getFD()     // Catch:{ all -> 0x003d }
            r8.sync()     // Catch:{ all -> 0x003d }
            kotlin.Unit r8 = kotlin.Unit.f32013a     // Catch:{ all -> 0x003d }
            kotlin.io.b.a(r2, r1)     // Catch:{ IOException -> 0x00c6 }
            java.io.File r8 = r0.q()     // Catch:{ IOException -> 0x00c6 }
            boolean r8 = r3.renameTo(r8)     // Catch:{ IOException -> 0x00c6 }
            if (r8 == 0) goto L_0x00a2
            kotlin.Unit r8 = kotlin.Unit.f32013a
            return r8
        L_0x00a2:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ IOException -> 0x00c6 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c6 }
            r9.<init>()     // Catch:{ IOException -> 0x00c6 }
            java.lang.String r0 = "Unable to rename "
            r9.append(r0)     // Catch:{ IOException -> 0x00c6 }
            r9.append(r3)     // Catch:{ IOException -> 0x00c6 }
            java.lang.String r0 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r9.append(r0)     // Catch:{ IOException -> 0x00c6 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x00c6 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x00c6 }
            throw r8     // Catch:{ IOException -> 0x00c6 }
        L_0x00be:
            r8 = move-exception
            r3 = r9
        L_0x00c0:
            throw r8     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r9 = move-exception
            kotlin.io.b.a(r2, r8)     // Catch:{ IOException -> 0x00c6 }
            throw r9     // Catch:{ IOException -> 0x00c6 }
        L_0x00c6:
            r8 = move-exception
            r9 = r3
            goto L_0x00ca
        L_0x00c9:
            r8 = move-exception
        L_0x00ca:
            boolean r0 = r9.exists()
            if (r0 == 0) goto L_0x00d3
            r9.delete()
        L_0x00d3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.z(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
