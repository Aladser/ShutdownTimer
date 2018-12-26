package org;

import javax.swing.SpinnerListModel;

/**
 * Циклическая числовая модель для JSpinner
 * @author aladser
 */
public final class CyclicNumberModel extends SpinnerListModel{
    private boolean isEditabled = false;
    private final Object firstElement;
    private final Object lastElement;
    
    public void setEditabled(boolean val){
        isEditabled = val;
    }
    
    @Override
    public Object getNextValue() {
        Object rslt = isEditabled ? super.getNextValue() : getValue();

        String a = (String) rslt;
        String b = (String) lastElement;
        try{
            a.compareTo(b);
        }
        catch(java.lang.NullPointerException e){
            return firstElement;
        }
        return rslt;
    }

    @Override
    public Object getPreviousValue() {
        Object rslt = isEditabled ? super.getPreviousValue() : getValue();

        String a = (String) rslt;
        String b = (String) lastElement;
        try{
            a.compareTo(b);
        }
        catch(java.lang.NullPointerException e){
            return lastElement;
        }
        return rslt;
    }
    
    public CyclicNumberModel(Object[] arr){
        super(arr);
        firstElement = arr[0];
        lastElement = arr[arr.length-1];
    }
}
