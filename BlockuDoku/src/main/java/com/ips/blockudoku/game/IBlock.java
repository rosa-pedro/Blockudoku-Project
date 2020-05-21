/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.blockudoku.game;

import java.util.HashMap;

/**
 *
 * @author rosap
 */
public class IBlock extends Piece{
    
    public IBlock(){
        super("A1");
    }
    
    @Override
    public void buildPiece(){
        addSquare("A1");
        addSquare("A2");
        addSquare("A3");
    }
    
}
