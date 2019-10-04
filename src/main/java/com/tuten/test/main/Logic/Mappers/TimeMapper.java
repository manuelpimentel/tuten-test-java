package com.tuten.test.main.Logic.Mappers;

import com.tuten.test.main.Common.DTOS.TimeDTO;
import com.tuten.test.main.Common.Entities.Time;
import com.tuten.test.main.Exceptions.MappingException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Manuel Pimentel
 * @version 1.0
 * @description
 * @since 2019-10-02
 */

public class TimeMapper
{
    private static final String DATE_FORMAT = "HH:mm:ss";

    public static TimeDTO timeEntityToDtoMapper(Time time) throws MappingException
    {
        if (time.getHour() == null || time.getTimeZone() == null)
        {
            throw new MappingException("INVALID_DATA");
        }

        final TimeDTO timeDTO = new TimeDTO();
        timeDTO.setHour(time.getHour().toString());
        timeDTO.setTimeZone( time.getTimeZone() );
        return timeDTO;
    }

    public static Time timeDtoToEntity(TimeDTO timeDTO) throws MappingException
    {

        if (timeDTO.getHour() == null || timeDTO.getTimeZone() == null)
        {
            throw new MappingException("INVALID_DATA");
        }

        if ( timeDTO.getHour().split(":").length != 3 )
        {
            throw new MappingException("INVALID_TIME_FORMAT");
        }

        validateTimeRange(timeDTO.getHour());
        validateTimeZoneRange(timeDTO.getTimeZone());

        final Time time = new Time();
        try
        {
            time.setHour(LocalTime.parse(timeDTO.getHour(), DateTimeFormatter.ofPattern(DATE_FORMAT)) );
        }catch (DateTimeParseException e){
            throw new MappingException(e.getMessage());
        }
        time.setTimeZone(timeDTO.getTimeZone());
        return time;
    }


    private static void validateTimeRange(String timeStr ) throws MappingException
    {
        List<Integer> timeList = Arrays.stream(timeStr.split(":"))
                .map(t -> Integer.valueOf(t) )
                .collect(Collectors.toList());

        if (
                timeList.get(0) > 23 || timeList.get(0) < 0 ||
                timeList.get(1) > 59 || timeList.get(1) < 0 ||
                timeList.get(2) > 59 || timeList.get(2) < 0

        )
        {
            throw new MappingException("INVALID_TIME_FORMAT");
        }
    }

    private static void validateTimeZoneRange( String timeZone ) throws MappingException
    {
        final Integer timeZoneInt = Integer.parseInt(timeZone);
        if (timeZoneInt < -12  || timeZoneInt > 14 )
        {
            throw new MappingException("INVALID_TIME_ZONE_FORMAT");
        }
    }

}
