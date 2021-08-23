package com.epam.text.controller.impl;

import com.epam.text.controller.Command;
import com.epam.text.entity.Text;
import com.epam.text.service.ServiceProvider;
import com.epam.text.service.TextLauncher;
import com.epam.text.view.TextViewer;
import com.epam.text.view.ViewerProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReassembleText implements Command {
    private static final Logger logger = LogManager.getLogger(ReassembleText.class);
    @Override
    public void execute() {
        ServiceProvider logic = ServiceProvider.getInstance();
        TextLauncher launcher = logic.getLauncherImpl();

        ViewerProvider view = ViewerProvider.getInstance();
        TextViewer textViewer = view.getTextViewer();

        launcher.reassembleText();
        logger.info("the text was reassembled");

        Text workSample = TextLauncher.ORIGIN;

        textViewer.makeReadableAnswer(workSample);

    }
}
