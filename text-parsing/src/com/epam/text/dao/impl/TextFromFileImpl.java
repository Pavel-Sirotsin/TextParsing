package com.epam.text.dao.impl;

import com.epam.text.dao.DAOException;
import com.epam.text.dao.TextFromFileAble;
import com.epam.text.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFromFileImpl implements TextFromFileAble {
    private static final Logger logger = LogManager.getLogger(TextFromFileImpl.class);

    @Override
    public Text getTextFroSource() throws DAOException {
        Text text;

        try (
                BufferedReader reader = new BufferedReader(new FileReader("text-parsing/src/com/epam/text/source/text.txt"))
        ) {
            StringBuilder sb = new StringBuilder();
            int symbol;

            while ((symbol = reader.read()) != -1) {
                sb.append((char) symbol);
            }

            String content = sb.toString();
            text = new Text(content);

            logger.info("was gotten file from source and created entity: " + text.getClass().getSimpleName());

        } catch (IOException e) {
            throw new DAOException(e);
        }

        return text;
    }
}
