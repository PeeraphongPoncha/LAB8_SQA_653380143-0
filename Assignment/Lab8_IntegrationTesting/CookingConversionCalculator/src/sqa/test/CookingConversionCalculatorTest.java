package sqa.test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sqa.main.Converter;
import sqa.main.CookingConversionCalculator;
import sqa.main.LiquidVolumeConverter;
import sqa.main.MassConverter;
import sqa.main.TemperatureConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CookingConversionCalculatorTest {

    @Test 
    @DisplayName("TC1: ทดสอบ Controller ด้วย Stub ทั้งหมด")
    void testControllerWithAllStubs() {
       
        ConverterStub tempStub = new ConverterStub();
        tempStub.setReturnValue(100.0);
        ConverterStub massStub = new ConverterStub();
        massStub.setReturnValue(-1.0);
        ConverterStub liquidStub = new ConverterStub();
        liquidStub.setReturnValue(-1.0);
        CookingConversionCalculator calculator = new CookingConversionCalculator(tempStub, massStub, liquidStub);

       
        double actual = calculator.convert(212, "temperature", "fahrenheit", "celsius");
        double expected = 100.0;
     
        assertEquals(expected, actual, "ผลลัพธ์การแปลงอุณหภูมิด้วย Stub ควรเป็น 100.0");
    }

    @Test
    @DisplayName("TC2: ทดสอบการรวม TemperatureConverter ตัวจริง")
    void testIntegrationWithRealTemperatureConverter() {
      
        Converter realTemp = new TemperatureConverter(); 
        ConverterStub massStub = new ConverterStub();
        massStub.setReturnValue(-1.0);
        ConverterStub liquidStub = new ConverterStub();
        liquidStub.setReturnValue(-1.0);
        CookingConversionCalculator calculator = new CookingConversionCalculator(realTemp, massStub, liquidStub);

       
        double actual = calculator.convert(212, "temperature", "fahrenheit", "celsius");
        double expected = 100.0;
        
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TC3: ทดสอบการรวม MassConverter ตัวจริง")
    void testIntegrationWithRealMassConverter() {
       
        Converter realTemp = new TemperatureConverter();
        Converter realMass = new MassConverter(); 
        ConverterStub liquidStub = new ConverterStub();
        liquidStub.setReturnValue(-1.0);
        CookingConversionCalculator calculator = new CookingConversionCalculator(realTemp, realMass, liquidStub);
        
      
        double actual = calculator.convert(2, "mass", "cup", "gram");
        double expected = 250.0;
       
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TC4: ทดสอบการรวมทุกโมดูล (Full Integration)")
    void testFullIntegration() {
        
        Converter realTemp = new TemperatureConverter();
        Converter realMass = new MassConverter();
        Converter realLiquid = new LiquidVolumeConverter(); 
        CookingConversionCalculator calculator = new CookingConversionCalculator(realTemp, realMass, realLiquid);

        
        double actual = calculator.convert(1, "liquid", "cup", "ml");
        double expected = 250.0;
        
        assertEquals(expected, actual);
    }
}
