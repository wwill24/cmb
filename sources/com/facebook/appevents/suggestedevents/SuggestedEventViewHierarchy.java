package com.facebook.appevents.suggestedevents;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0007J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00100\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventViewHierarchy;", "", "Landroid/view/View;", "view", "clickedView", "Lorg/json/b;", "getDictionaryOfView", "json", "", "updateBasicInfo", "", "getAllClickableViews", "hostView", "", "getTextOfViewRecursively", "getTextOfChildren", "Ljava/lang/Class;", "blacklistedViews", "Ljava/util/List;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class SuggestedEventViewHierarchy {
    public static final SuggestedEventViewHierarchy INSTANCE = new SuggestedEventViewHierarchy();
    private static final List<Class<? extends View>> blacklistedViews = q.m(Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class);

    private SuggestedEventViewHierarchy() {
    }

    public static final List<View> getAllClickableViews(View view) {
        Class<SuggestedEventViewHierarchy> cls = SuggestedEventViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(view, "view");
            ArrayList arrayList = new ArrayList();
            for (Class<? extends View> isInstance : blacklistedViews) {
                if (isInstance.isInstance(view)) {
                    return arrayList;
                }
            }
            if (view.isClickable()) {
                arrayList.add(view);
            }
            for (View allClickableViews : ViewHierarchy.getChildrenOfView(view)) {
                arrayList.addAll(getAllClickableViews(allClickableViews));
            }
            return arrayList;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final b getDictionaryOfView(View view, View view2) {
        Class<SuggestedEventViewHierarchy> cls = SuggestedEventViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(view, "view");
            j.g(view2, "clickedView");
            b bVar = new b();
            if (view == view2) {
                try {
                    bVar.put(ViewHierarchyConstants.IS_INTERACTED_KEY, true);
                } catch (JSONException unused) {
                }
            }
            updateBasicInfo(view, bVar);
            a aVar = new a();
            for (View dictionaryOfView : ViewHierarchy.getChildrenOfView(view)) {
                aVar.E(getDictionaryOfView(dictionaryOfView, view2));
            }
            bVar.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, (Object) aVar);
            return bVar;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final List<String> getTextOfChildren(View view) {
        boolean z10;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (View next : ViewHierarchy.getChildrenOfView(view)) {
                String textOfView = ViewHierarchy.getTextOfView(next);
                if (textOfView.length() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    arrayList.add(textOfView);
                }
                arrayList.addAll(getTextOfChildren(next));
            }
            return arrayList;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public static final String getTextOfViewRecursively(View view) {
        boolean z10;
        Class<SuggestedEventViewHierarchy> cls = SuggestedEventViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(view, "hostView");
            String textOfView = ViewHierarchy.getTextOfView(view);
            if (textOfView.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return textOfView;
            }
            String join = TextUtils.join(" ", INSTANCE.getTextOfChildren(view));
            j.f(join, "join(\" \", childrenText)");
            return join;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final void updateBasicInfo(View view, b bVar) {
        boolean z10;
        Class<SuggestedEventViewHierarchy> cls = SuggestedEventViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(view, "view");
                j.g(bVar, JsonPacketExtension.ELEMENT);
                try {
                    String textOfView = ViewHierarchy.getTextOfView(view);
                    String hintOfView = ViewHierarchy.getHintOfView(view);
                    bVar.put(ViewHierarchyConstants.CLASS_NAME_KEY, (Object) view.getClass().getSimpleName());
                    bVar.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, ViewHierarchy.getClassTypeBitmask(view));
                    boolean z11 = true;
                    if (textOfView.length() > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        bVar.put("text", (Object) textOfView);
                    }
                    if (hintOfView.length() <= 0) {
                        z11 = false;
                    }
                    if (z11) {
                        bVar.put(ViewHierarchyConstants.HINT_KEY, (Object) hintOfView);
                    }
                    if (view instanceof EditText) {
                        bVar.put(ViewHierarchyConstants.INPUT_TYPE_KEY, ((EditText) view).getInputType());
                    }
                } catch (JSONException unused) {
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }
}
