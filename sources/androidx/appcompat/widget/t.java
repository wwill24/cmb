package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.c;
import androidx.core.view.n0;

final class t {

    private static final class a {
        /* JADX INFO: finally extract failed */
        static boolean a(@NonNull DragEvent dragEvent, @NonNull TextView textView, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                n0.i0(textView, new c.a(dragEvent.getClipData(), 3).a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th2) {
                textView.endBatchEdit();
                throw th2;
            }
        }

        static boolean b(@NonNull DragEvent dragEvent, @NonNull View view, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            n0.i0(view, new c.a(dragEvent.getClipData(), 3).a());
            return true;
        }
    }

    static boolean a(@NonNull View view, @NonNull DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && n0.E(view) != null) {
            Activity c10 = c(view);
            if (c10 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't handle drop: no activity: view=");
                sb2.append(view);
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    if (view instanceof TextView) {
                        return a.a(dragEvent, (TextView) view, c10);
                    }
                    return a.b(dragEvent, view, c10);
                }
            }
        }
        return false;
    }

    static boolean b(@NonNull TextView textView, int i10) {
        ClipData clipData;
        int i11 = 0;
        if (Build.VERSION.SDK_INT >= 31 || n0.E(textView) == null || (i10 != 16908322 && i10 != 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            clipData = null;
        } else {
            clipData = clipboardManager.getPrimaryClip();
        }
        if (clipData != null && clipData.getItemCount() > 0) {
            c.a aVar = new c.a(clipData, 1);
            if (i10 != 16908322) {
                i11 = 1;
            }
            n0.i0(textView, aVar.c(i11).a());
        }
        return true;
    }

    static Activity c(@NonNull View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
