package io.sentry.android.core.internal.gestures;

import android.annotation.SuppressLint;
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

class j implements Window.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Window.Callback f31018a;

    j(Window.Callback callback) {
        this.f31018a = callback;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f31018a.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f31018a.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f31018a.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f31018a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f31018a.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f31018a.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f31018a.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f31018a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f31018a.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f31018a.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i10, Menu menu) {
        return this.f31018a.onCreatePanelMenu(i10, menu);
    }

    public View onCreatePanelView(int i10) {
        return this.f31018a.onCreatePanelView(i10);
    }

    public void onDetachedFromWindow() {
        this.f31018a.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        return this.f31018a.onMenuItemSelected(i10, menuItem);
    }

    public boolean onMenuOpened(int i10, Menu menu) {
        return this.f31018a.onMenuOpened(i10, menu);
    }

    public void onPanelClosed(int i10, Menu menu) {
        this.f31018a.onPanelClosed(i10, menu);
    }

    public boolean onPreparePanel(int i10, View view, Menu menu) {
        return this.f31018a.onPreparePanel(i10, view, menu);
    }

    public boolean onSearchRequested() {
        return this.f31018a.onSearchRequested();
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f31018a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z10) {
        this.f31018a.onWindowFocusChanged(z10);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f31018a.onWindowStartingActionMode(callback);
    }

    @SuppressLint({"NewApi"})
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f31018a.onSearchRequested(searchEvent);
    }

    @SuppressLint({"NewApi"})
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
        return this.f31018a.onWindowStartingActionMode(callback, i10);
    }
}
