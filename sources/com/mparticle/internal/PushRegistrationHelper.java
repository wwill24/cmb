package com.mparticle.internal;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.mparticle.MParticle;
import java.lang.reflect.Method;

public class PushRegistrationHelper {

    public static class PushRegistration {
        public String instanceId;
        public String senderId;

        public PushRegistration(String str, String str2) {
            this.instanceId = str;
            this.senderId = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof PushRegistration)) {
                return false;
            }
            PushRegistration pushRegistration = (PushRegistration) obj;
            String str = this.senderId;
            String str2 = pushRegistration.senderId;
            if (str == str2 || (str != null && str.equals(str2))) {
                String str3 = this.instanceId;
                String str4 = pushRegistration.instanceId;
                if (str3 == str4) {
                    return true;
                }
                if (str3 != null && str3.equals(str4)) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            String str = this.senderId;
            String str2 = "null";
            if (str == null) {
                str = str2;
            }
            sb2.append(str);
            sb2.append(", ");
            String str3 = this.instanceId;
            if (str3 != null) {
                str2 = str3;
            }
            sb2.append(str2);
            sb2.append("]");
            return sb2.toString();
        }
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22377a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22378b;

        /* renamed from: com.mparticle.internal.PushRegistrationHelper$a$a  reason: collision with other inner class name */
        class C0256a implements OnFailureListener {
            C0256a() {
            }

            public void onFailure(@NonNull Exception exc) {
                Logger.error("Error registering for FCM Instance ID: ", exc.getMessage());
            }
        }

        class b implements OnSuccessListener<String> {
            b() {
            }

            /* renamed from: a */
            public void onSuccess(String str) {
                a aVar = a.this;
                PushRegistrationHelper.setPushRegistration(aVar.f22378b, str, aVar.f22377a);
            }
        }

        a(String str, Context context) {
            this.f22377a = str;
            this.f22378b = context;
        }

        public void run() {
            Class<String> cls = String.class;
            try {
                if (MPUtility.isFirebaseAvailablePreV21().booleanValue()) {
                    Class<?> cls2 = Class.forName("com.google.firebase.iid.FirebaseInstanceId");
                    Object invoke = cls2.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
                    Method method = cls2.getMethod("getToken", new Class[]{cls, cls});
                    Object[] objArr = {this.f22377a, FirebaseMessaging.INSTANCE_ID_SCOPE};
                    PushRegistrationHelper.setPushRegistration(this.f22378b, (String) method.invoke(invoke, objArr), this.f22377a);
                } else if (MPUtility.isFirebaseAvailablePostV21().booleanValue()) {
                    FirebaseMessaging.getInstance().getToken().addOnSuccessListener(new b()).addOnFailureListener(new C0256a());
                } else {
                    Logger.error("Error registering FCM Instance ID: no Firebase library");
                }
            } catch (Exception e10) {
                Logger.error("Error registering for FCM Instance ID: ", e10.getMessage());
            }
        }
    }

    public static PushRegistration getLatestPushRegistration(Context context) {
        return b.a(context).M();
    }

    public static void requestInstanceId(Context context) {
        requestInstanceId(context, b.a(context).N());
    }

    static void setPushRegistration(Context context, String str, String str2) {
        if (!MPUtility.isEmpty((CharSequence) str)) {
            MParticle instance = MParticle.getInstance();
            b a10 = b.a(context);
            a10.d0();
            PushRegistration pushRegistration = new PushRegistration(str, str2);
            PushRegistration M = a10.M();
            if (instance == null || (instance.getCurrentSession() == null && pushRegistration.equals(M))) {
                b.a(context).b(new PushRegistration(str, str2));
            } else {
                instance.logPushRegistration(str, str2);
            }
        }
    }

    public static void requestInstanceId(Context context, String str) {
        if (!b.a(context).X() && MPUtility.isFirebaseAvailable()) {
            a aVar = new a(str, context);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                new Thread(aVar).start();
            } else {
                aVar.run();
            }
        }
    }
}
