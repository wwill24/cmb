package io.sentry.android.core.internal.gestures;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class b implements Window.Callback {
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onActionModeFinished(ActionMode actionMode) {
    }

    public void onActionModeStarted(ActionMode actionMode) {
    }

    public void onAttachedToWindow() {
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int i10, @NonNull Menu menu) {
        return false;
    }

    public View onCreatePanelView(int i10) {
        return null;
    }

    public void onDetachedFromWindow() {
    }

    public boolean onMenuItemSelected(int i10, @NonNull MenuItem menuItem) {
        return false;
    }

    public boolean onMenuOpened(int i10, @NonNull Menu menu) {
        return false;
    }

    public void onPanelClosed(int i10, @NonNull Menu menu) {
    }

    public boolean onPreparePanel(int i10, View view, @NonNull Menu menu) {
        return false;
    }

    public boolean onSearchRequested() {
        return false;
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return false;
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
    }

    public void onWindowFocusChanged(boolean z10) {
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
        return null;
    }
}
