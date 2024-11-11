package it.unibo.deathnote;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;

class TestDeathNote {
    public static void main(String args[]){
        DeathNoteImplementation deathNote = new DeathNoteImplementation();

        int ruleIndex = 0;
        for(String rule : DeathNote.RULES){
            if(ruleIndex == 0){
                try{
                    System.out.println(deathNote.getRule(ruleIndex));
                }catch(IllegalArgumentException e){
                    System.out.println("O|getRule(): Exception successfully collected.");
                }
            }else{
               try{
                    if(deathNote.getRule(ruleIndex).equals(rule)){
                        System.out.println("O|getRule(): RULE "+ruleIndex+" correctly obtained.");
                    }else{
                        System.out.println("#|getRule(): RULE "+ruleIndex+" doesn't match.");
                    }
                }catch(IllegalArgumentException e){
                    System.out.println("#|getRule(): Exception collected on rule"+ruleIndex+".");
                } 
            }
            
            ruleIndex++;
        }
    }
}