package br.com.powtec.finance.database.library.model.dto.dashboard;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for dashboard/chart data
 * Contains aggregated financial information for cards
 */
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class DashboardDetailsDTO {
  
  private String referenceMonth;
  private BigDecimal value;
  private Boolean paid;
}
