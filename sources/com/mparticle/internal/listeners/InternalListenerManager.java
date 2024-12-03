package com.mparticle.internal.listeners;

import android.content.ContentValues;
import android.content.Context;
import android.os.Message;
import androidx.annotation.NonNull;
import com.mparticle.BuildConfig;
import com.mparticle.SdkListener;
import com.mparticle.identity.AliasResponse;
import com.mparticle.internal.InternalSession;
import com.mparticle.internal.MPUtility;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public class InternalListenerManager implements com.mparticle.l {
    private static final String INTERNAL_LISTENER_PROP = "debug.mparticle.listener";
    private static InternalListenerManager instance;
    private Context context;
    final List<WeakReference<GraphListener>> graphListeners = new ArrayList();
    final List<WeakReference<SdkListener>> sdkListeners = new ArrayList();
    private boolean thrown = false;

    class a implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f22512a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22513b;

        a(int i10, String str) {
            this.f22512a = i10;
            this.f22513b = str;
        }

        public void a(SdkListener sdkListener) {
            sdkListener.onKitExcluded(this.f22512a, this.f22513b);
        }
    }

    class b implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f22515a;

        b(int i10) {
            this.f22515a = i10;
        }

        public void a(SdkListener sdkListener) {
            sdkListener.onKitStarted(this.f22515a);
        }
    }

    class c implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AliasResponse f22517a;

        c(AliasResponse aliasResponse) {
            this.f22517a = aliasResponse;
        }

        public void a(SdkListener sdkListener) {
            sdkListener.onAliasRequestFinished(this.f22517a);
        }
    }

    class d implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f22519a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22520b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f22521c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f22522d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ List f22523e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f22524f;

        d(int i10, String str, String str2, String str3, List list, boolean z10) {
            this.f22519a = i10;
            this.f22520b = str;
            this.f22521c = str2;
            this.f22522d = str3;
            this.f22523e = list;
            this.f22524f = z10;
        }

        public void a(SdkListener sdkListener) {
            sdkListener.onKitApiCalled(this.f22519a, this.f22520b, this.f22521c, this.f22522d, this.f22523e, this.f22524f);
        }
    }

    class e implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f22526a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f22527b;

        e(Object obj, Object obj2) {
            this.f22526a = obj;
            this.f22527b = obj2;
        }

        public void a(GraphListener graphListener) {
            graphListener.onCompositeObjects(this.f22526a, this.f22527b);
        }
    }

    class f implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22529a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Message f22530b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f22531c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ StackTraceElement[] f22532d;

        f(String str, Message message, boolean z10, StackTraceElement[] stackTraceElementArr) {
            this.f22529a = str;
            this.f22530b = message;
            this.f22531c = z10;
            this.f22532d = stackTraceElementArr;
        }

        public void a(GraphListener graphListener) {
            graphListener.onThreadMessage(this.f22529a, this.f22530b, this.f22531c, this.f22532d);
        }
    }

    class g implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SdkListener.DatabaseTable f22534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Long f22535b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ org.json.b f22536c;

        g(SdkListener.DatabaseTable databaseTable, Long l10, org.json.b bVar) {
            this.f22534a = databaseTable;
            this.f22535b = l10;
            this.f22536c = bVar;
        }

        public void a(SdkListener sdkListener) {
            sdkListener.onEntityStored(this.f22534a, this.f22535b.longValue(), this.f22536c);
        }
    }

    class h implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SdkListener.Endpoint f22538a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22539b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ org.json.b f22540c;

        h(SdkListener.Endpoint endpoint, String str, org.json.b bVar) {
            this.f22538a = endpoint;
            this.f22539b = str;
            this.f22540c = bVar;
        }

        public void a(SdkListener sdkListener) {
            sdkListener.onNetworkRequestStarted(this.f22538a, this.f22539b, this.f22540c);
        }
    }

    class i implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SdkListener.Endpoint f22542a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22543b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ org.json.b f22544c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f22545d;

        i(SdkListener.Endpoint endpoint, String str, org.json.b bVar, int i10) {
            this.f22542a = endpoint;
            this.f22543b = str;
            this.f22544c = bVar;
            this.f22545d = i10;
        }

        public void a(SdkListener sdkListener) {
            sdkListener.onNetworkRequestFinished(this.f22542a, this.f22543b, this.f22544c, this.f22545d);
        }
    }

    class j implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InternalSession f22547a;

        j(InternalSession internalSession) {
            this.f22547a = internalSession;
        }

        public void a(SdkListener sdkListener) {
            sdkListener.onSessionUpdated(new InternalSession(this.f22547a));
        }
    }

    class k implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f22549a;

        k(int i10) {
            this.f22549a = i10;
        }

        public void a(SdkListener sdkListener) {
            sdkListener.onKitDetected(this.f22549a);
        }
    }

    class l implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f22551a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ org.json.b f22552b;

        l(int i10, org.json.b bVar) {
            this.f22551a = i10;
            this.f22552b = bVar;
        }

        public void a(SdkListener sdkListener) {
            sdkListener.onKitConfigReceived(this.f22551a, this.f22552b);
        }
    }

    interface m {
        void a(GraphListener graphListener);
    }

    interface n {
        void a(SdkListener sdkListener);
    }

    private InternalListenerManager(Context context2) {
        this.context = context2;
    }

    private void broadcast(n nVar) {
        Iterator it = new ArrayList(this.sdkListeners).iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            SdkListener sdkListener = (SdkListener) weakReference.get();
            if (sdkListener == null) {
                this.sdkListeners.remove(weakReference);
            } else {
                nVar.a(sdkListener);
            }
        }
    }

    public static String getApiFormattedName(String str, String str2) {
        return str + "." + str2 + "()";
    }

    private String getApiName(StackTraceElement stackTraceElement) {
        return getApiFormattedName(getClassName(stackTraceElement.getClassName(), stackTraceElement.getMethodName()), stackTraceElement.getMethodName());
    }

    private String getClassName(String str, String str2) {
        String[] split = str.split("\\.");
        String str3 = split[split.length - 1];
        if (isObfuscated(str3)) {
            try {
                ArrayList<Class> arrayList = new ArrayList<>();
                Class<?> cls = Class.forName(str);
                arrayList.add(cls.getSuperclass());
                for (Class add : cls.getInterfaces()) {
                    arrayList.add(add);
                }
                for (Class cls2 : arrayList) {
                    Method[] methods = cls2.getMethods();
                    int length = methods.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 < length) {
                            if (methods[i10].getName().equals(str2)) {
                                String className = getClassName(cls2.getName(), str2);
                                if (!isObfuscated(className)) {
                                    return className;
                                }
                            }
                            i10++;
                        }
                    }
                }
            } catch (ClassNotFoundException e10) {
                e10.printStackTrace();
            }
        }
        return str3;
    }

    @NonNull
    public static com.mparticle.l getListener() {
        if (instance == null || !isEnabled()) {
            return com.mparticle.l.f22606a;
        }
        return instance;
    }

    private boolean hasListeners() {
        return instance.sdkListeners.size() > 0 || instance.graphListeners.size() > 0;
    }

    public static boolean isEnabled() {
        InternalListenerManager internalListenerManager = instance;
        if (internalListenerManager == null || !internalListenerManager.hasListeners()) {
            return false;
        }
        return true;
    }

    private boolean isExternalApiInvocation(StackTraceElement stackTraceElement) {
        if (!stackTraceElement.getClassName().startsWith(BuildConfig.LIBRARY_PACKAGE_NAME)) {
            return true;
        }
        if (!stackTraceElement.getClassName().startsWith(this.context.getApplicationContext().getPackageName()) || this.context.getApplicationContext().getPackageName().length() <= 1) {
            return false;
        }
        return true;
    }

    private boolean isObfuscated(@NonNull String str) {
        return Character.isLowerCase(str.toCharArray()[0]) && str.length() <= 3;
    }

    public static InternalListenerManager start(Context context2) {
        boolean z10;
        if (MPUtility.isAppDebuggable(context2) || context2.getPackageName().equals(MPUtility.getProp(INTERNAL_LISTENER_PROP))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (instance == null && context2 != null && z10) {
            instance = new InternalListenerManager(context2.getApplicationContext());
        }
        return instance;
    }

    public void addListener(SdkListener sdkListener) {
        for (WeakReference<SdkListener> weakReference : this.sdkListeners) {
            if (weakReference.get() == sdkListener) {
                return;
            }
        }
        this.sdkListeners.add(new WeakReference(sdkListener));
        if (sdkListener instanceof GraphListener) {
            this.graphListeners.add(new WeakReference((GraphListener) sdkListener));
        }
    }

    public void onAliasRequestFinished(AliasResponse aliasResponse) {
        broadcast((n) new c(aliasResponse));
    }

    public void onApiCalled(Object... objArr) {
    }

    public void onCompositeObjects(Object obj, Object obj2) {
        broadcast((m) new e(obj, obj2));
    }

    public void onEntityStored(Long l10, String str, ContentValues contentValues) {
        SdkListener.DatabaseTable databaseTable;
        onCompositeObjects(contentValues, str + l10);
        org.json.b bVar = new org.json.b();
        try {
            databaseTable = SdkListener.DatabaseTable.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException unused) {
            databaseTable = SdkListener.DatabaseTable.UNKNOWN;
        }
        for (Map.Entry next : contentValues.valueSet()) {
            try {
                if (next.getValue() == null) {
                    bVar.put((String) next.getKey(), org.json.b.NULL);
                } else {
                    bVar.put((String) next.getKey(), next.getValue());
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        broadcast((n) new g(databaseTable, l10, bVar));
    }

    public void onKitApiCalled(int i10, Boolean bool, Object... objArr) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String str = null;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().equals(com.mparticle.internal.d.class.getName())) {
                str = stackTraceElement.getMethodName() + "()";
            }
        }
        onKitApiCalled(stackTrace, str, i10, bool.booleanValue(), objArr);
    }

    public void onKitConfigReceived(int i10, String str) {
        org.json.b bVar = new org.json.b();
        try {
            bVar = new org.json.b(str);
        } catch (JSONException unused) {
        }
        broadcast((n) new l(i10, bVar));
    }

    public void onKitDetected(int i10) {
        broadcast((n) new k(i10));
    }

    public void onKitExcluded(int i10, String str) {
        broadcast((n) new a(i10, str));
    }

    public void onKitStarted(int i10) {
        broadcast((n) new b(i10));
    }

    public void onNetworkRequestFinished(SdkListener.Endpoint endpoint, String str, org.json.b bVar, int i10) {
        broadcast((n) new i(endpoint, str, bVar, i10));
    }

    public void onNetworkRequestStarted(SdkListener.Endpoint endpoint, String str, org.json.b bVar, Object... objArr) {
        for (Object onCompositeObjects : objArr) {
            onCompositeObjects(onCompositeObjects, bVar);
        }
        ArrayList arrayList = new ArrayList();
        for (Object add : objArr) {
            arrayList.add(add);
        }
        broadcast((n) new h(endpoint, str, bVar));
    }

    public void onSessionUpdated(InternalSession internalSession) {
        broadcast((n) new j(internalSession));
    }

    public void onThreadMessage(String str, Message message, boolean z10) {
        StackTraceElement[] stackTraceElementArr;
        if (!z10) {
            stackTraceElementArr = Thread.currentThread().getStackTrace();
        } else {
            stackTraceElementArr = null;
        }
        broadcast((m) new f(str, message, z10, stackTraceElementArr));
    }

    public void removeListener(SdkListener sdkListener) {
        Iterator it = new ArrayList(this.sdkListeners).iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == sdkListener) {
                this.sdkListeners.remove(weakReference);
            }
        }
        Iterator it2 = new ArrayList(this.graphListeners).iterator();
        while (it2.hasNext()) {
            WeakReference weakReference2 = (WeakReference) it2.next();
            if (weakReference2.get() == sdkListener) {
                this.graphListeners.remove(weakReference2);
            }
        }
    }

    private void broadcast(m mVar) {
        Iterator it = new ArrayList(this.graphListeners).iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            GraphListener graphListener = (GraphListener) weakReference.get();
            if (graphListener == null) {
                this.graphListeners.remove(weakReference);
            } else {
                mVar.a(graphListener);
            }
        }
    }

    public void onKitApiCalled(String str, int i10, Boolean bool, Object... objArr) {
        onKitApiCalled(Thread.currentThread().getStackTrace(), str, i10, bool.booleanValue(), objArr);
    }

    private void onKitApiCalled(StackTraceElement[] stackTraceElementArr, String str, int i10, boolean z10, Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object add : objArr) {
            arrayList.add(add);
        }
        String str2 = null;
        String str3 = null;
        boolean z11 = false;
        boolean z12 = false;
        for (int i11 = 0; i11 < stackTraceElementArr.length; i11++) {
            if (!isExternalApiInvocation(stackTraceElementArr[i11])) {
                z11 = true;
            }
            if (z11 && !z12 && isExternalApiInvocation(stackTraceElementArr[i11])) {
                str2 = getApiName(stackTraceElementArr[i11 - 1]);
                z12 = true;
            }
            if (stackTraceElementArr[i11].getClassName().equals("com.mparticle.kits.KitManagerImpl")) {
                str3 = getApiName(stackTraceElementArr[i11]);
            }
        }
        broadcast((n) new d(i10, str, str2, str3, arrayList, z10));
    }
}
