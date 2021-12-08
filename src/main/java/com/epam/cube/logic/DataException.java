package com.epam.cube.logic;

public class DataException extends Exception {

     public DataException(){
          super();
     }

     public DataException(String message){
          super(message);
     }

     public DataException(String message, Throwable cause){
          super(message, cause);
     }
}
