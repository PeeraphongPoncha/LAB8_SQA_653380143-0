package sqa.test;

import sqa.main.Converter;

public class ConverterStub implements Converter{
	private double returnValue;

    public void setReturnValue(double value) {
        this.returnValue = value;
    }

    @Override
    public double convert(double value, String fromUnit, String toUnit) {
        return this.returnValue;
    }
}
