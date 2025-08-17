package sqa.test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sqa.main.Converter;
import sqa.main.CookingConversionCalculator;
import sqa.main.LiquidVolumeConverter;
import sqa.main.MassConverter;
import sqa.main.TemperatureConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CookingBottomUpTest {

    
    @Test
    @DisplayName("TC1: Unit Test for TemperatureConverter")
    void testTemperatureConverter() {
       
        TemperatureConverter converter = new TemperatureConverter();
        
        double actual = converter.convert(212, "fahrenheit", "celsius");
        double expected = 100.0;
        assertEquals(expected, actual);
    }

  
    @Test
    @DisplayName("TC2: Unit Test for MassConverter")
    void testMassConverter() {
        MassConverter converter = new MassConverter();
        double actual = converter.convert(2, "cup", "gram");
        double expected = 250.0;
        assertEquals(expected, actual);
    }
    
    
    @Test
    @DisplayName("TC3: Unit Test for LiquidVolumeConverter")
    void testLiquidVolumeConverter() {
        LiquidVolumeConverter converter = new LiquidVolumeConverter();
        double actual = converter.convert(1, "cup", "ml");
        double expected = 250.0;
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("TC4: Integration Test for CookingConversionCalculator")
    void testFullIntegration() {
        
        Converter realTemp = new TemperatureConverter();
        Converter realMass = new MassConverter();
        Converter realLiquid = new LiquidVolumeConverter();

       
        CookingConversionCalculator calculator = new CookingConversionCalculator(realTemp, realMass, realLiquid);

       
        double actual = calculator.convert(100, "temperature", "celsius", "fahrenheit");
        double expected = 212.0;
       
        assertEquals(expected, actual);
    }
}