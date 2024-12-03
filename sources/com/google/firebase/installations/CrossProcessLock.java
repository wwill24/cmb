package com.google.firebase.installations;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

class CrossProcessLock {
    private static final String TAG = "CrossProcessLock";
    private final FileChannel channel;
    private final FileLock lock;

    private CrossProcessLock(FileChannel fileChannel, FileLock fileLock) {
        this.channel = fileChannel;
        this.lock = fileLock;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A[SYNTHETIC, Splitter:B:14:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002a A[SYNTHETIC, Splitter:B:18:0x002a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.firebase.installations.CrossProcessLock acquire(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException | Error | OverlappingFileLockException -> 0x0021 }
            java.io.File r2 = r2.getFilesDir()     // Catch:{ IOException | Error | OverlappingFileLockException -> 0x0021 }
            r1.<init>(r2, r3)     // Catch:{ IOException | Error | OverlappingFileLockException -> 0x0021 }
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ IOException | Error | OverlappingFileLockException -> 0x0021 }
            java.lang.String r3 = "rw"
            r2.<init>(r1, r3)     // Catch:{ IOException | Error | OverlappingFileLockException -> 0x0021 }
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ IOException | Error | OverlappingFileLockException -> 0x0021 }
            java.nio.channels.FileLock r3 = r2.lock()     // Catch:{ IOException | Error | OverlappingFileLockException -> 0x001f }
            com.google.firebase.installations.CrossProcessLock r1 = new com.google.firebase.installations.CrossProcessLock     // Catch:{ IOException | Error | OverlappingFileLockException -> 0x0023 }
            r1.<init>(r2, r3)     // Catch:{ IOException | Error | OverlappingFileLockException -> 0x0023 }
            return r1
        L_0x001f:
            r3 = r0
            goto L_0x0023
        L_0x0021:
            r2 = r0
            r3 = r2
        L_0x0023:
            if (r3 == 0) goto L_0x0028
            r3.release()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            if (r2 == 0) goto L_0x002d
            r2.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.CrossProcessLock.acquire(android.content.Context, java.lang.String):com.google.firebase.installations.CrossProcessLock");
    }

    /* access modifiers changed from: package-private */
    public void releaseAndClose() {
        try {
            this.lock.release();
            this.channel.close();
        } catch (IOException unused) {
        }
    }
}
