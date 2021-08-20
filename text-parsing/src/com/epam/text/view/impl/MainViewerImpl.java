package com.epam.text.view.impl;

import com.epam.text.controller.ControllerProvider;
import com.epam.text.controller.Controller;
import com.epam.text.view.MainViewer;

import java.util.Scanner;

public class MainViewerImpl implements MainViewer {
    private final Scanner input = new Scanner(System.in);

    @Override
    public String showMenu() {
       return"";
    }

    @Override
    public String chooseOperation() {
        ControllerProvider provider = ControllerProvider.getInstance();
        Controller controller = provider.getController();

        while (!input.hasNext("[1-2]")) {
            System.err.println("Invalid value! Type 1 or 2!");
            input.next();
        }

        String request = input.next();

        return controller.doAction(request);
    }


}
