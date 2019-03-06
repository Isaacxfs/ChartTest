package com.daimler.isa.charttest.axisformat;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;

import java.text.DecimalFormat;

/**
 * @author fangsxu
 */
public class XaxisDecimalValueFormatter extends BaseValueFormatter {

    private final DecimalFormat mFormat;
    private final String suffix;
    public XaxisDecimalValueFormatter(String suffix) {
        mFormat = new DecimalFormat("0");
        this.suffix = suffix;
    }
    @Override
    public String getFormattedValue(float value) {
        return mFormat.format(value) + suffix;
    }

    @Override
    public String getAxisLabel(float value, AxisBase axis) {
        if (axis instanceof XAxis) {
            return mFormat.format(value);
        } else if (value > 0) {
            return mFormat.format(value) + suffix;
        } else {
            return mFormat.format(value);
        }
    }
}
