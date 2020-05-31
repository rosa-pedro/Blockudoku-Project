/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import blocks.*;
import java.util.Random;

/** This class is used to generate the various blocks needed within the game
 * based on the different GameMode it will produce different kinds of blocks
 * 
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class BlockGenerator {
    
    /**
     *  Static method nextAdvancedBlock randomizes a number between [1,13] 
     * and then generates a pieces according to that number
     * 
     * @return The piece that was randomly generated
     */
    public static Piece nextAdvancedBlock() {

        Random random = new Random();
        int number = random.nextInt(14);

        switch (number) {
            case 1: return new IOneBlock();
            
            case 2: return new ITwoBlock();
            
            case 3: return new IThreeBlock();
            
            case 4: return new JBlock();
            
            case 5: return new LBlock();
            
            case 6: return new LMaximumBlock();
            
            case 7: return new LMinimumBlock();
            
            case 8: return new QBlock();
            
            case 9: return new QExtendedBlock();
            
            case 10: return new SBlock();
            
            case 11: return new TBlock();
            
            case 12: return new TExtendedBlock();
            
            case 13: return new ZBlock();

            default: return new IBlock();
        }
    }
    
    /**
     *  Static method nextBasicBlock randomizes a number between [1,13] 
     * and then generates a pieces according to that number
     * 
     * @return The piece that was randomly generated
     */
    public static Piece nextBasicBlock() {

        Random random = new Random();
        int number = random.nextInt(7);

        switch (number) {
            
            case 1: return new JBlock();
            
            case 2: return new LBlock();
            
            case 3: return new QBlock();
            
            case 4: return new SBlock();
            
            case 5: return new TBlock();
            
            case 6: return new ZBlock();

            default: return new IBlock();
        }
    }

}
