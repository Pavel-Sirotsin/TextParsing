package com.epam.text.service;

import com.epam.text.entity.Text;

public interface TextLauncher {
    Text ORIGIN = new Text();

    int reassembleText();

    void splitTextIntoPart() ;

    void setContent() throws ServiceException;


}
