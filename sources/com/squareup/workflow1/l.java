package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0007*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u00012\u00020\u0004:\u0002\n\u000bB\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u0007\u001a\u00020\u0006*\u00180\u0005R\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000H&¨\u0006\f"}, d2 = {"Lcom/squareup/workflow1/l;", "PropsT", "StateT", "OutputT", "", "Lcom/squareup/workflow1/l$c;", "", "a", "<init>", "()V", "b", "c", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
public abstract class l<PropsT, StateT, OutputT> {

    /* renamed from: a  reason: collision with root package name */
    public static final b f23141a = new b((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private static final a f23142b = new a();

    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J(\u0010\u0007\u001a\u00020\u0006*\u001e0\u0005R\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0016¨\u0006\b"}, d2 = {"com/squareup/workflow1/l$a", "Lcom/squareup/workflow1/l;", "", "", "toString", "Lcom/squareup/workflow1/l$c;", "", "a", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
    public static final class a extends l<Object, Object, Object> {
        a() {
        }

        public void a(l<Object, Object, ? extends Object>.c cVar) {
            j.g(cVar, "<this>");
        }

        public String toString() {
            return "WorkflowAction.noAction()";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/squareup/workflow1/l$b;", "", "com/squareup/workflow1/l$a", "NO_ACTION", "Lcom/squareup/workflow1/l$a;", "<init>", "()V", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00028\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\r\u001a\u00028\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0007\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\u0005R4\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000e8\u0000@BX\u000e¢\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0006\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/squareup/workflow1/l$c;", "", "output", "", "d", "(Ljava/lang/Object;)V", "a", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "props", "c", "e", "state", "Lcom/squareup/workflow1/n;", "<set-?>", "Lcom/squareup/workflow1/n;", "()Lcom/squareup/workflow1/n;", "maybeOutput", "<init>", "(Lcom/squareup/workflow1/l;Ljava/lang/Object;Ljava/lang/Object;)V", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        private final PropsT f23143a;

        /* renamed from: b  reason: collision with root package name */
        private StateT f23144b;

        /* renamed from: c  reason: collision with root package name */
        private n<? extends OutputT> f23145c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ l<PropsT, StateT, OutputT> f23146d;

        public c(l lVar, PropsT propst, StateT statet) {
            j.g(lVar, "this$0");
            this.f23146d = lVar;
            this.f23143a = propst;
            this.f23144b = statet;
        }

        public final n<OutputT> a() {
            return this.f23145c;
        }

        public final PropsT b() {
            return this.f23143a;
        }

        public final StateT c() {
            return this.f23144b;
        }

        public final void d(OutputT outputt) {
            this.f23145c = new n<>(outputt);
        }

        public final void e(StateT statet) {
            this.f23144b = statet;
        }
    }

    public abstract void a(l<? super PropsT, StateT, ? extends OutputT>.c cVar);
}
