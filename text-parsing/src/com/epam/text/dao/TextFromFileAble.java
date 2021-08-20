package com.epam.text.dao;

import com.epam.text.entity.Text;

public interface TextFromFileAble {
    Text getTextFroSource() throws DAOException;
}
