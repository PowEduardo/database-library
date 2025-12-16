package br.com.powtec.finance.database.library.service;

import br.com.powtec.finance.database.library.model.dto.CreditCardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service interface for Credit Card operations.
 * Defines the contract for credit card management across all layers.
 */
public interface ICardService {

  /**
   * Create a new credit card.
   */
  CreditCardDTO create(CreditCardDTO dto);

  /**
   * Create multiple credit cards in batch.
   */
  List<CreditCardDTO> createInBatch(List<CreditCardDTO> dtos);

  /**
   * Find credit card by ID with all relationships loaded.
   */
  CreditCardDTO findById(Long id);

  /**
   * Update an existing credit card.
   */
  CreditCardDTO update(Long id, CreditCardDTO dto);

  /**
   * Search credit cards with pagination and filters.
   * @param pageable pagination info
   * @param filters optional query string (e.g., card name)
   */
  Page<CreditCardDTO> search(Pageable pageable, String filters);

  /**
   * Get detailed credit card info (with statements and calculations).
   */
  CreditCardDTO getDetails(Long id);

  /**
   * Delete a credit card by ID.
   */
  void delete(Long id);
}
