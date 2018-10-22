package com.valuedge.scsc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super("Resource Not Found: Value:"+fieldValue+":"+resourceName+":"+resourceName );
        this.resourceName = resourceName;
       
    }

    public String getResourceName() {
        return resourceName;
    }
}
