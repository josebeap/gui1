/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.ui;

import java.awt.Rectangle;

/**
 * @version 1.0
 */
public interface GameSection 
{
    public Rectangle getBoundaries();
    
    public void update();
}
