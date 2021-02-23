package br.com.airline.companhia.core.domain.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable throwable) {
    super(message, throwable);
  }
}