package it.unibo.deathnote.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImplementation implements DeathNote{
    Long lastNameWrittenTime = 0L;
    
    private ArrayList<String> names;
    private HashMap<Integer,String> causes;
    private HashMap<Integer,String> details;

    public static final String DEFAULT_DEATH_CAUSE = "Heart attach";
    public static final String DEFAULT_DEATH_DETAILS = "Heart attach";

    public DeathNoteImplementation(){
        names = new ArrayList<String>();
        causes = new HashMap<Integer,String>();
        details = new HashMap<Integer,String>();
    }

    @Override
    public String getRule(int ruleNumber)throws IllegalArgumentException {
        Objects.requireNonNull(RULES);
        if(ruleNumber >= RULES.size() || ruleNumber <= 0){
            throw new IllegalArgumentException("ruleNumber argument MUST be in range 1 to "+RULES.size());
        }
        return Objects.requireNonNull(RULES.get(ruleNumber).isEmpty() ? null : RULES.get(ruleNumber));
    }

    @Override
    public void writeName(String name) {
        Objects.requireNonNull(names);
        Objects.requireNonNull(name);
        if(!names.contains(name)){
            names.add(name);
        }
        lastNameWrittenTime = System.currentTimeMillis();
    }

    @Override
    public boolean writeDeathCause(String cause) {
        Objects.requireNonNull(this.names);
        Objects.requireNonNull(this.causes);

        if(names.isEmpty() || cause == null){
            throw new IllegalStateException();
        }
        if(System.currentTimeMillis() - lastNameWrittenTime <= 40){
            return this.causes.put(Objects.hash(names.getLast()), cause)!= null;
        }else{
            return false;
        }
    }

    @Override
    public boolean writeDetails(String details) {
        Objects.requireNonNull(this.names);
        Objects.requireNonNull(this.details);

        if(names.isEmpty() || details == null){
            throw new IllegalStateException();
        }
        if(System.currentTimeMillis() - lastNameWrittenTime <= 6040){
            return this.details.put(Objects.hash(names.getLast()), details) != null;
        }else{
            return false;
        }
    }

    @Override
    public String getDeathCause(String name) {
        Objects.requireNonNull(this.names);
        Objects.requireNonNull(this.causes);

        if(name != null || isNameWritten(name)){
            if(causes.get( Objects.hash(name)).isEmpty()){
                return causes.get( Objects.hash(name));
            }else{
                return DEFAULT_DEATH_CAUSE;
            }
        }else{
            throw new IllegalStateException();
        }
    }

    @Override
    public String getDeathDetails(String name) {
        Objects.requireNonNull(this.names);
        Objects.requireNonNull(this.details);

        if(name != null || isNameWritten(name)){
            if(this.details.get( Objects.hash(name)).isEmpty()){
                return this.details.get( Objects.hash(name));
            }else{
                return DEFAULT_DEATH_DETAILS;
            }
        }else{
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean isNameWritten(String name) {
        Objects.requireNonNull(name);
        return(names.contains(name));         
    }
    
}