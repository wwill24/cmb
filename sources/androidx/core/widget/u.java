package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.c;
import androidx.core.view.i0;

public final class u implements i0 {

    private static final class a {
        static CharSequence a(@NonNull Context context, @NonNull ClipData.Item item, int i10) {
            if ((i10 & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            CharSequence coerceToText = item.coerceToText(context);
            if (coerceToText instanceof Spanned) {
                return coerceToText.toString();
            }
            return coerceToText;
        }
    }

    private static CharSequence b(@NonNull Context context, @NonNull ClipData.Item item, int i10) {
        return a.a(context, item, i10);
    }

    private static void c(@NonNull Editable editable, @NonNull CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    public c a(@NonNull View view, @NonNull c cVar) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onReceive: ");
            sb2.append(cVar);
        }
        if (cVar.d() == 2) {
            return cVar;
        }
        ClipData b10 = cVar.b();
        int c10 = cVar.c();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z10 = false;
        for (int i10 = 0; i10 < b10.getItemCount(); i10++) {
            CharSequence b11 = b(context, b10.getItemAt(i10), c10);
            if (b11 != null) {
                if (!z10) {
                    c(editable, b11);
                    z10 = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), b11);
                }
            }
        }
        return null;
    }
}
