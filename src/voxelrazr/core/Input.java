/*
 * The MIT License
 *
 * Copyright 2020 Arno Elias Eskelinen.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package voxelrazr.core;

import java.util.concurrent.ConcurrentHashMap;
import static voxelrazr.core.Globals.l;
import voxelrazr.core.logging.logStatus;

/**
 *
 * @author Jonnelafin
 */
public class Input implements JFUtils.InputListener{

    
    /**
     * A map of all the keys
     */
    public ConcurrentHashMap<String, Boolean> keys = new ConcurrentHashMap<>();
    
    public boolean query(String query){
        if(keys.keySet().contains(query)){
            return keys.get(query);
        }
        return false;
    }
    
    public Input() {
    
    }

    @Override
    public void handleInput(char c, int i, boolean bln) {
        l.log("Input: " + c + ", " + i + "=" + bln,logStatus.INPUT);
        keys.put(c+"", bln);
    }

    public int mouseX = 0;
    public int mouseY = 0;
    
    @Override
    public void handleMouse(int x, int y) {
        mouseX = x;
        mouseY = y;
    }

    public boolean mousedown = false;
    public int scrollstate = 0;
    
    @Override
    public void handleMouseExtra(boolean bln, boolean bln1, boolean bln2, int i) {
        mousedown = bln;
        scrollstate = i;
    }

    @Override
    public JFUtils.Input returnSource() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
