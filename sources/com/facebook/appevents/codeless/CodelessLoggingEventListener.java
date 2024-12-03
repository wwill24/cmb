package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\fH\u0007J%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener;", "", "()V", "getOnClickListener", "Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnClickListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "getOnItemClickListener", "Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnItemClickListener;", "Landroid/widget/AdapterView;", "logEvent", "", "logEvent$facebook_core_release", "updateParameters", "parameters", "Landroid/os/Bundle;", "updateParameters$facebook_core_release", "AutoLoggingOnClickListener", "AutoLoggingOnItemClickListener", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CodelessLoggingEventListener {
    public static final CodelessLoggingEventListener INSTANCE = new CodelessLoggingEventListener();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnClickListener;", "Landroid/view/View$OnClickListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/view/View;)V", "existingOnClickListener", "Ljava/lang/ref/WeakReference;", "supportCodelessLogging", "", "getSupportCodelessLogging", "()Z", "setSupportCodelessLogging", "(Z)V", "onClick", "", "view", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AutoLoggingOnClickListener implements View.OnClickListener {
        private View.OnClickListener existingOnClickListener;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging = true;

        public AutoLoggingOnClickListener(EventBinding eventBinding, View view, View view2) {
            j.g(eventBinding, "mapping");
            j.g(view, "rootView");
            j.g(view2, "hostView");
            this.mapping = eventBinding;
            this.hostView = new WeakReference<>(view2);
            this.rootView = new WeakReference<>(view);
            this.existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        public void onClick(View view) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    j.g(view, "view");
                    View.OnClickListener onClickListener = this.existingOnClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    View view2 = this.rootView.get();
                    View view3 = this.hostView.get();
                    if (view2 != null && view3 != null) {
                        CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                        CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view2, view3);
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }

        public final void setSupportCodelessLogging(boolean z10) {
            this.supportCodelessLogging = z10;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\bJ.\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnItemClickListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "Landroid/widget/AdapterView;", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/widget/AdapterView;)V", "existingOnItemClickListener", "Ljava/lang/ref/WeakReference;", "supportCodelessLogging", "", "getSupportCodelessLogging", "()Z", "setSupportCodelessLogging", "(Z)V", "onItemClick", "", "parent", "view", "position", "", "id", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AutoLoggingOnItemClickListener implements AdapterView.OnItemClickListener {
        private AdapterView.OnItemClickListener existingOnItemClickListener;
        private WeakReference<AdapterView<?>> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging = true;

        public AutoLoggingOnItemClickListener(EventBinding eventBinding, View view, AdapterView<?> adapterView) {
            j.g(eventBinding, "mapping");
            j.g(view, "rootView");
            j.g(adapterView, "hostView");
            this.mapping = eventBinding;
            this.hostView = new WeakReference<>(adapterView);
            this.rootView = new WeakReference<>(view);
            this.existingOnItemClickListener = adapterView.getOnItemClickListener();
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            j.g(view, "view");
            AdapterView.OnItemClickListener onItemClickListener = this.existingOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i10, j10);
            }
            View view2 = this.rootView.get();
            AdapterView adapterView2 = this.hostView.get();
            if (view2 != null && adapterView2 != null) {
                CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view2, adapterView2);
            }
        }

        public final void setSupportCodelessLogging(boolean z10) {
            this.supportCodelessLogging = z10;
        }
    }

    private CodelessLoggingEventListener() {
    }

    public static final AutoLoggingOnClickListener getOnClickListener(EventBinding eventBinding, View view, View view2) {
        Class<CodelessLoggingEventListener> cls = CodelessLoggingEventListener.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(eventBinding, "mapping");
            j.g(view, "rootView");
            j.g(view2, "hostView");
            return new AutoLoggingOnClickListener(eventBinding, view, view2);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final AutoLoggingOnItemClickListener getOnItemClickListener(EventBinding eventBinding, View view, AdapterView<?> adapterView) {
        Class<CodelessLoggingEventListener> cls = CodelessLoggingEventListener.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(eventBinding, "mapping");
            j.g(view, "rootView");
            j.g(adapterView, "hostView");
            return new AutoLoggingOnItemClickListener(eventBinding, view, adapterView);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final void logEvent$facebook_core_release(EventBinding eventBinding, View view, View view2) {
        Class<CodelessLoggingEventListener> cls = CodelessLoggingEventListener.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(eventBinding, "mapping");
                j.g(view, "rootView");
                j.g(view2, "hostView");
                String eventName = eventBinding.getEventName();
                Bundle parameters = CodelessMatcher.Companion.getParameters(eventBinding, view, view2);
                INSTANCE.updateParameters$facebook_core_release(parameters);
                FacebookSdk.getExecutor().execute(new a(eventName, parameters));
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: logEvent$lambda-0  reason: not valid java name */
    public static final void m59logEvent$lambda0(String str, Bundle bundle) {
        Class<CodelessLoggingEventListener> cls = CodelessLoggingEventListener.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(str, "$eventName");
                j.g(bundle, "$parameters");
                AppEventsLogger.Companion.newLogger(FacebookSdk.getApplicationContext()).logEvent(str, bundle);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public final void updateParameters$facebook_core_release(Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(bundle, "parameters");
                String string = bundle.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM);
                if (string != null) {
                    bundle.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(string));
                }
                bundle.putString(Constants.IS_CODELESS_EVENT_KEY, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
