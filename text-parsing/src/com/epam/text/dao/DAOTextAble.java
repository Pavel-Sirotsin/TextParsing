package com.epam.text.dao;

import com.epam.text.entity.Text;

public interface DAOTextAble {
    Text getTextFromSource() throws DAOException;
}
