package br.com.powtec.finance.database.library.model.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AssetDetailsDTO {
  private BigDecimal amount;
  private BigDecimal average;
  private BigDecimal currentValue;
  private BigDecimal difference;
  private BigDecimal monthlyReturn;
  private BigDecimal lastReturn;
  private BigDecimal dy;
  private BigDecimal ady;
  private Integer targetAmount;
  private BigDecimal paidValue;
  private BigDecimal returns;
  private BigDecimal nextDividend;
}
