package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;
import kotlin.sequences.Sequence;

final class k implements Sequence<String> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final BufferedReader f32114a;

    public static final class a implements Iterator<String>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private String f32115a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f32116b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f32117c;

        a(k kVar) {
            this.f32117c = kVar;
        }

        /* renamed from: a */
        public String next() {
            if (hasNext()) {
                String str = this.f32115a;
                this.f32115a = null;
                j.d(str);
                return str;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f32115a == null && !this.f32116b) {
                String readLine = this.f32117c.f32114a.readLine();
                this.f32115a = readLine;
                if (readLine == null) {
                    this.f32116b = true;
                }
            }
            if (this.f32115a != null) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public k(BufferedReader bufferedReader) {
        j.g(bufferedReader, "reader");
        this.f32114a = bufferedReader;
    }

    public Iterator<String> iterator() {
        return new a(this);
    }
}
