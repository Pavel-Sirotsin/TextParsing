package com.epam.text.controller.impl;

import com.epam.text.controller.Command;
import com.epam.text.entity.Text;
import com.epam.text.service.ServiceException;
import com.epam.text.service.ServiceProvider;
import com.epam.text.service.TextLauncher;
import com.epam.text.service.TextService;
import com.epam.text.view.TextViewer;
import com.epam.text.view.ViewerProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeFirstWordOnLast implements Command {
    private static final Logger logger = LogManager.getLogger(ChangeFirstWordOnLast.class);

    @Override
    public void execute() {
        ServiceProvider logic = ServiceProvider.getInstance();
        TextLauncher launcher = logic.getLauncherImpl();
        TextService service = logic.getServiceImpl();

        ViewerProvider view = ViewerProvider.getInstance();
        TextViewer textViewer = view.getTextViewer();

        try {
            launcher.setContent();
        } catch (ServiceException e) {
            logger.error("Check source file!", e);
        }

        launcher.splitTextIntoPart();

        Text text = TextLauncher.ORIGIN;

        service.changeFirstWordOnLast(text);
        logger.info("first word in each sentence was changed on last");

        textViewer.makeReadableAnswer(text);
    }
}
