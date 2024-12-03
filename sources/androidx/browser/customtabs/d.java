package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.a;
import androidx.core.app.g;
import java.util.ArrayList;

public final class d {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Intent f1542a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f1543b;

    d(@NonNull Intent intent, Bundle bundle) {
        this.f1542a = intent;
        this.f1543b = bundle;
    }

    public void a(@NonNull Context context, @NonNull Uri uri) {
        this.f1542a.setData(uri);
        androidx.core.content.a.startActivity(context, this.f1542a, this.f1543b);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Intent f1544a = new Intent("android.intent.action.VIEW");

        /* renamed from: b  reason: collision with root package name */
        private final a.C0015a f1545b = new a.C0015a();

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<Bundle> f1546c;

        /* renamed from: d  reason: collision with root package name */
        private Bundle f1547d;

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<Bundle> f1548e;

        /* renamed from: f  reason: collision with root package name */
        private SparseArray<Bundle> f1549f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f1550g;

        /* renamed from: h  reason: collision with root package name */
        private int f1551h = 0;

        /* renamed from: i  reason: collision with root package name */
        private boolean f1552i = true;

        public a() {
        }

        private void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            g.b(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f1544a.putExtras(bundle);
        }

        @NonNull
        public d a() {
            if (!this.f1544a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c((IBinder) null, (PendingIntent) null);
            }
            ArrayList<Bundle> arrayList = this.f1546c;
            if (arrayList != null) {
                this.f1544a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f1548e;
            if (arrayList2 != null) {
                this.f1544a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f1544a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1552i);
            this.f1544a.putExtras(this.f1545b.a().a());
            Bundle bundle = this.f1550g;
            if (bundle != null) {
                this.f1544a.putExtras(bundle);
            }
            if (this.f1549f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f1549f);
                this.f1544a.putExtras(bundle2);
            }
            this.f1544a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f1551h);
            return new d(this.f1544a, this.f1547d);
        }

        @NonNull
        public a b(@NonNull f fVar) {
            this.f1544a.setPackage(fVar.d().getPackageName());
            c(fVar.c(), fVar.e());
            return this;
        }

        public a(f fVar) {
            if (fVar != null) {
                b(fVar);
            }
        }
    }
}
