package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import h1.c;

class n implements LayoutInflater.Factory2 {

    /* renamed from: a  reason: collision with root package name */
    final FragmentManager f5866a;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f5867a;

        a(z zVar) {
            this.f5867a = zVar;
        }

        public void onViewAttachedToWindow(View view) {
            Fragment k10 = this.f5867a.k();
            this.f5867a.m();
            SpecialEffectsController.n((ViewGroup) k10.mView.getParent(), n.this.f5866a).j();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    n(FragmentManager fragmentManager) {
        this.f5866a = fragmentManager;
    }

    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public View onCreateView(View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        z zVar;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f5866a);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(c.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(c.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(c.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !l.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id2 = view != null ? view.getId() : 0;
        if (id2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f5866a.i0(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f5866a.j0(string);
        }
        if (fragment == null && id2 != -1) {
            fragment = this.f5866a.i0(id2);
        }
        if (fragment == null) {
            fragment = this.f5866a.u0().a(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id2;
            fragment.mContainerId = id2;
            fragment.mTag = string;
            fragment.mInLayout = true;
            FragmentManager fragmentManager = this.f5866a;
            fragment.mFragmentManager = fragmentManager;
            fragment.mHost = fragmentManager.w0();
            fragment.onInflate(this.f5866a.w0().f(), attributeSet, fragment.mSavedFragmentState);
            zVar = this.f5866a.j(fragment);
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Fragment ");
                sb2.append(fragment);
                sb2.append(" has been inflated via the <fragment> tag: id=0x");
                sb2.append(Integer.toHexString(resourceId));
            }
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            FragmentManager fragmentManager2 = this.f5866a;
            fragment.mFragmentManager = fragmentManager2;
            fragment.mHost = fragmentManager2.w0();
            fragment.onInflate(this.f5866a.w0().f(), attributeSet, fragment.mSavedFragmentState);
            zVar = this.f5866a.x(fragment);
            if (FragmentManager.J0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Retained Fragment ");
                sb3.append(fragment);
                sb3.append(" has been re-attached via the <fragment> tag: id=0x");
                sb3.append(Integer.toHexString(resourceId));
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.i(fragment, viewGroup);
        fragment.mContainer = viewGroup;
        zVar.m();
        zVar.j();
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            fragment.mView.addOnAttachStateChangeListener(new a(zVar));
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
