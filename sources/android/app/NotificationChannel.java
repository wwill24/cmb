package android.app;

import android.os.Parcelable;

public final /* synthetic */ class NotificationChannel implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    public /* synthetic */ NotificationChannel(String str, CharSequence charSequence, int i10) {
    }

    public native /* synthetic */ void enableLights(boolean z10);

    public native /* synthetic */ void enableVibration(boolean z10);

    public native /* synthetic */ int getImportance();

    public native /* synthetic */ CharSequence getName();

    public native /* synthetic */ void setBypassDnd(boolean z10);

    public native /* synthetic */ void setDescription(String str);

    public native /* synthetic */ void setGroup(String str);

    public native /* synthetic */ void setLightColor(int i10);

    public native /* synthetic */ void setLockscreenVisibility(int i10);

    public native /* synthetic */ void setName(CharSequence charSequence);

    public native /* synthetic */ void setShowBadge(boolean z10);

    public native /* synthetic */ void setVibrationPattern(long[] jArr);
}
