package org;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Windows консоль
 */
public abstract class ConsoleMngmnt {
    /**
     * Исполнить команду без вывода
     * @param command команда
     */
    public static void execute(String command){
        try {
            Runtime.getRuntime().exec(command);
        } 
        catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
