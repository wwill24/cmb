package com.withpersona.sdk2.inquiry.permissions;

import c.a;
import com.withpersona.sdk2.inquiry.launchers.t;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorker;
import gk.g;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorker$run$1", f = "PermissionRequestWorker.kt", l = {31, 35}, m = "invokeSuspend")
final class PermissionRequestWorker$run$1 extends SuspendLambda implements Function2<c<? super PermissionRequestWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PermissionRequestWorker this$0;

    static final class a<T> implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c<PermissionRequestWorker.b> f27117a;

        a(c<? super PermissionRequestWorker.b> cVar) {
            this.f27117a = cVar;
        }

        public final Object a(boolean z10, kotlin.coroutines.c<? super Unit> cVar) {
            if (z10) {
                Object c10 = this.f27117a.c(PermissionRequestWorker.b.C0322b.f27116a, cVar);
                if (c10 == b.d()) {
                    return c10;
                }
                return Unit.f32013a;
            }
            Object c11 = this.f27117a.c(PermissionRequestWorker.b.a.f27115a, cVar);
            if (c11 == b.d()) {
                return c11;
            }
            return Unit.f32013a;
        }

        public /* bridge */ /* synthetic */ Object c(Object obj, kotlin.coroutines.c cVar) {
            return a(((Boolean) obj).booleanValue(), cVar);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionRequestWorker$run$1(PermissionRequestWorker permissionRequestWorker, kotlin.coroutines.c<? super PermissionRequestWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = permissionRequestWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        PermissionRequestWorker$run$1 permissionRequestWorker$run$1 = new PermissionRequestWorker$run$1(this.this$0, cVar);
        permissionRequestWorker$run$1.L$0 = obj;
        return permissionRequestWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super PermissionRequestWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((PermissionRequestWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            c cVar = (c) this.L$0;
            a.C0091a synchronousResult = this.this$0.f27110b.a().getSynchronousResult(this.this$0.f27111c, a.a(this.this$0.f27112d));
            if (synchronousResult != null) {
                obj2 = synchronousResult.a();
            } else {
                obj2 = null;
            }
            if (j.b(obj2, kotlin.coroutines.jvm.internal.a.a(true))) {
                PermissionRequestWorker.b.C0322b bVar = PermissionRequestWorker.b.C0322b.f27116a;
                this.label = 1;
                if (cVar.c(bVar, this) == d10) {
                    return d10;
                }
            } else {
                this.this$0.f27110b.b(a.a(this.this$0.f27112d));
                t tVar = new t();
                a aVar = new a(cVar);
                this.label = 2;
                if (tVar.a(aVar, this) == d10) {
                    return d10;
                }
                throw new KotlinNothingValueException();
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else if (i10 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            g.b(obj);
            throw new KotlinNothingValueException();
        }
        return Unit.f32013a;
    }
}
