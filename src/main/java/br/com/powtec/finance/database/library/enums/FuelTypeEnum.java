package br.com.powtec.finance.database.library.enums;

public enum FuelTypeEnum {

    GASOLINE("Gasolina"),
    ETHANOL("Etanol"),
    DIESEL("Diesel"),
    FLEX("Flex"),
    ELECTRIC("Elétrico"),
    HYBRID("Híbrido");

    private final String description;

    FuelTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
