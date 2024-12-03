package com.mparticle.messaging;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.app.p;
import com.mparticle.MPService;
import com.mparticle.internal.b;
import org.json.JSONException;

public class ProviderCloudMessage implements Parcelable {
    public static final Parcelable.Creator<ProviderCloudMessage> CREATOR = new a();
    public static final int FLAG_DIRECT_OPEN = 2;
    public static final int FLAG_DISPLAYED = 16;
    public static final int FLAG_INFLUENCE_OPEN = 8;
    public static final int FLAG_READ = 4;
    public static final int FLAG_RECEIVED = 1;
    private long mActualDeliveryTime = 0;
    private boolean mDisplayed;
    protected Bundle mExtras;
    private final String mPrimaryText;

    class a implements Parcelable.Creator<ProviderCloudMessage> {
        a() {
        }

        /* renamed from: a */
        public ProviderCloudMessage createFromParcel(Parcel parcel) {
            return new ProviderCloudMessage(parcel);
        }

        /* renamed from: a */
        public ProviderCloudMessage[] newArray(int i10) {
            return new ProviderCloudMessage[i10];
        }
    }

    public ProviderCloudMessage(Bundle bundle, org.json.a aVar) {
        if (bundle != null) {
            this.mExtras = new Bundle(bundle);
        }
        this.mPrimaryText = findProviderMessage(aVar);
    }

    @NonNull
    public static ProviderCloudMessage createMessage(@NonNull Intent intent, org.json.a aVar) {
        return new ProviderCloudMessage(intent.getExtras(), aVar);
    }

    private String findProviderMessage(org.json.a aVar) {
        if (aVar == null) {
            return "";
        }
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            try {
                String string = this.mExtras.getString(aVar.n(i10));
                if (string != null && string.length() > 0) {
                    this.mExtras.remove(aVar.n(i10));
                    return string;
                }
            } catch (JSONException unused) {
            }
        }
        return "";
    }

    protected static int getFallbackIcon(@NonNull Context context) {
        int d10 = b.d(context);
        try {
            context.getResources().getDrawable(d10);
        } catch (Resources.NotFoundException unused) {
            d10 = 0;
        }
        if (d10 != 0) {
            return d10;
        }
        try {
            d10 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).icon;
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        if (d10 == 0) {
            return context.getResources().getIdentifier("ic_dialog_alert", "drawable", "android");
        }
        return d10;
    }

    protected static String getFallbackTitle(@NonNull Context context) {
        int f10 = b.f(context);
        if (f10 > 0) {
            try {
                return context.getString(f10);
            } catch (Resources.NotFoundException unused) {
                return null;
            }
        } else {
            return context.getResources().getString(context.getApplicationInfo().labelRes);
        }
    }

    protected static PendingIntent getLoopbackIntent(Context context, ProviderCloudMessage providerCloudMessage, String str) {
        Intent intent = new Intent("com.mparticle.push.notification_tapped");
        intent.setClass(context, MPService.class);
        intent.putExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA, providerCloudMessage);
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getService(context, str.hashCode(), intent, 33554432);
        }
        return PendingIntent.getService(context, str.hashCode(), intent, 134217728);
    }

    private boolean oreoNotificationCompatAvailable() {
        try {
            p.e.class.getMethod("h", new Class[]{String.class});
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    @NonNull
    public Notification buildNotification(@NonNull Context context, long j10) {
        setActualDeliveryTime(j10);
        return buildNotification(context);
    }

    public int describeContents() {
        return 0;
    }

    public long getActualDeliveryTime() {
        return this.mActualDeliveryTime;
    }

    @NonNull
    public Intent getDefaultOpenIntent(Context context, ProviderCloudMessage providerCloudMessage) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        launchIntentForPackage.putExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA, providerCloudMessage);
        return launchIntentForPackage;
    }

    public boolean getDisplayed() {
        return this.mDisplayed;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    @NonNull
    public int getId() {
        return this.mPrimaryText.hashCode();
    }

    @NonNull
    public String getPrimaryMessage(@NonNull Context context) {
        return this.mPrimaryText;
    }

    @NonNull
    public org.json.b getRedactedJsonPayload() {
        org.json.b bVar = new org.json.b();
        for (String next : this.mExtras.keySet()) {
            try {
                bVar.put(next, org.json.b.wrap(this.mExtras.get(next)));
            } catch (JSONException unused) {
            }
        }
        return bVar;
    }

    public void setActualDeliveryTime(long j10) {
        this.mActualDeliveryTime = j10;
    }

    public void setDisplayed(boolean z10) {
        this.mDisplayed = z10;
    }

    public boolean shouldDisplay() {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.mExtras);
        parcel.writeLong(this.mActualDeliveryTime);
        parcel.writeInt(this.mDisplayed ? 1 : 0);
        parcel.writeString(this.mPrimaryText);
    }

    @NonNull
    public Notification buildNotification(@NonNull Context context) {
        p.e eVar;
        if (oreoNotificationCompatAvailable()) {
            eVar = new p.e(context, "com.mparticle.default");
        } else {
            eVar = new p.e(context);
        }
        Notification b10 = eVar.k(getLoopbackIntent(context, this, String.valueOf(getId()))).x(getFallbackIcon(context)).B(this.mPrimaryText).m(getFallbackTitle(context)).l(this.mPrimaryText).b();
        b10.flags |= 16;
        return b10;
    }

    public ProviderCloudMessage(@NonNull Parcel parcel) {
        this.mExtras = parcel.readBundle();
        this.mActualDeliveryTime = parcel.readLong();
        this.mDisplayed = parcel.readInt() != 1 ? false : true;
        this.mPrimaryText = parcel.readString();
    }
}
