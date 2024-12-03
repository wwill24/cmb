package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.l0;
import com.google.protobuf.m0;

public interface GaugeMetadataOrBuilder extends m0 {
    int getCpuClockRateKhz();

    int getCpuProcessorCount();

    /* synthetic */ l0 getDefaultInstanceForType();

    int getDeviceRamSizeKb();

    int getMaxAppJavaHeapMemoryKb();

    int getMaxEncouragedAppJavaHeapMemoryKb();

    @Deprecated
    String getProcessName();

    @Deprecated
    ByteString getProcessNameBytes();

    boolean hasCpuClockRateKhz();

    boolean hasCpuProcessorCount();

    boolean hasDeviceRamSizeKb();

    boolean hasMaxAppJavaHeapMemoryKb();

    boolean hasMaxEncouragedAppJavaHeapMemoryKb();

    @Deprecated
    boolean hasProcessName();

    /* synthetic */ boolean isInitialized();
}
