package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount)
    {
        PhoneNumber[] phoneNumbers = new PhoneNumber[phoneNumberCount];
        for (int i =0;i<phoneNumbers.length;i++){
            phoneNumbers[i] = createRandomPhoneNumber();
        }
        return phoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber()
    {
        RandomNumberFactory randomNum;
        return createPhoneNumberSafely(RandomNumberFactory.createInteger(100,900),RandomNumberFactory.createInteger(100,900), RandomNumberFactory.createInteger(100,900));
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
            String number = String.format("(%03d)-%03d-%04d",areaCode,centralOfficeCode,phoneLineCode);
        try
        {
            if(areaCode ==0) throw  new InvalidPhoneNumberFormatException();
            return createPhoneNumber(number);
        } catch (InvalidPhoneNumberFormatException e)
        {
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        PhoneNumber phoneNumber= null; ;
                phoneNumber = new PhoneNumber(phoneNumberString);
                System.out.println( "Attempting to create a new PhoneNumber with a value of "+phoneNumberString);

        return phoneNumber;

  }
}