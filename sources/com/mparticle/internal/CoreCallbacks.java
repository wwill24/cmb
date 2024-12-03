package com.mparticle.internal;

import android.app.Activity;
import android.net.Uri;
import com.mparticle.MParticleOptions;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.a;

public interface CoreCallbacks {

    public interface KitListener {
        public static final KitListener EMPTY = new a();

        class a implements KitListener {
            a() {
            }

            public void kitConfigReceived(int i10, String str) {
            }

            public void kitExcluded(int i10, String str) {
            }

            public void kitFound(int i10) {
            }

            public void kitStarted(int i10) {
            }

            public void onKitApiCalled(int i10, Boolean bool, Object... objArr) {
            }

            public void onKitApiCalled(String str, int i10, Boolean bool, Object... objArr) {
            }
        }

        void kitConfigReceived(int i10, String str);

        void kitExcluded(int i10, String str);

        void kitFound(int i10);

        void kitStarted(int i10);

        void onKitApiCalled(int i10, Boolean bool, Object... objArr);

        void onKitApiCalled(String str, int i10, Boolean bool, Object... objArr);
    }

    WeakReference<Activity> getCurrentActivity();

    MParticleOptions.DataplanOptions getDataplanOptions();

    Map<String, String> getIntegrationAttributes(int i10);

    KitListener getKitListener();

    a getLatestKitConfiguration();

    String getLaunchAction();

    Uri getLaunchUri();

    String getPushInstanceId();

    String getPushSenderId();

    int getUserBucket();

    boolean isBackgrounded();

    boolean isEnabled();

    boolean isPushEnabled();

    void setIntegrationAttributes(int i10, Map<String, String> map);
}
