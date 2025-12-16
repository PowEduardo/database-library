package br.com.powtec.finance.database.library.model.dto;

import java.util.List;

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
public class DashboardDTO {
  
  private Double totalPaid;
  private Double totalUnpaid;
  private Double balance;
  private Double creditLimit;
  private Double availableCredit;
  private List<DashboardDetailsDTO> details;
}
