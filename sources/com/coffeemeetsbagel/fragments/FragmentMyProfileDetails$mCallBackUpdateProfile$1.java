package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.uber.autodispose.a;
import com.uber.autodispose.t;
import jc.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;

public final class FragmentMyProfileDetails$mCallBackUpdateProfile$1 implements b<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FragmentMyProfileDetails f13576a;

    FragmentMyProfileDetails$mCallBackUpdateProfile$1(FragmentMyProfileDetails fragmentMyProfileDetails) {
        this.f13576a = fragmentMyProfileDetails;
    }

    /* access modifiers changed from: private */
    public static final b0 f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public void b(CmbErrorCode cmbErrorCode) {
    }

    /* renamed from: e */
    public void a(Void voidR, SuccessStatus successStatus) {
        NetworkProfile j10 = Bakery.w().G().j();
        j.d(j10);
        ((t) this.f13576a.v3().e(p.e(j10)).v(new f4(new FragmentMyProfileDetails$mCallBackUpdateProfile$1$onReceiveSuccess$1(this.f13576a, j10))).g(a.a(this.f13576a))).c(new g4(FragmentMyProfileDetails$mCallBackUpdateProfile$1$onReceiveSuccess$2.f13577a));
    }
}
