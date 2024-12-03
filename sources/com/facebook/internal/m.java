package com.facebook.internal;

import com.facebook.internal.FileLruCache;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class m implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return FileLruCache.BufferFile.m123filterExcludeNonBufferFiles$lambda1(file, str);
    }
}
