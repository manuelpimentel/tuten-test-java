package com.tuten.test.main.Logic.Commands;

import com.tuten.test.main.Exceptions.LogicException;

/**
 * @author Manuel Pimentel
 * @version 1.0
 * @description
 * @since 2019-10-02
 */

public interface ICommand<T>
{
    void initCommand( Object... args );
    void execute() throws LogicException;
    T getResult();
}
