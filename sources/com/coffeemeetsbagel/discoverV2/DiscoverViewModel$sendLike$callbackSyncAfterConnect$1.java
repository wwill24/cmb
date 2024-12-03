package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.profile.o;
import com.coffeemeetsbagel.transport.SuccessStatus;
import fa.a;
import java.util.List;
import java.util.stream.Collectors;
import jc.b;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class DiscoverViewModel$sendLike$callbackSyncAfterConnect$1 implements b<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DiscoverViewModel f12276a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f12277b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ RisingGiveTake f12278c;

    DiscoverViewModel$sendLike$callbackSyncAfterConnect$1(DiscoverViewModel discoverViewModel, String str, RisingGiveTake risingGiveTake) {
        this.f12276a = discoverViewModel;
        this.f12277b = str;
        this.f12278c = risingGiveTake;
    }

    /* access modifiers changed from: private */
    public static final NetworkPhoto e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (NetworkPhoto) function1.invoke(obj);
    }

    public void b(CmbErrorCode cmbErrorCode) {
        j.g(cmbErrorCode, "cmbErrorCode");
        a.C0491a aVar = a.f40771d;
        String m10 = this.f12276a.f12227s;
        String errorMessage = cmbErrorCode.getErrorMessage();
        aVar.a(m10, "errorCode=" + errorMessage);
        this.f12276a.H0(DiscoverViewModel.ProgressDialogViewState.GONE);
    }

    /* renamed from: d */
    public void a(Void voidR, SuccessStatus successStatus) {
        j.g(successStatus, "status");
        Bagel bagel = (Bagel) this.f12276a.N().a(Extra.BAGEL, h6.b.c(), Extra.PROFILE_ID, this.f12277b);
        if (bagel == null) {
            a.C0491a aVar = a.f40771d;
            String m10 = this.f12276a.f12227s;
            String str = this.f12277b;
            aVar.b(m10, "No bagel was received/created as a result of connecting with a rising giveTake and syncing.Used profile id " + str);
            this.f12276a.J0(R.string.error_sending_discover_like);
            this.f12276a.H0(DiscoverViewModel.ProgressDialogViewState.GONE);
            return;
        }
        this.f12276a.U().l();
        ProfileRepositoryV2 Z = this.f12276a.Z();
        String str2 = this.f12277b;
        j.f(str2, "profileId");
        Pair h10 = Z.n(str2).h();
        NetworkProfile a10 = o.f36130a.a((l) h10.a());
        a10.setPhotos((List) ((List) h10.b()).stream().map(new j(DiscoverViewModel$sendLike$callbackSyncAfterConnect$1$onReceiveSuccess$networkPhotos$1.f12279a)).collect(Collectors.toList()));
        bagel.setProfile(a10);
        this.f12276a.H0(DiscoverViewModel.ProgressDialogViewState.GONE);
        this.f12276a.G.m(new Pair(this.f12278c, bagel));
    }
}
