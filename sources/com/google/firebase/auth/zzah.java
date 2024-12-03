package com.google.firebase.auth;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;

public final /* synthetic */ class zzah implements ComponentFactory {
    public final /* synthetic */ Qualified zza;
    public final /* synthetic */ Qualified zzb;
    public final /* synthetic */ Qualified zzc;
    public final /* synthetic */ Qualified zzd;
    public final /* synthetic */ Qualified zze;

    public /* synthetic */ zzah(Qualified qualified, Qualified qualified2, Qualified qualified3, Qualified qualified4, Qualified qualified5) {
        this.zza = qualified;
        this.zzb = qualified2;
        this.zzc = qualified3;
        this.zzd = qualified4;
        this.zze = qualified5;
    }

    public final Object create(ComponentContainer componentContainer) {
        return FirebaseAuthRegistrar.lambda$getComponents$0(this.zza, this.zzb, this.zzc, this.zzd, this.zze, componentContainer);
    }
}
