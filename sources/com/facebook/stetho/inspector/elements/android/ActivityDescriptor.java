package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor;
import java.util.List;

final class ActivityDescriptor extends AbstractChainedDescriptor<Activity> implements HighlightableDescriptor<Activity> {
    ActivityDescriptor() {
    }

    private static void getDialogFragments(FragmentCompat fragmentCompat, Activity activity, Accumulator<Object> accumulator) {
        Object fragmentManager;
        List addedFragments;
        if (fragmentCompat != null && fragmentCompat.getFragmentActivityClass().isInstance(activity) && (fragmentManager = fragmentCompat.forFragmentActivity().getFragmentManager(activity)) != null && (addedFragments = fragmentCompat.forFragmentManager().getAddedFragments(fragmentManager)) != null) {
            int size = addedFragments.size();
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = addedFragments.get(i10);
                if (fragmentCompat.getDialogFragmentClass().isInstance(obj)) {
                    accumulator.store(obj);
                }
            }
        }
    }

    public Object getElementToHighlightAtPosition(Activity activity, int i10, int i11, Rect rect) {
        Window window;
        HighlightableDescriptor highlightableDescriptor;
        Descriptor.Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            window = activity.getWindow();
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(window);
        } else {
            window = null;
            highlightableDescriptor = null;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getElementToHighlightAtPosition(window, i10, i11, rect);
    }

    public View getViewAndBoundsForHighlighting(Activity activity, Rect rect) {
        Window window;
        HighlightableDescriptor highlightableDescriptor;
        Descriptor.Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            window = activity.getWindow();
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(window);
        } else {
            window = null;
            highlightableDescriptor = null;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getViewAndBoundsForHighlighting(window, rect);
    }

    /* access modifiers changed from: protected */
    public void onGetChildren(Activity activity, Accumulator<Object> accumulator) {
        getDialogFragments(FragmentCompat.getSupportLibInstance(), activity, accumulator);
        getDialogFragments(FragmentCompat.getFrameworkInstance(), activity, accumulator);
        Window window = activity.getWindow();
        if (window != null) {
            accumulator.store(window);
        }
    }

    /* access modifiers changed from: protected */
    public String onGetNodeName(Activity activity) {
        return StringUtil.removePrefix(activity.getClass().getName(), "android.app.");
    }
}
