package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.e;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer.b f5449a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e.h f5450b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f5451c;

    public /* synthetic */ f(EmojiCompatInitializer.b bVar, e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f5449a = bVar;
        this.f5450b = hVar;
        this.f5451c = threadPoolExecutor;
    }

    public final void run() {
        this.f5449a.d(this.f5450b, this.f5451c);
    }
}
