package br.com.powtec.finance.database.library.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDTO {
  private Long id;
  private String bank;
  private String number;
  private String branch;
  private Boolean primary;
  private LocalDate createDate;
}
