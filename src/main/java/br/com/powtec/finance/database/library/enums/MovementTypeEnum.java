package br.com.powtec.finance.database.library.enums;

import lombok.Getter;

@Getter
public enum MovementTypeEnum {
  ASSET_RETURN("ASSET_RETURN"),
  ASSET_MOVEMENT("ASSET_MOVEMENT"),
  ACCOUNT("ACCOUNT"),
  CARD("CARD");

  private String name;

  MovementTypeEnum(String name) {
    this.name = name;
  }
}
