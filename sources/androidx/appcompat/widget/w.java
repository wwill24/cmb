package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.util.h;

final class w {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private TextView f1464a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f1465b;

    private static final class a {
        @NonNull
        static TextClassifier a(@NonNull TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
    }

    w(@NonNull TextView textView) {
        this.f1464a = (TextView) h.g(textView);
    }

    @NonNull
    public TextClassifier a() {
        TextClassifier textClassifier = this.f1465b;
        if (textClassifier == null) {
            return a.a(this.f1464a);
        }
        return textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f1465b = textClassifier;
    }
}
