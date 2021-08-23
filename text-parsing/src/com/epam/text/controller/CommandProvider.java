package com.epam.text.controller;


import com.epam.text.controller.impl.ChangeFirstWordOnLast;
import com.epam.text.controller.impl.ChangeRandomlyWordByTheLength;
import com.epam.text.controller.impl.ReassembleText;
import com.epam.text.controller.impl.SentenceInWordIncreasing;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("1", new SentenceInWordIncreasing());
        commands.put("2", new ChangeFirstWordOnLast());
        commands.put("3", new ChangeRandomlyWordByTheLength());
        commands.put("4", new ReassembleText());

    }

    public Command getCommand(String operation) {
        return commands.get(operation);
    }
}
