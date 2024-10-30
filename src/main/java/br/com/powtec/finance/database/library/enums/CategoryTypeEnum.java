package br.com.powtec.finance.database.library.enums;

public enum CategoryTypeEnum {

    INVESTMENT("INVESTMENT"),
    FOOD("FOOD"),
    CARD("CARD"),
    TRANSPORT("TRANSPORT"),
    HEALTH("HEALTH"),
    MONTHLY_EXPENSES("HEALTH");

    private String name;

    CategoryTypeEnum (String name) {
        this.name = name;
    }
}
