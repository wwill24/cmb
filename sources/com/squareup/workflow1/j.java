package com.squareup.workflow1;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.l;
import wk.m;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \u0007*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0007J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&J\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016¨\u0006\b"}, d2 = {"Lcom/squareup/workflow1/j;", "OutputT", "", "Lkotlinx/coroutines/flow/b;", "run", "otherWorker", "", "a", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
public interface j<OutputT> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23138a = a.f23139a;

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\u000e\u001a\u00020\t8\u0002X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/squareup/workflow1/j$a;", "", "", "delayMs", "", "key", "Lcom/squareup/workflow1/j;", "", "a", "Lwk/m;", "b", "Lwk/m;", "getTYPE_OF_NOTHING$annotations", "()V", "TYPE_OF_NOTHING", "<init>", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f23139a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final m f23140b = l.k(Void.class);

        private a() {
        }

        public static /* synthetic */ j b(a aVar, long j10, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = "";
            }
            return aVar.a(j10, str);
        }

        public final j<Unit> a(long j10, String str) {
            kotlin.jvm.internal.j.g(str, SDKConstants.PARAM_KEY);
            return new TimerWorker(j10, str);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        public static <OutputT> boolean a(j<? extends OutputT> jVar, j<?> jVar2) {
            kotlin.jvm.internal.j.g(jVar, "this");
            kotlin.jvm.internal.j.g(jVar2, "otherWorker");
            return kotlin.jvm.internal.j.b(l.b(jVar2.getClass()), l.b(jVar.getClass()));
        }
    }

    boolean a(j<?> jVar);

    kotlinx.coroutines.flow.b<OutputT> run();
}
