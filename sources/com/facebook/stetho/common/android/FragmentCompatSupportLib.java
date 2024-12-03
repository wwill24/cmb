package com.facebook.stetho.common.android;

import android.app.Dialog;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import androidx.fragment.app.h;
import com.facebook.stetho.common.android.FragmentCompat;

final class FragmentCompatSupportLib extends FragmentCompat<Fragment, c, FragmentManager, h> {
    private static final DialogFragmentAccessorSupportLib sDialogFragmentAccessor = new DialogFragmentAccessorSupportLib();
    private static final FragmentAccessorSupportLib sFragmentAccessor = new FragmentAccessorSupportLib();
    private static final FragmentActivityAccessorSupportLib sFragmentActivityAccessor = new FragmentActivityAccessorSupportLib();
    private static final FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor = new FragmentCompat.FragmentManagerAccessorViaReflection<>();

    private static class DialogFragmentAccessorSupportLib extends FragmentAccessorSupportLib implements DialogFragmentAccessor<c, Fragment, FragmentManager> {
        private DialogFragmentAccessorSupportLib() {
            super();
        }

        public Dialog getDialog(c cVar) {
            return cVar.getDialog();
        }
    }

    private static class FragmentAccessorSupportLib implements FragmentAccessor<Fragment, FragmentManager> {
        private FragmentAccessorSupportLib() {
        }

        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return fragment.getChildFragmentManager();
        }

        public FragmentManager getFragmentManager(Fragment fragment) {
            return fragment.getFragmentManager();
        }

        public int getId(Fragment fragment) {
            return fragment.getId();
        }

        public Resources getResources(Fragment fragment) {
            return fragment.getResources();
        }

        public String getTag(Fragment fragment) {
            return fragment.getTag();
        }

        public View getView(Fragment fragment) {
            return fragment.getView();
        }
    }

    private static class FragmentActivityAccessorSupportLib implements FragmentActivityAccessor<h, FragmentManager> {
        private FragmentActivityAccessorSupportLib() {
        }

        public FragmentManager getFragmentManager(h hVar) {
            return hVar.getSupportFragmentManager();
        }
    }

    FragmentCompatSupportLib() {
    }

    public FragmentManagerAccessor<FragmentManager, Fragment> forFragmentManager() {
        return sFragmentManagerAccessor;
    }

    public Class<c> getDialogFragmentClass() {
        return c.class;
    }

    public Class<h> getFragmentActivityClass() {
        return h.class;
    }

    public Class<Fragment> getFragmentClass() {
        return Fragment.class;
    }

    public DialogFragmentAccessorSupportLib forDialogFragment() {
        return sDialogFragmentAccessor;
    }

    public FragmentAccessorSupportLib forFragment() {
        return sFragmentAccessor;
    }

    public FragmentActivityAccessorSupportLib forFragmentActivity() {
        return sFragmentActivityAccessor;
    }
}
