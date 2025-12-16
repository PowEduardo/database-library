package br.com.powtec.finance.database.library.converter;

import java.time.YearMonth;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * JPA Converter for YearMonth.
 * Converts between java.time.YearMonth and String (YYYY-MM format) in the database.
 * 
 * This converter ensures that YearMonth values are properly serialized/deserialized
 * when persisted to PostgreSQL as VARCHAR(7) columns.
 */
@Converter(autoApply = true)
public class YearMonthConverter implements AttributeConverter<YearMonth, String> {

  /**
   * Convert YearMonth entity attribute to String database column.
   * @param attribute YearMonth value (e.g., YearMonth.of(2025, 12))
   * @return String representation in YYYY-MM format (e.g., "2025-12")
   */
  @Override
  public String convertToDatabaseColumn(YearMonth attribute) {
    if (attribute == null) {
      return null;
    }
    return attribute.toString(); // YearMonth.toString() returns "YYYY-MM" format
  }

  /**
   * Convert String database column to YearMonth entity attribute.
   * @param dbData String value in YYYY-MM format (e.g., "2025-12")
   * @return YearMonth entity attribute
   */
  @Override
  public YearMonth convertToEntityAttribute(String dbData) {
    if (dbData == null || dbData.isEmpty()) {
      return null;
    }
    return YearMonth.parse(dbData);
  }
}
