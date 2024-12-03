package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Device extends CrashlyticsReport.Session.Device {
    private final int arch;
    private final int cores;
    private final long diskSpace;
    private final String manufacturer;
    private final String model;
    private final String modelClass;
    private final long ram;
    private final boolean simulator;
    private final int state;

    static final class Builder extends CrashlyticsReport.Session.Device.Builder {
        private Integer arch;
        private Integer cores;
        private Long diskSpace;
        private String manufacturer;
        private String model;
        private String modelClass;
        private Long ram;
        private Boolean simulator;
        private Integer state;

        Builder() {
        }

        public CrashlyticsReport.Session.Device build() {
            String str = "";
            if (this.arch == null) {
                str = str + " arch";
            }
            if (this.model == null) {
                str = str + " model";
            }
            if (this.cores == null) {
                str = str + " cores";
            }
            if (this.ram == null) {
                str = str + " ram";
            }
            if (this.diskSpace == null) {
                str = str + " diskSpace";
            }
            if (this.simulator == null) {
                str = str + " simulator";
            }
            if (this.state == null) {
                str = str + " state";
            }
            if (this.manufacturer == null) {
                str = str + " manufacturer";
            }
            if (this.modelClass == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Device(this.arch.intValue(), this.model, this.cores.intValue(), this.ram.longValue(), this.diskSpace.longValue(), this.simulator.booleanValue(), this.state.intValue(), this.manufacturer, this.modelClass);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Device.Builder setArch(int i10) {
            this.arch = Integer.valueOf(i10);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setCores(int i10) {
            this.cores = Integer.valueOf(i10);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setDiskSpace(long j10) {
            this.diskSpace = Long.valueOf(j10);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setManufacturer(String str) {
            if (str != null) {
                this.manufacturer = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        public CrashlyticsReport.Session.Device.Builder setModel(String str) {
            if (str != null) {
                this.model = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        public CrashlyticsReport.Session.Device.Builder setModelClass(String str) {
            if (str != null) {
                this.modelClass = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        public CrashlyticsReport.Session.Device.Builder setRam(long j10) {
            this.ram = Long.valueOf(j10);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setSimulator(boolean z10) {
            this.simulator = Boolean.valueOf(z10);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setState(int i10) {
            this.state = Integer.valueOf(i10);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
        if (this.arch == device.getArch() && this.model.equals(device.getModel()) && this.cores == device.getCores() && this.ram == device.getRam() && this.diskSpace == device.getDiskSpace() && this.simulator == device.isSimulator() && this.state == device.getState() && this.manufacturer.equals(device.getManufacturer()) && this.modelClass.equals(device.getModelClass())) {
            return true;
        }
        return false;
    }

    @NonNull
    public int getArch() {
        return this.arch;
    }

    public int getCores() {
        return this.cores;
    }

    public long getDiskSpace() {
        return this.diskSpace;
    }

    @NonNull
    public String getManufacturer() {
        return this.manufacturer;
    }

    @NonNull
    public String getModel() {
        return this.model;
    }

    @NonNull
    public String getModelClass() {
        return this.modelClass;
    }

    public long getRam() {
        return this.ram;
    }

    public int getState() {
        return this.state;
    }

    public int hashCode() {
        int i10;
        long j10 = this.ram;
        long j11 = this.diskSpace;
        int hashCode = (((((((((this.arch ^ 1000003) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.cores) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        if (this.simulator) {
            i10 = 1231;
        } else {
            i10 = 1237;
        }
        return ((((((hashCode ^ i10) * 1000003) ^ this.state) * 1000003) ^ this.manufacturer.hashCode()) * 1000003) ^ this.modelClass.hashCode();
    }

    public boolean isSimulator() {
        return this.simulator;
    }

    public String toString() {
        return "Device{arch=" + this.arch + ", model=" + this.model + ", cores=" + this.cores + ", ram=" + this.ram + ", diskSpace=" + this.diskSpace + ", simulator=" + this.simulator + ", state=" + this.state + ", manufacturer=" + this.manufacturer + ", modelClass=" + this.modelClass + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Device(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        this.arch = i10;
        this.model = str;
        this.cores = i11;
        this.ram = j10;
        this.diskSpace = j11;
        this.simulator = z10;
        this.state = i12;
        this.manufacturer = str2;
        this.modelClass = str3;
    }
}
