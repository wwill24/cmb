package org.jivesoftware.smack.util;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ObservableWriter extends Writer {
    private static final int MAX_STRING_BUILDER_SIZE = 4096;
    final List<WriterListener> listeners = new ArrayList();
    private final StringBuilder stringBuilder = new StringBuilder(4096);
    Writer wrappedWriter = null;

    public ObservableWriter(Writer writer) {
        this.wrappedWriter = writer;
    }

    private void maybeNotifyListeners(String str) {
        this.stringBuilder.append(str);
        if (this.stringBuilder.length() > 4096) {
            notifyListeners();
        }
    }

    private void notifyListeners() {
        int size;
        WriterListener[] writerListenerArr;
        synchronized (this.listeners) {
            size = this.listeners.size();
            writerListenerArr = new WriterListener[size];
            this.listeners.toArray(writerListenerArr);
        }
        String sb2 = this.stringBuilder.toString();
        this.stringBuilder.setLength(0);
        for (int i10 = 0; i10 < size; i10++) {
            writerListenerArr[i10].write(sb2);
        }
    }

    public void addWriterListener(WriterListener writerListener) {
        if (writerListener != null) {
            synchronized (this.listeners) {
                if (!this.listeners.contains(writerListener)) {
                    this.listeners.add(writerListener);
                }
            }
        }
    }

    public void close() throws IOException {
        this.wrappedWriter.close();
    }

    public void flush() throws IOException {
        notifyListeners();
        this.wrappedWriter.flush();
    }

    public void removeWriterListener(WriterListener writerListener) {
        synchronized (this.listeners) {
            this.listeners.remove(writerListener);
        }
    }

    public void write(char[] cArr, int i10, int i11) throws IOException {
        this.wrappedWriter.write(cArr, i10, i11);
        maybeNotifyListeners(new String(cArr, i10, i11));
    }

    public void write(int i10) throws IOException {
        this.wrappedWriter.write(i10);
    }

    public void write(char[] cArr) throws IOException {
        this.wrappedWriter.write(cArr);
        maybeNotifyListeners(new String(cArr));
    }

    public void write(String str) throws IOException {
        this.wrappedWriter.write(str);
        maybeNotifyListeners(str);
    }

    public void write(String str, int i10, int i11) throws IOException {
        this.wrappedWriter.write(str, i10, i11);
        maybeNotifyListeners(str.substring(i10, i11 + i10));
    }
}
