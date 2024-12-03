package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class r implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return Utility.m128refreshBestGuessNumberOfCPUCores$lambda4(file, str);
    }
}
