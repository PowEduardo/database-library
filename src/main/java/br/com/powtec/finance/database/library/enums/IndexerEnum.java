package br.com.powtec.finance.database.library.enums;

import lombok.Getter;

@Getter
public enum IndexerEnum {
  CDI("CDI");

  private String name;

  IndexerEnum(String name) {
    this.name = name;
  }
}
