## Agregar el proyecto como una librería

Esta es la razón de ser del proyecto.
2. Incluir la librería como dependencia en el archivo pom.xml de tu proyecto:

        <dependency>
            <groupId>ni.jug</groupId>
            <artifactId>exchange-rate</artifactId>
            <version>${version.descargada}</version>
        </dependency>

Si no estás seguro sobre el número de versión una vez clonado el proyecto (el número de versión está en el archivo pom.xml), dirigirse a su repositorio local de `maven` y explorar la ruta `.m2/repository/ni/jug` en tu cuenta de usuario del SO y tomar nota de la versión del jar.

## Uso de la libreria

La clase a cargo de recolectar los datos del tipo de cambio oficial es `NiCentralBankExchangeRateScraper` (implementa la interfaz `NiCentralBankExchangeRateClient`). La clase `CommercialBankExchangeRate` extrae la compra/venta de los bancos comerciales. Ambas clases se pueden usar para tener acceso a los datos de la tasa de cambio, pero se recomienda usar la clase `ExchangeRateClient` como unico punto de acceso a todas las operaciones disponibles en la libreria (revisar clase `ExchangeRateCLI` para ver un ejemplo de como se usa). Esta clase es un `facade` donde se oculta el detalle de las implementaciones de los clientes del BCN y los bancos comerciales.

Código de ejemplo para obtener el tipo de cambio oficial del BCN:

        // Consultar por fecha
        Assertions.assertEquals(new BigDecimal("31.9396"), ExchangeRateClient.getOfficialExchangeRate(LocalDate.of(2018, 10, 1)));
        Assertions.assertEquals(new BigDecimal("32.0679"), ExchangeRateClient.getOfficialExchangeRate(LocalDate.of(2018, 10, 31)));

        // Consultar por periodo
        MonthlyExchangeRate monthlyExchangeRate = ExchangeRateClient.getOfficialMonthlyExchangeRate(YearMonth.of(2018, 10));

        Assertions.assertEquals(31, monthlyExchangeRate.size());
        Assertions.assertEquals(new BigDecimal("31.9396"), monthlyExchangeRate.getFirstExchangeRate());
        Assertions.assertEquals(new BigDecimal("32.0679"), monthlyExchangeRate.getLastExchangeRate());
        Assertions.assertEquals(new BigDecimal("31.9994"), monthlyExchangeRate.getExchangeRate(LocalDate.of(2018, 10, 15)));
        Assertions.assertEquals(BigDecimal.ZERO, monthlyExchangeRate.getExchangeRate(LocalDate.of(2018, 9, 30)));
        Assertions.assertFalse(monthlyExchangeRate.isIncomplete());

        LocalDate date1 = LocalDate.of(2018, 10, 1);
        LocalDate date2 = LocalDate.of(2018, 10, 15);
        Map<LocalDate, BigDecimal> rangeOfValues = monthlyExchangeRate.getExchangeRateBetween(date1, date2);
        Assertions.assertEquals(15, rangeOfValues.size());
        Assertions.assertEquals(new BigDecimal("31.9396"), rangeOfValues.get(date1));
        Assertions.assertEquals(new BigDecimal("31.9994"), rangeOfValues.get(date2));

Código de ejemplo para obtener las tasas de los bancos comerciales:

        CommercialBankRequestor commercialBankRequestor = ExchangeRateClient.commercialBankRequestor();
        StringBuilder result = new StringBuilder("\n");
        for (ExchangeRateTrade trade : commercialBankRequestor) {
            result.append(String.format("%-15s", trade.bank()));
            String sell = trade.sell().toPlainString() + (trade.isBestSellPrice() ? "*" : "");
            result.append(String.format("%12s", sell));
            String buy = trade.buy().toPlainString() + (trade.isBestBuyPrice() ? "*" : "");
            result.append(String.format("%12s", buy));
            result.append(String.format("%12s", officialExchangeRate.toPlainString()));
            result.append("\n");
        }

Referirse a los [test unitarios][test unitario] para más ejemplos.

## Uso del CLI (Línea de comandos o Terminal)

Para ejecutar el cli se requiere tener instalado `maven` y `java` con las versiones indicadas en el apartado `Stack`. Cuando se construya el proyecto se debe incluir la propiedad de sistema `-Dcli` para activar el perfil del cli. Lo anterior hara que se cree un archivo `MANIFEST.MF` con la configuracion del classpath y la clase principal (sin este archivo no es posible ejecutar el cli).

Pasos para instalar la librería:

        git clone https://github.com/jugnicaragua/exchange-rate.git
        cd exchange-rate
        mvn package -Dcli
        # Si no se desean ejecutar los test unitarios durante el empaquetamiento del jar
        mvn package -Dcli -DskipTests
        # Ejecutar la aplicación. Referirse a los ejemplos anteriores para mayor información
        cd target/
        java -jar exchange-rate-1.0-SNAPSHOT.jar -date=2018-10-23

Opciones disponibles:

- date: una fecha, un rango o una lista. La fecha debe ser ingresada en formato ISO: yyyy-MM-dd.
- help: Muestra las opciones disponibles y ejemplos de uso.

Ejemplos de ejecución del cli:

        java -jar exchange-rate-<version>.jar -date=2018-10-14


[license]: LICENSE.txt
[test unitario]: src/test/java/ni/jug/exchangerate/ExchangeRateTest.java
