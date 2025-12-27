package br.com.powtec.finance.database.library.model.dto.dashboard;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.powtec.finance.database.library.enums.ChartTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for dashboard/chart data
 */
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class DashboardDTO {
  private ChartTypeEnum chartType;
  private BigDecimal totalPaid;
  private BigDecimal totalUnpaid;
  private BigDecimal balance;
  private BigDecimal creditLimit;
  private BigDecimal availableCredit;
  private AccountDashboardDetailsDTO accountDetails;
  private List<DashboardDetailsDTO> details;
  private List<DashboardBarChartDetailsDTO> barChartDetails;
}
