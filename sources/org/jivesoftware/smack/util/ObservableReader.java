package org.jivesoftware.smack.util;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ObservableReader extends Reader {
    final List<ReaderListener> listeners = new ArrayList();
    Reader wrappedReader = null;

    public ObservableReader(Reader reader) {
        this.wrappedReader = reader;
    }

    public void addReaderListener(ReaderListener readerListener) {
        if (readerListener != null) {
            synchronized (this.listeners) {
                if (!this.listeners.contains(readerListener)) {
                    this.listeners.add(readerListener);
                }
            }
        }
    }

    public void close() throws IOException {
        this.wrappedReader.close();
    }

    public void mark(int i10) throws IOException {
        this.wrappedReader.mark(i10);
    }

    public boolean markSupported() {
        return this.wrappedReader.markSupported();
    }

    public int read(char[] cArr, int i10, int i11) throws IOException {
        int size;
        ReaderListener[] readerListenerArr;
        int read = this.wrappedReader.read(cArr, i10, i11);
        if (read > 0) {
            String str = new String(cArr, i10, read);
            synchronized (this.listeners) {
                size = this.listeners.size();
                readerListenerArr = new ReaderListener[size];
                this.listeners.toArray(readerListenerArr);
            }
            for (int i12 = 0; i12 < size; i12++) {
                readerListenerArr[i12].read(str);
            }
        }
        return read;
    }

    public boolean ready() throws IOException {
        return this.wrappedReader.ready();
    }

    public void removeReaderListener(ReaderListener readerListener) {
        synchronized (this.listeners) {
            this.listeners.remove(readerListener);
        }
    }

    public void reset() throws IOException {
        this.wrappedReader.reset();
    }

    public long skip(long j10) throws IOException {
        return this.wrappedReader.skip(j10);
    }

    public int read() throws IOException {
        return this.wrappedReader.read();
    }

    public int read(char[] cArr) throws IOException {
        return this.wrappedReader.read(cArr);
    }
}
