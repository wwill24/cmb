package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.ActivityReport;
import java.util.List;

public class ResponseActivityReports extends ResponseGeneric {
    private List<ActivityReport> results;

    public List<ActivityReport> getActivityReports() {
        return this.results;
    }

    public void setActivityReports(List<ActivityReport> list) {
        this.results = list;
    }
}
