package com.tuten.test.main.Logic.Commands;

import com.tuten.test.main.Common.Entities.Time;
import com.tuten.test.main.Exceptions.LogicException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Manuel Pimentel
 * @version 1.0
 * @description
 * @since 2019-10-02
 */

@Service
public class ParseDateCommand implements ICommand<Time>
{
    private Time _time;
    private Time _response;

    @Override
    public void initCommand(Object... args)
    {
        _time = (Time) args[0];
    }

    @Override
    public void execute() throws LogicException
    {
        try
        {
            _response = new Time();
            final ZoneId defaultZone = ZoneId.systemDefault();
            final LocalDateTime ldt = LocalDateTime.now();
            final ZonedDateTime localZoneTime = ldt.atZone(defaultZone);

            final ZoneId zone = ZoneId.of(_time.getTimeZone());
            final ZonedDateTime zdt = localZoneTime.withZoneSameInstant(zone);

            _response.setHour(zdt.toLocalTime());
            _response.setTimeZone(_time.getTimeZone());
        }catch (Exception e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public Time getResult()
    {
        return _response;
    }
}
