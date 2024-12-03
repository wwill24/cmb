package com.mparticle.segmentation;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public class SegmentMembership {
    StringBuilder list;
    private ArrayList<Segment> segments;

    public SegmentMembership(@NonNull ArrayList<Segment> arrayList) {
        this.segments = arrayList;
    }

    @NonNull
    public String getCommaSeparatedIds() {
        if (this.list == null) {
            this.list = new StringBuilder();
            Iterator<Segment> it = this.segments.iterator();
            while (it.hasNext()) {
                this.list.append(it.next().getId());
                this.list.append(", ");
            }
            if (this.list.length() > 0) {
                StringBuilder sb2 = this.list;
                sb2.delete(sb2.length() - 2, this.list.length());
            }
        }
        return this.list.toString();
    }

    @NonNull
    public ArrayList<Segment> getSegments() {
        return this.segments;
    }

    @NonNull
    public String toString() {
        return getCommaSeparatedIds();
    }
}
