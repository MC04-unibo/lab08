package it.unibo.deathnote.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import it.unibo.deathnote.api.DeathNote;

class DeathNoteImplementation implements DeathNote{
    ArrayList<String> names;
    Long lastNameWrittenTime = 0L;
    HashMap<Integer,String> causes;
    HashMap<Integer,String> details;

    DeathNoteImplementation(){
        names = new ArrayList<String>();
        causes = new HashMap<Integer,String>();
        details = new HashMap<Integer,String>();
    }

    @Override
    public String getRule(int ruleNumber) {
        Objects.requireNonNull(RULES);
        if(ruleNumber > RULES.size() || ruleNumber <= 0){
            throw new IllegalArgumentException("ruleNumber argument MUST be in range 1 to "+RULES.size());
        }
        return Objects.requireNonNull(RULES.get(ruleNumber).isEmpty() ? null : RULES.get(ruleNumber));
    }

    @Override
    public void writeName(String name) {
        Objects.requireNonNull(name);
        if(!names.contains(name)){
            names.add(name);
        }
        lastNameWrittenTime = System.currentTimeMillis();
    }

    @Override
    public boolean writeDeathCause(String cause) {
        if(System.currentTimeMillis() - lastNameWrittenTime < 40){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean writeDetails(String details) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeDetails'");
    }

    @Override
    public String getDeathCause(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeathCause'");
    }

    @Override
    public String getDeathDetails(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeathDetails'");
    }

    @Override
    public boolean isNameWritten(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isNameWritten'");
    }
    
}