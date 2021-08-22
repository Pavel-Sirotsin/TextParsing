package com.epam.text.dao.impl;

import com.epam.text.dao.DAOException;
import com.epam.text.dao.DAOTextAble;
import com.epam.text.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DAOTextImpl implements DAOTextAble {
    private static final Logger logger = LogManager.getLogger(DAOTextImpl.class);

    @Override
    public Text getTextFromSource() throws DAOException {
        Text text;

        try (
                BufferedReader reader = new BufferedReader(new FileReader("src/com/epam/text/source/text.txt"))
        ) {
            StringBuilder sb = new StringBuilder();
            int symbol;

            while ((symbol = reader.read()) != -1) {
                sb.append((char) symbol);
            }

            String content = sb.toString();
            text = new Text(content);

            logger.info("The file was received and an object was created: " + text.getClass().getSimpleName());

        } catch (IOException e) {
            throw new DAOException(e);
        }

        return text;
    }
}
