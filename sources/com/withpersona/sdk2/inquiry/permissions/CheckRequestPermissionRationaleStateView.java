package com.withpersona.sdk2.inquiry.permissions;

import androidx.appcompat.app.c;
import androidx.core.app.b;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import org.apache.commons.beanutils.PropertyUtils;

public final class CheckRequestPermissionRationaleStateView implements com.squareup.workflow1.ui.a<CheckRequestPermissionRationaleStateView> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Permission f27097a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Function1<Boolean, Unit> f27098b;

    /* renamed from: c  reason: collision with root package name */
    private final r<CheckRequestPermissionRationaleStateView> f27099c = new ViewBindingViewFactory(l.b(CheckRequestPermissionRationaleStateView.class), CheckRequestPermissionRationaleStateView$viewFactory$1.f27106a, new CheckRequestPermissionRationaleStateView$special$$inlined$bind$1(this));

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ pi.a f27102a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckRequestPermissionRationaleStateView f27103b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CheckRequestPermissionRationaleStateView f27104c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f27105d;

        a(pi.a aVar, CheckRequestPermissionRationaleStateView checkRequestPermissionRationaleStateView, CheckRequestPermissionRationaleStateView checkRequestPermissionRationaleStateView2, c cVar) {
            this.f27102a = aVar;
            this.f27103b = checkRequestPermissionRationaleStateView;
            this.f27104c = checkRequestPermissionRationaleStateView2;
            this.f27105d = cVar;
        }

        public final void run() {
            if (this.f27102a.getRoot().isAttachedToWindow()) {
                if (this.f27103b.f27097a == Permission.RecordAudio) {
                    this.f27104c.f27098b.invoke(Boolean.TRUE);
                } else {
                    this.f27104c.f27098b.invoke(Boolean.valueOf(b.j(this.f27105d, a.a(this.f27104c.f27097a))));
                }
            }
        }
    }

    public CheckRequestPermissionRationaleStateView(Permission permission, Function1<? super Boolean, Unit> function1) {
        j.g(permission, "permission");
        this.f27097a = permission;
        this.f27098b = function1;
        f.a aVar = f.f23238a;
    }

    public r<CheckRequestPermissionRationaleStateView> a() {
        return this.f27099c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckRequestPermissionRationaleStateView)) {
            return false;
        }
        CheckRequestPermissionRationaleStateView checkRequestPermissionRationaleStateView = (CheckRequestPermissionRationaleStateView) obj;
        return this.f27097a == checkRequestPermissionRationaleStateView.f27097a && j.b(this.f27098b, checkRequestPermissionRationaleStateView.f27098b);
    }

    public int hashCode() {
        int hashCode = this.f27097a.hashCode() * 31;
        Function1<Boolean, Unit> function1 = this.f27098b;
        return hashCode + (function1 == null ? 0 : function1.hashCode());
    }

    public String toString() {
        return "CheckRequestPermissionRationaleStateView(permission=" + this.f27097a + ", callback=" + this.f27098b + PropertyUtils.MAPPED_DELIM2;
    }
}
