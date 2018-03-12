package com.flariz.sales.Controllers.Basic;

import org.apache.log4j.Logger;
import org.springframework.data.repository.support.QueryMethodParameterConversionException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@ControllerAdvice
public class ExceptionControllerAdvice {

  private Logger logger = Logger.getLogger(ExceptionControllerAdvice.class.getName());
  private enum ErrorLevel {INFO,ERROR,WARNING}

  @ExceptionHandler(IOException.class)
  public ResponseEntity<HashMap<String, String>> exceptionHandler(IOException ex) {
    HashMap<String, String> body = this.createBody(ex, ErrorLevel.ERROR);
    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<HashMap<String, String>> exceptionHandler(ResourceNotFoundException ex) {

    HashMap<String, String> mapResult = new HashMap<>();
    mapResult.put("message", ex.getMessage());
    return new ResponseEntity<>(mapResult, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(SQLException.class)
  public ResponseEntity<HashMap<String, String>> exceptionHandler(SQLException ex) {
    HashMap<String, String> body = this.createBody(ex, ErrorLevel.ERROR);
    this.logger.error(ex.getSQLState());
    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(IllegalAccessException.class)
  public ResponseEntity<HashMap<String, String>> exceptionHandler(IllegalAccessException ex) {
    HashMap<String, String> body = this.createBody(ex, ErrorLevel.ERROR);
    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<HashMap<String, String>> exceptionHandler(Exception ex) {
    HashMap<String, String> body = this.createBody(ex, ErrorLevel.ERROR);
    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<HashMap<String, String>> exceptionHandler(NullPointerException ex) {
    ex.getLocalizedMessage();
    this.logger.error(ex.getLocalizedMessage());
    HashMap<String, String> body = this.createBody(ex, ErrorLevel.ERROR);
    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(QueryMethodParameterConversionException.class)
  public ResponseEntity<HashMap<String, String>> exceptionHandler(QueryMethodParameterConversionException ex) {
    HashMap<String, String> body = this.createBody(ex, ErrorLevel.ERROR);
    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private HashMap<String, String> createBody( Exception ex ) {
    this.logger.error( ex.getMessage() );
    HashMap<String, String> mapResult = new HashMap<>();
    mapResult.put("message", ex.getMessage());
    return mapResult;
  }


  private HashMap<String, String> createBody(Exception ex, ErrorLevel level) {
    logger = Logger.getLogger(getClassName(ex));
    switch (level){
      case INFO:
        this.logger.info(ex.getMessage(),ex);
        break;
      case WARNING:
        this.logger.warn(ex.getMessage(),ex);
        break;
      case ERROR:
        this.logger.error(ex.getMessage(),ex);
        break;
    }

    HashMap<String, String> mapResult = new HashMap<>();
    mapResult.put("message", ex.getMessage());
    return mapResult;
  }
  private String getClassName(Exception ex){
    return ex.getStackTrace()[0].getClassName();
  }

}
