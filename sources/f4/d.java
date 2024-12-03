package f4;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class d extends InputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final Queue<d> f14712c = k.e(0);

    /* renamed from: a  reason: collision with root package name */
    private InputStream f14713a;

    /* renamed from: b  reason: collision with root package name */
    private IOException f14714b;

    d() {
    }

    @NonNull
    public static d b(@NonNull InputStream inputStream) {
        d poll;
        Queue<d> queue = f14712c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.e(inputStream);
        return poll;
    }

    public IOException a() {
        return this.f14714b;
    }

    public int available() throws IOException {
        return this.f14713a.available();
    }

    public void c() {
        this.f14714b = null;
        this.f14713a = null;
        Queue<d> queue = f14712c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public void close() throws IOException {
        this.f14713a.close();
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull InputStream inputStream) {
        this.f14713a = inputStream;
    }

    public void mark(int i10) {
        this.f14713a.mark(i10);
    }

    public boolean markSupported() {
        return this.f14713a.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.f14713a.read(bArr);
        } catch (IOException e10) {
            this.f14714b = e10;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.f14713a.reset();
    }

    public long skip(long j10) {
        try {
            return this.f14713a.skip(j10);
        } catch (IOException e10) {
            this.f14714b = e10;
            return 0;
        }
    }

    public int read(byte[] bArr, int i10, int i11) {
        try {
            return this.f14713a.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f14714b = e10;
            return -1;
        }
    }

    public int read() {
        try {
            return this.f14713a.read();
        } catch (IOException e10) {
            this.f14714b = e10;
            return -1;
        }
    }
}
