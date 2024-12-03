package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.g;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.leanplum.internal.Constants;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c {

    /* renamed from: h  reason: collision with root package name */
    private static int f38431h;

    /* renamed from: i  reason: collision with root package name */
    private static PendingIntent f38432i;

    /* renamed from: j  reason: collision with root package name */
    private static final Executor f38433j = b0.f38430a;

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f38434k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* renamed from: a  reason: collision with root package name */
    private final g<String, TaskCompletionSource<Bundle>> f38435a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f38436b;

    /* renamed from: c  reason: collision with root package name */
    private final v f38437c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f38438d;

    /* renamed from: e  reason: collision with root package name */
    private Messenger f38439e;

    /* renamed from: f  reason: collision with root package name */
    private Messenger f38440f;

    /* renamed from: g  reason: collision with root package name */
    private zzd f38441g;

    public c(@NonNull Context context) {
        this.f38436b = context;
        this.f38437c = new v(context);
        this.f38439e = new Messenger(new e(this, Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f38438d = scheduledThreadPoolExecutor;
    }

    static /* synthetic */ Task b(Bundle bundle) throws Exception {
        if (j(bundle)) {
            return Tasks.forResult(null);
        }
        return Tasks.forResult(bundle);
    }

    static /* bridge */ /* synthetic */ void d(c cVar, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new g());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        cVar.f38441g = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        cVar.f38440f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    String stringExtra = intent2.getStringExtra(Constants.Defaults.PROPERTY_FCM_TOKEN_ID);
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra("error");
                        if (stringExtra2 == null) {
                            String valueOf = String.valueOf(intent2.getExtras());
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
                            sb2.append("Unexpected response, no error or registration id ");
                            sb2.append(valueOf);
                            return;
                        }
                        if (Log.isLoggable("Rpc", 3) && stringExtra2.length() != 0) {
                            "Received InstanceID error ".concat(stringExtra2);
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length > 2 && "ID".equals(split[1])) {
                                String str = split[2];
                                String str2 = split[3];
                                if (str2.startsWith(CertificateUtil.DELIMITER)) {
                                    str2 = str2.substring(1);
                                }
                                cVar.i(str, intent2.putExtra("error", str2).getExtras());
                            } else if (stringExtra2.length() != 0) {
                                "Unexpected structured response ".concat(stringExtra2);
                            }
                        } else {
                            synchronized (cVar.f38435a) {
                                for (int i10 = 0; i10 < cVar.f38435a.size(); i10++) {
                                    cVar.i(cVar.f38435a.j(i10), intent2.getExtras());
                                }
                            }
                        }
                    } else {
                        Matcher matcher = f38434k.matcher(stringExtra);
                        if (matcher.matches()) {
                            String group = matcher.group(1);
                            String group2 = matcher.group(2);
                            if (group != null) {
                                Bundle extras = intent2.getExtras();
                                extras.putString(Constants.Defaults.PROPERTY_FCM_TOKEN_ID, group2);
                                cVar.i(group, extras);
                            }
                        } else if (Log.isLoggable("Rpc", 3) && stringExtra.length() != 0) {
                            "Unexpected response string: ".concat(stringExtra);
                        }
                    }
                } else if (Log.isLoggable("Rpc", 3)) {
                    String valueOf2 = String.valueOf(action);
                    if (valueOf2.length() != 0) {
                        "Unexpected response action: ".concat(valueOf2);
                    }
                }
            }
        }
    }

    private final Task<Bundle> f(Bundle bundle) {
        String g10 = g();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f38435a) {
            this.f38435a.put(g10, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f38437c.b() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        h(this.f38436b, intent);
        StringBuilder sb2 = new StringBuilder(String.valueOf(g10).length() + 5);
        sb2.append("|ID|");
        sb2.append(g10);
        sb2.append("|");
        intent.putExtra("kid", sb2.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb3 = new StringBuilder(valueOf.length() + 8);
            sb3.append("Sending ");
            sb3.append(valueOf);
        }
        intent.putExtra("google.messenger", this.f38439e);
        if (!(this.f38440f == null && this.f38441g == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f38440f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.f38441g.c(obtain);
                }
            } catch (RemoteException unused) {
                Log.isLoggable("Rpc", 3);
            }
            taskCompletionSource.getTask().addOnCompleteListener(f38433j, new y(this, g10, this.f38438d.schedule(new a0(taskCompletionSource), 30, TimeUnit.SECONDS)));
            return taskCompletionSource.getTask();
        }
        if (this.f38437c.b() == 2) {
            this.f38436b.sendBroadcast(intent);
        } else {
            this.f38436b.startService(intent);
        }
        taskCompletionSource.getTask().addOnCompleteListener(f38433j, new y(this, g10, this.f38438d.schedule(new a0(taskCompletionSource), 30, TimeUnit.SECONDS)));
        return taskCompletionSource.getTask();
    }

    private static synchronized String g() {
        String num;
        synchronized (c.class) {
            int i10 = f38431h;
            f38431h = i10 + 1;
            num = Integer.toString(i10);
        }
        return num;
    }

    private static synchronized void h(Context context, Intent intent) {
        synchronized (c.class) {
            if (f38432i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f38432i = zza.zza(context, 0, intent2, zza.zza);
            }
            intent.putExtra("app", f38432i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i(java.lang.String r3, android.os.Bundle r4) {
        /*
            r2 = this;
            androidx.collection.g<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r0 = r2.f38435a
            monitor-enter(r0)
            androidx.collection.g<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r2.f38435a     // Catch:{ all -> 0x0023 }
            java.lang.Object r1 = r1.remove(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.tasks.TaskCompletionSource r1 = (com.google.android.gms.tasks.TaskCompletionSource) r1     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x001e
            java.lang.String r4 = "Missing callback for "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0023 }
            int r1 = r3.length()     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x001c
            r4.concat(r3)     // Catch:{ all -> 0x0023 }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x001e:
            r1.setResult(r4)     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.c.i(java.lang.String, android.os.Bundle):void");
    }

    private static boolean j(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    @NonNull
    public Task<Bundle> a(@NonNull Bundle bundle) {
        if (this.f38437c.a() >= 12000000) {
            return u.b(this.f38436b).d(1, bundle).continueWith(f38433j, x.f38478a);
        }
        if (this.f38437c.b() != 0) {
            return f(bundle).continueWithTask(f38433j, new w(this, bundle));
        }
        return Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
    }

    @NonNull
    public final /* synthetic */ Task c(@NonNull Bundle bundle, @NonNull Task task) throws Exception {
        if (task.isSuccessful() && j((Bundle) task.getResult())) {
            return f(bundle).onSuccessTask(f38433j, z.f38482a);
        }
        return task;
    }

    public final /* synthetic */ void e(@NonNull String str, @NonNull ScheduledFuture scheduledFuture, @NonNull Task task) {
        synchronized (this.f38435a) {
            this.f38435a.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
