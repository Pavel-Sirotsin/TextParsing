package com.epam.text.controller.impl;

import com.epam.text.controller.CommandProvider;
import com.epam.text.controller.Command;
import com.epam.text.controller.Controller;

public class ControllerImpl implements Controller {

    private CommandProvider provider = new CommandProvider();

    @Override
    public String doAction(String operation) {
        // request form: 'number of operation'

        Command current = provider.getCommand(operation);

        return current.execute();
    }
}
