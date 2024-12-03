package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.b;
import androidx.core.app.p;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class g0 implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4422a;

    /* renamed from: b  reason: collision with root package name */
    private final Notification.Builder f4423b;

    /* renamed from: c  reason: collision with root package name */
    private final p.e f4424c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f4425d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f4426e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Bundle> f4427f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f4428g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    private int f4429h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteViews f4430i;

    g0(p.e eVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        List<String> list;
        int i10;
        this.f4424c = eVar;
        this.f4422a = eVar.f4491a;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4423b = new Notification.Builder(eVar.f4491a, eVar.K);
        } else {
            this.f4423b = new Notification.Builder(eVar.f4491a);
        }
        Notification notification = eVar.R;
        Notification.Builder lights = this.f4423b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f4499i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z10);
        if ((notification.flags & 8) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z11);
        if ((notification.flags & 16) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z12).setDefaults(notification.defaults).setContentTitle(eVar.f4495e).setContentText(eVar.f4496f).setContentInfo(eVar.f4501k).setContentIntent(eVar.f4497g).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = eVar.f4498h;
        if ((notification.flags & 128) != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z13).setLargeIcon(eVar.f4500j).setNumber(eVar.f4502l).setProgress(eVar.f4510t, eVar.f4511u, eVar.f4512v);
        this.f4423b.setSubText(eVar.f4507q).setUsesChronometer(eVar.f4505o).setPriority(eVar.f4503m);
        Iterator<p.a> it = eVar.f4492b.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        Bundle bundle = eVar.D;
        if (bundle != null) {
            this.f4428g.putAll(bundle);
        }
        int i11 = Build.VERSION.SDK_INT;
        this.f4425d = eVar.H;
        this.f4426e = eVar.I;
        this.f4423b.setShowWhen(eVar.f4504n);
        this.f4423b.setLocalOnly(eVar.f4516z).setGroup(eVar.f4513w).setGroupSummary(eVar.f4514x).setSortKey(eVar.f4515y);
        this.f4429h = eVar.O;
        this.f4423b.setCategory(eVar.C).setColor(eVar.E).setVisibility(eVar.F).setPublicVersion(eVar.G).setSound(notification.sound, notification.audioAttributes);
        if (i11 < 28) {
            list = e(g(eVar.f4493c), eVar.U);
        } else {
            list = eVar.U;
        }
        if (list != null && !list.isEmpty()) {
            for (String addPerson : list) {
                this.f4423b.addPerson(addPerson);
            }
        }
        this.f4430i = eVar.J;
        if (eVar.f4494d.size() > 0) {
            Bundle bundle2 = eVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i12 = 0; i12 < eVar.f4494d.size(); i12++) {
                bundle4.putBundle(Integer.toString(i12), h0.a(eVar.f4494d.get(i12)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            eVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.f4428g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i13 = Build.VERSION.SDK_INT;
        Icon icon = eVar.T;
        if (icon != null) {
            this.f4423b.setSmallIcon(icon);
        }
        this.f4423b.setExtras(eVar.D).setRemoteInputHistory(eVar.f4509s);
        RemoteViews remoteViews = eVar.H;
        if (remoteViews != null) {
            this.f4423b.setCustomContentView(remoteViews);
        }
        RemoteViews remoteViews2 = eVar.I;
        if (remoteViews2 != null) {
            this.f4423b.setCustomBigContentView(remoteViews2);
        }
        RemoteViews remoteViews3 = eVar.J;
        if (remoteViews3 != null) {
            this.f4423b.setCustomHeadsUpContentView(remoteViews3);
        }
        if (i13 >= 26) {
            Notification.Builder unused = this.f4423b.setBadgeIconType(eVar.L).setSettingsText(eVar.f4508r).setShortcutId(eVar.M).setTimeoutAfter(eVar.N).setGroupAlertBehavior(eVar.O);
            if (eVar.B) {
                Notification.Builder unused2 = this.f4423b.setColorized(eVar.A);
            }
            if (!TextUtils.isEmpty(eVar.K)) {
                this.f4423b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i13 >= 28) {
            Iterator<m0> it2 = eVar.f4493c.iterator();
            while (it2.hasNext()) {
                Notification.Builder unused3 = this.f4423b.addPerson(it2.next().h());
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 29) {
            Notification.Builder unused4 = this.f4423b.setAllowSystemGeneratedContextualActions(eVar.Q);
            Notification.Builder unused5 = this.f4423b.setBubbleMetadata(p.d.a((p.d) null));
        }
        if (i14 >= 31 && (i10 = eVar.P) != 0) {
            Notification.Builder unused6 = this.f4423b.setForegroundServiceBehavior(i10);
        }
        if (eVar.S) {
            if (this.f4424c.f4514x) {
                this.f4429h = 2;
            } else {
                this.f4429h = 1;
            }
            this.f4423b.setVibrate((long[]) null);
            this.f4423b.setSound((Uri) null);
            int i15 = notification.defaults & -2 & -3;
            notification.defaults = i15;
            this.f4423b.setDefaults(i15);
            if (i14 >= 26) {
                if (TextUtils.isEmpty(this.f4424c.f4513w)) {
                    this.f4423b.setGroup("silent");
                }
                Notification.Builder unused7 = this.f4423b.setGroupAlertBehavior(this.f4429h);
            }
        }
    }

    private void b(p.a aVar) {
        Icon icon;
        Bundle bundle;
        IconCompat d10 = aVar.d();
        if (d10 != null) {
            icon = d10.q();
        } else {
            icon = null;
        }
        Notification.Action.Builder builder = new Notification.Action.Builder(icon, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput addRemoteInput : o0.b(aVar.e())) {
                builder.addRemoteInput(addRemoteInput);
            }
        }
        if (aVar.c() != null) {
            bundle = new Bundle(aVar.c());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i10 = Build.VERSION.SDK_INT;
        builder.setAllowGeneratedReplies(aVar.b());
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i10 >= 28) {
            Notification.Action.Builder unused = builder.setSemanticAction(aVar.f());
        }
        if (i10 >= 29) {
            Notification.Action.Builder unused2 = builder.setContextual(aVar.j());
        }
        if (i10 >= 31) {
            Notification.Action.Builder unused3 = builder.setAuthenticationRequired(aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        builder.addExtras(bundle);
        this.f4423b.addAction(builder.build());
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        b bVar = new b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> g(List<m0> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (m0 g10 : list) {
            arrayList.add(g10.g());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & -2 & -3;
    }

    public Notification.Builder a() {
        return this.f4423b;
    }

    public Notification c() {
        RemoteViews remoteViews;
        Bundle a10;
        RemoteViews f10;
        RemoteViews d10;
        p.f fVar = this.f4424c.f4506p;
        if (fVar != null) {
            fVar.b(this);
        }
        if (fVar != null) {
            remoteViews = fVar.e(this);
        } else {
            remoteViews = null;
        }
        Notification d11 = d();
        if (remoteViews != null) {
            d11.contentView = remoteViews;
        } else {
            RemoteViews remoteViews2 = this.f4424c.H;
            if (remoteViews2 != null) {
                d11.contentView = remoteViews2;
            }
        }
        if (!(fVar == null || (d10 = fVar.d(this)) == null)) {
            d11.bigContentView = d10;
        }
        if (!(fVar == null || (f10 = this.f4424c.f4506p.f(this)) == null)) {
            d11.headsUpContentView = f10;
        }
        if (!(fVar == null || (a10 = p.a(d11)) == null)) {
            fVar.a(a10);
        }
        return d11;
    }

    /* access modifiers changed from: protected */
    public Notification d() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f4423b.build();
        }
        Notification build = this.f4423b.build();
        if (this.f4429h != 0) {
            if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f4429h != 2)) {
                h(build);
            }
            if (build.getGroup() != null && (build.flags & 512) == 0 && this.f4429h == 1) {
                h(build);
            }
        }
        return build;
    }

    /* access modifiers changed from: package-private */
    public Context f() {
        return this.f4422a;
    }
}
