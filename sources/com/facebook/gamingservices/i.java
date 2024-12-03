package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;

public final /* synthetic */ class i implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TournamentShareDialog f37838a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResultProcessor f37839b;

    public /* synthetic */ i(TournamentShareDialog tournamentShareDialog, ResultProcessor resultProcessor) {
        this.f37838a = tournamentShareDialog;
        this.f37839b = resultProcessor;
    }

    public final boolean onActivityResult(int i10, Intent intent) {
        return TournamentShareDialog.m109registerCallbackImpl$lambda0(this.f37838a, this.f37839b, i10, intent);
    }
}
