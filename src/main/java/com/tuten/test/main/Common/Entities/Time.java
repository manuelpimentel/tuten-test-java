package com.tuten.test.main.Common.Entities;

import java.time.LocalTime;

/**
 * @author Manuel Pimentel
 * @version 1.0
 * @description
 * @since 2019-10-02
 */

public class Time
{
    private LocalTime _hour;
    private String _timeZone;

    public Time()
    {
    }

    public LocalTime getHour()
    {
        return _hour;
    }

    public void setHour(LocalTime hour)
    {
        _hour = hour;
    }

    public String getTimeZone()
    {
        return _timeZone;
    }

    public void setTimeZone(String timeZone)
    {
        _timeZone = timeZone;
    }
}
