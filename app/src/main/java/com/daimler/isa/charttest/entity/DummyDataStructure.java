package com.daimler.isa.charttest.entity;

import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/**
 * @author fangsxu
 */
public class DummyDataStructure {
    private String dayOfWeek;
    private boolean isSelected;
    private List<BarEntry> entries;

    public DummyDataStructure() {
    }

    public DummyDataStructure(String dayOfWeek, boolean isSelected, List<BarEntry> entries) {
        this.dayOfWeek = dayOfWeek;
        this.isSelected = isSelected;
        this.entries = entries;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public List<BarEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<BarEntry> entries) {
        this.entries = entries;
    }
}
