package project;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class ScannerC {
    
    private String _string = "";
    
    public ScannerC(String namePath) throws IOException{
        String theString;

        File file = new File(namePath);
        Scanner scanner = new Scanner(file);
        theString = scanner.nextLine();
       
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            theString = theString + "\n" + temp;
        }
        scanner.close();
        
        
        _string = theString+"\n";
        //charArray = new ArrayList();//trabajar todo con ArrayList
        //for (char c : theString.toCharArray())
        //    charArray.add(c);
        
        //length = charArray.size();
    }

    /**
     * @return the _string
     */
    public String getString() {
        return _string;
    }

    /**
     * @param _string the _string to set
     */
    public void setString(String _string) {
        this._string = _string;
    }
    
    
}
