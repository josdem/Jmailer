package com.jos.dem.state;

import com.jos.dem.status.TimoneErrorStatus;

/**
 * @author josdem
 * @understands A class who knows how return error code as string
 */

public class ErrorState {

  public static String getErrorCode(TimoneErrorStatus timoneErrorStatus){
    return "&error=" + timoneErrorStatus.getValue() + "&message=" + timoneErrorStatus.getMessage();
  }

  public static String getJsonErrorCode(TimoneErrorStatus timoneErrorStatus) {
    return "{\"error\":\"" + timoneErrorStatus.getValue() + "\", \"message\": \"" + timoneErrorStatus.getMessage() + "\"}";
  }

}
