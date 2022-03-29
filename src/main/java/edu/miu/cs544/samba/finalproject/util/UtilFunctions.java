package edu.miu.cs544.samba.finalproject.util;

import edu.miu.cs544.samba.finalproject.exception.ResourceNotFoundException;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;

public class UtilFunctions {


    public static SuccessResponse handleSuccessResponse(Boolean status, String message) {
        return new SuccessResponse(status, message);
    }

    public static ResourceNotFoundException handleResourceNotFoundException(String message) {
        throw new ResourceNotFoundException(message);
    }
}
