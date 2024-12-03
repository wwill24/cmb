package com.withpersona.sdk2.inquiry.governmentid.live_hint;

import com.withpersona.sdk2.camera.GovernmentIdFeed;
import com.withpersona.sdk2.camera.ParsedIdSideOrNone;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker;
import gk.g;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$run$hintFlow$1", f = "GovernmentIdHintWorker.kt", l = {75}, m = "invokeSuspend")
final class GovernmentIdHintWorker$run$hintFlow$1 extends SuspendLambda implements Function2<c<? super GovernmentIdHintWorker.c>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GovernmentIdHintWorker this$0;

    static final class a<T> implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c<GovernmentIdHintWorker.c> f25795a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GovernmentIdHintWorker f25796b;

        a(c<? super GovernmentIdHintWorker.c> cVar, GovernmentIdHintWorker governmentIdHintWorker) {
            this.f25795a = cVar;
            this.f25796b = governmentIdHintWorker;
        }

        public final Object c(Object obj, kotlin.coroutines.c<? super Unit> cVar) {
            Object j10 = ((Result) obj).j();
            c<GovernmentIdHintWorker.c> cVar2 = this.f25795a;
            GovernmentIdHintWorker governmentIdHintWorker = this.f25796b;
            if (Result.e(j10) == null) {
                Object c10 = cVar2.c(governmentIdHintWorker.d((ParsedIdSideOrNone) j10), cVar);
                if (c10 == b.d()) {
                    return c10;
                }
            } else {
                Object c11 = cVar2.c(null, cVar);
                if (c11 == b.d()) {
                    return c11;
                }
            }
            return Unit.f32013a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdHintWorker$run$hintFlow$1(GovernmentIdHintWorker governmentIdHintWorker, kotlin.coroutines.c<? super GovernmentIdHintWorker$run$hintFlow$1> cVar) {
        super(2, cVar);
        this.this$0 = governmentIdHintWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        GovernmentIdHintWorker$run$hintFlow$1 governmentIdHintWorker$run$hintFlow$1 = new GovernmentIdHintWorker$run$hintFlow$1(this.this$0, cVar);
        governmentIdHintWorker$run$hintFlow$1.L$0 = obj;
        return governmentIdHintWorker$run$hintFlow$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super GovernmentIdHintWorker.c> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((GovernmentIdHintWorker$run$hintFlow$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            GovernmentIdFeed b10 = this.this$0.f25789e;
            a aVar = new a((c) this.L$0, this.this$0);
            this.label = 1;
            if (b10.a(aVar, this) == d10) {
                return d10;
            }
        } else if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            g.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
