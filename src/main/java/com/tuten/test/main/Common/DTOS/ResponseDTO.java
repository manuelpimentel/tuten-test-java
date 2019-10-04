package com.tuten.test.main.Common.DTOS;

/**
 * @author Manuel Pimentel
 * @version 1.0
 * @description
 * @since 2019-10-03
 */

public class ResponseDTO
{
    private String message;
    private String status;
    private Object response;

    public ResponseDTO(String message, Object response)
    {
        this.message = message;
        this.response = response;
    }

    public ResponseDTO(Object response)
    {
        this.response = response;
    }

    public ResponseDTO(String message, String status, Object response)
    {
        this.message = message;
        this.status = status;
        this.response = response;
    }

    public ResponseDTO(Object response, String status)
    {
        this.status = status;
        this.response = response;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Object getResponse()
    {
        return response;
    }

    public void setResponse(Object response)
    {
        this.response = response;
    }
}
