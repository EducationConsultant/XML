package com.firma.models.presek;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;

public class MyValidationEventHandler implements ValidationEventHandler {

    @Override
    public boolean handleEvent(ValidationEvent event) {
        // TODO Auto-generated method stub
        if (event.getSeverity() != ValidationEvent.WARNING) {
            ValidationEventLocator validationEventLocator = event.getLocator();
            if(validationEventLocator.getLineNumber()==-1)
                return true;
            System.out.println("ERROR: Line "
                    + validationEventLocator.getLineNumber() + ": Col"
                    + validationEventLocator.getColumnNumber() + ": "
                    + event.getMessage());
               
            // Dalje izvršavanje se prekida
            return false;
        } else {
            ValidationEventLocator validationEventLocator = event.getLocator();
            System.out.println("WARNING: Line "
                    + validationEventLocator.getLineNumber() + ": Col"
                    + validationEventLocator.getColumnNumber() + ": "
                    + event.getMessage());

            // Nastavlja se dalje izvršavanje
            return true;
        }

    }

}