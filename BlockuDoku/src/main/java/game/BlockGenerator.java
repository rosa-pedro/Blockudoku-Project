/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import blocks.*;
import java.util.Random;

/**
 *
 * @author rosap
 */
public class BlockGenerator {

    public static Piece nextBlock() {

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

}
