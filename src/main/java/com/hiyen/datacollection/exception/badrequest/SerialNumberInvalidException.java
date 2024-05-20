package com.hiyen.datacollection.exception.badrequest;

public class SerialNumberInvalidException extends BadRequestException {

    public SerialNumberInvalidException(String serialNumber) {
        super(serialNumber);
    }
}
