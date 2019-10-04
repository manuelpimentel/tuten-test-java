package com.tuten.test.main.Services;

import com.google.gson.Gson;
import com.tuten.test.main.Common.DTOS.ResponseDTO;
import com.tuten.test.main.Common.DTOS.TimeDTO;
import com.tuten.test.main.Exceptions.LogicException;
import com.tuten.test.main.Exceptions.MappingException;
import com.tuten.test.main.Logic.Commands.ParseDateCommand;
import com.tuten.test.main.Logic.Mappers.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Pimentel
 * @version 1.0
 * @description
 * @since 2019-10-02
 */

@RestController
public class DateController
{

    @Autowired
    private Gson gson;

    @Autowired
    private ParseDateCommand _parseDateCommand;

    @PostMapping(value = "/time")
    private ResponseEntity parseDate(@RequestBody String body)
    {
        try
        {
            _parseDateCommand.initCommand( TimeMapper.timeDtoToEntity( gson.fromJson(body, TimeDTO.class) ) );
            _parseDateCommand.execute();

            return new ResponseEntity( new ResponseDTO(TimeMapper.timeEntityToDtoMapper(_parseDateCommand.getResult()),
                    "SUCCESS" ),
                    HttpStatus.OK);
        }catch (LogicException | MappingException l)
        {
            l.printStackTrace();
            return new ResponseEntity( new ResponseDTO(l.getMessage(),
                    "FAILURE" ,null ), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity( new ResponseDTO(e.getMessage(),
                    "FAILURE", null ), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
