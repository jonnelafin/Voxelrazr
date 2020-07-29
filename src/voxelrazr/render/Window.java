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

package voxelrazr.render;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import voxelrazr.core.Globals;

/**
 *
 * @author Jonnelafin
 */
public class Window extends JFrame{
    private Renderer renderer;
    public Window(boolean exitOnClose, Renderer r){
        System.out.println("Creating window: " + this);
        renderer = r;
        
        //Set basic operating parameters
        setTitle("Voxelrazr " + Globals.version);
        setSize(Globals.window_default_w, Globals.window_default_w);
        setLayout(new BorderLayout());
        
        //Add the renderer
        add(renderer, BorderLayout.CENTER);
        
        //Set function to handle exit
        if(exitOnClose){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        else{
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
        setVisible(true);
    }
}
