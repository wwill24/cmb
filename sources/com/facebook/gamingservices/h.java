package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;

public final /* synthetic */ class h implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TournamentJoinDialog f37836a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResultProcessor f37837b;

    public /* synthetic */ h(TournamentJoinDialog tournamentJoinDialog, ResultProcessor resultProcessor) {
        this.f37836a = tournamentJoinDialog;
        this.f37837b = resultProcessor;
    }

    public final boolean onActivityResult(int i10, Intent intent) {
        return TournamentJoinDialog.m108registerCallbackImpl$lambda0(this.f37836a, this.f37837b, i10, intent);
    }
}
