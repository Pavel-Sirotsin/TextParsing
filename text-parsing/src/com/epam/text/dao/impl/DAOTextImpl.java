package com.epam.text.dao.impl;

import com.epam.text.dao.DAOException;
import com.epam.text.dao.DAOTextAble;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DAOTextImpl implements DAOTextAble {
    private static final Logger logger = LogManager.getLogger(DAOTextImpl.class);

    @Override
    public String getTextFromSource() throws DAOException {
        String content = null;

        try (
                BufferedReader reader = new BufferedReader(new FileReader("src/com/epam/text/source/the_statement.txt"))
        ) {
            StringBuilder sb = new StringBuilder();
            int symbol;

            while ((symbol = reader.read()) != -1) {
                sb.append((char) symbol);
            }

            content = sb.toString();

        } catch (IOException e) {
            throw new DAOException(e);
        }

        logger.info("The content from the file was received .length(): " + content.length());

        return content;
    }
}
