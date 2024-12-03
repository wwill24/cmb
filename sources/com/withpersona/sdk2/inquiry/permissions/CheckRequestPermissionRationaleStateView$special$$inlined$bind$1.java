package com.withpersona.sdk2.inquiry.permissions;

import android.content.Context;
import androidx.appcompat.app.c;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.inquiry.permissions.CheckRequestPermissionRationaleStateView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class CheckRequestPermissionRationaleStateView$special$$inlined$bind$1 extends Lambda implements Function1<pi.a, f<CheckRequestPermissionRationaleStateView>> {
    final /* synthetic */ CheckRequestPermissionRationaleStateView this$0;

    public static final class a<RenderingT> implements f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z1.a f27100b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CheckRequestPermissionRationaleStateView f27101c;

        public a(z1.a aVar, CheckRequestPermissionRationaleStateView checkRequestPermissionRationaleStateView) {
            this.f27100b = aVar;
            this.f27101c = checkRequestPermissionRationaleStateView;
        }

        public final void a(RenderingT renderingt, p pVar) {
            j.g(renderingt, "rendering");
            j.g(pVar, "viewEnvironment");
            CheckRequestPermissionRationaleStateView checkRequestPermissionRationaleStateView = (CheckRequestPermissionRationaleStateView) renderingt;
            pi.a aVar = (pi.a) this.f27100b;
            Context context = aVar.getRoot().getContext();
            j.f(context, "root.context");
            c e10 = ti.a.e(context);
            if (checkRequestPermissionRationaleStateView.f27098b != null) {
                aVar.getRoot().post(new CheckRequestPermissionRationaleStateView.a(aVar, this.f27101c, checkRequestPermissionRationaleStateView, e10));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckRequestPermissionRationaleStateView$special$$inlined$bind$1(CheckRequestPermissionRationaleStateView checkRequestPermissionRationaleStateView) {
        super(1);
        this.this$0 = checkRequestPermissionRationaleStateView;
    }

    /* renamed from: a */
    public final f<CheckRequestPermissionRationaleStateView> invoke(pi.a aVar) {
        j.g(aVar, "binding");
        return new a(aVar, this.this$0);
    }
}
