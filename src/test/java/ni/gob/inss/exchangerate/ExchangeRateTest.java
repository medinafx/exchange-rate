package ni.gob.inss.exchangerate;

import ni.gob.inss.exchangerate.scraper.TipoCambioException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExchangeRateTest {

    @Test
    public void testExchangeRateAtSpecificDate() throws TipoCambioException {
        assertEquals(Double.parseDouble("31.9396"), TipoCambioClient.getTasaDeCambioOficial(2018, 10, 1));
        assertEquals(Double.parseDouble("32.0679"), TipoCambioClient.getTasaDeCambioOficial(2018, 10, 31));
    }

}
