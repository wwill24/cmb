package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;
import pe.a;

public final class zzca extends zzbm implements zzcc {
    zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String str, long j10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j10);
        zzc(23, zza);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, bundle);
        zzc(9, zza);
    }

    public final void clearMeasurementEnabled(long j10) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j10);
        zzc(43, zza);
    }

    public final void endAdUnitExposure(String str, long j10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j10);
        zzc(24, zza);
    }

    public final void generateEventId(zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcf);
        zzc(22, zza);
    }

    public final void getAppInstanceId(zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcf);
        zzc(20, zza);
    }

    public final void getCachedAppInstanceId(zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcf);
        zzc(19, zza);
    }

    public final void getConditionalUserProperties(String str, String str2, zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, zzcf);
        zzc(10, zza);
    }

    public final void getCurrentScreenClass(zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcf);
        zzc(17, zza);
    }

    public final void getCurrentScreenName(zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcf);
        zzc(16, zza);
    }

    public final void getGmpAppId(zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcf);
        zzc(21, zza);
    }

    public final void getMaxUserProperties(String str, zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbo.zze(zza, zzcf);
        zzc(6, zza);
    }

    public final void getSessionId(zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcf);
        zzc(46, zza);
    }

    public final void getTestFlag(zzcf zzcf, int i10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcf);
        zza.writeInt(i10);
        zzc(38, zza);
    }

    public final void getUserProperties(String str, String str2, boolean z10, zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        int i10 = zzbo.zza;
        zza.writeInt(z10 ? 1 : 0);
        zzbo.zze(zza, zzcf);
        zzc(5, zza);
    }

    public final void initForTests(Map map) throws RemoteException {
        throw null;
    }

    public final void initialize(a aVar, zzcl zzcl, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zzbo.zzd(zza, zzcl);
        zza.writeLong(j10);
        zzc(1, zza);
    }

    public final void isDataCollectionEnabled(zzcf zzcf) throws RemoteException {
        throw null;
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, bundle);
        zza.writeInt(z10 ? 1 : 0);
        zza.writeInt(z11 ? 1 : 0);
        zza.writeLong(j10);
        zzc(2, zza);
    }

    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcf, long j10) throws RemoteException {
        throw null;
    }

    public final void logHealthData(int i10, String str, a aVar, a aVar2, a aVar3) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zzbo.zze(zza, aVar);
        zzbo.zze(zza, aVar2);
        zzbo.zze(zza, aVar3);
        zzc(33, zza);
    }

    public final void onActivityCreated(a aVar, Bundle bundle, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zzbo.zzd(zza, bundle);
        zza.writeLong(j10);
        zzc(27, zza);
    }

    public final void onActivityDestroyed(a aVar, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeLong(j10);
        zzc(28, zza);
    }

    public final void onActivityPaused(a aVar, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeLong(j10);
        zzc(29, zza);
    }

    public final void onActivityResumed(a aVar, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeLong(j10);
        zzc(30, zza);
    }

    public final void onActivitySaveInstanceState(a aVar, zzcf zzcf, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zzbo.zze(zza, zzcf);
        zza.writeLong(j10);
        zzc(31, zza);
    }

    public final void onActivityStarted(a aVar, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeLong(j10);
        zzc(25, zza);
    }

    public final void onActivityStopped(a aVar, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeLong(j10);
        zzc(26, zza);
    }

    public final void performAction(Bundle bundle, zzcf zzcf, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zzbo.zze(zza, zzcf);
        zza.writeLong(j10);
        zzc(32, zza);
    }

    public final void registerOnMeasurementEventListener(zzci zzci) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzci);
        zzc(35, zza);
    }

    public final void resetAnalyticsData(long j10) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j10);
        zzc(12, zza);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zza.writeLong(j10);
        zzc(8, zza);
    }

    public final void setConsent(Bundle bundle, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zza.writeLong(j10);
        zzc(44, zza);
    }

    public final void setConsentThirdParty(Bundle bundle, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zza.writeLong(j10);
        zzc(45, zza);
    }

    public final void setCurrentScreen(a aVar, String str, String str2, long j10) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, aVar);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j10);
        zzc(15, zza);
    }

    public final void setDataCollectionEnabled(boolean z10) throws RemoteException {
        Parcel zza = zza();
        int i10 = zzbo.zza;
        zza.writeInt(z10 ? 1 : 0);
        zzc(39, zza);
    }

    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zzc(42, zza);
    }

    public final void setEventInterceptor(zzci zzci) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzci);
        zzc(34, zza);
    }

    public final void setInstanceIdProvider(zzck zzck) throws RemoteException {
        throw null;
    }

    public final void setMeasurementEnabled(boolean z10, long j10) throws RemoteException {
        Parcel zza = zza();
        int i10 = zzbo.zza;
        zza.writeInt(z10 ? 1 : 0);
        zza.writeLong(j10);
        zzc(11, zza);
    }

    public final void setMinimumSessionDuration(long j10) throws RemoteException {
        throw null;
    }

    public final void setSessionTimeoutDuration(long j10) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j10);
        zzc(14, zza);
    }

    public final void setUserId(String str, long j10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j10);
        zzc(7, zza);
    }

    public final void setUserProperty(String str, String str2, a aVar, boolean z10, long j10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, aVar);
        zza.writeInt(z10 ? 1 : 0);
        zza.writeLong(j10);
        zzc(4, zza);
    }

    public final void unregisterOnMeasurementEventListener(zzci zzci) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzci);
        zzc(36, zza);
    }
}
