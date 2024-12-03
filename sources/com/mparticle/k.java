package com.mparticle;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;

public class k {

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f22587a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f22588b;

        /* renamed from: com.mparticle.k$a$a  reason: collision with other inner class name */
        class C0261a implements InstallReferrerStateListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ InstallReferrerClient f22589a;

            C0261a(InstallReferrerClient installReferrerClient) {
                this.f22589a = installReferrerClient;
            }

            public void onInstallReferrerServiceDisconnected() {
            }

            public void onInstallReferrerSetupFinished(int i10) {
                if (i10 == 0) {
                    try {
                        ReferrerDetails installReferrer = this.f22589a.getInstallReferrer();
                        if (installReferrer != null) {
                            a.this.f22588b.a(installReferrer.getInstallReferrer());
                        } else {
                            a.this.f22588b.a();
                        }
                        this.f22589a.endConnection();
                    } catch (RemoteException unused) {
                        Logger.warning("InstallReferrer Remote Exception, using InstallReferrer from intent.");
                        a.this.f22588b.a();
                    } catch (Exception e10) {
                        Logger.warning("InstallReferrer Exception: " + e10.getMessage() + ", using InstallReferrer from intent");
                        a.this.f22588b.a();
                    }
                } else if (i10 == 1) {
                    Logger.warning("Unable to connect to InstallReferrer service, using InstallReferrer from intent.");
                    a.this.f22588b.a();
                } else if (i10 != 2) {
                    Logger.warning("InstallReferrer responseCode not found, using InstallReferrer from intent.");
                    a.this.f22588b.a();
                } else {
                    Logger.warning("InstallReferrer not supported, using InstallReferrer from intent.");
                    a.this.f22588b.a();
                }
            }
        }

        a(Context context, b bVar) {
            this.f22587a = context;
            this.f22588b = bVar;
        }

        public void run() {
            try {
                InstallReferrerClient build = InstallReferrerClient.newBuilder(this.f22587a).build();
                build.startConnection(new C0261a(build));
            } catch (Exception e10) {
                Logger.error("Exception while fetching install referrer: " + e10.getMessage());
                this.f22588b.a();
            }
        }
    }

    public interface b {
        void a();

        void a(String str);
    }

    public static String a(@NonNull Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("mParticlePrefs", 0).getString("mp::install_referrer", (String) null);
    }

    public static void a(@NonNull Context context, String str) {
        if (context != null) {
            context.getSharedPreferences("mParticlePrefs", 0).edit().putString("mp::install_referrer", str).apply();
            MParticle instance = MParticle.getInstance();
            if (instance != null) {
                instance.installReferrerUpdated();
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull b bVar) {
        if (MPUtility.isInstallRefApiAvailable()) {
            a aVar = new a(context, bVar);
            try {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    new Thread(aVar).start();
                } else {
                    aVar.run();
                }
            } catch (Exception unused) {
                bVar.a();
            }
        } else {
            bVar.a();
        }
    }
}
