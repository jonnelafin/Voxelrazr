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

import JFUtils.Input;
import JFUtils.InputActivated;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import voxelrazr.core.Globals;

/**
 *
 * @author Jonnelafin
 */
public class Renderer extends JPanel implements voxelrazr.core.Graphics.Renderer{

    private Window window;

    int w = Globals.window_default_w;
    int h = Globals.window_default_h;
    
    Input inp;
    
    public Renderer() {
        //Set the jpanel to be double buffered
        setDoubleBuffered(true);
    }
    
    
    @Override
    public void setupWindow(String windowName) {

        System.out.println(this.hashCode() + " setting up window...");
        window = new Window(true, this, windowName);      
        
        System.out.println("Setting up window input...");
        inp = new Input(new InputActivated());
        inp.addListener(Globals.input);
        //inp.verbodose = true;
        addMouseListener(inp);
        addMouseWheelListener(inp);
        addMouseMotionListener(inp);
        
        addKeyListener(inp);
        requestFocusInWindow();
    }

    @Override
    public boolean isWindowSet() {
        return window != null;
    }

    @Override
    public Object getWindow() {
        return window;
    }

    @Override
    public String getWindowType() {
        return "JFrame";
    }

    int pos = Globals.window_default_w/2;
    int nextpos = 0;
    
    private boolean vsync = true;
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        w = getWidth();
        h = getHeight();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, w, h);
        
        g.setColor(Color.white);
        g.fillRect(pos, 0, 30, 30);
        
        //Update parameters
        if(vsync){
            pos = nextpos;
        }
    }

    @Override
    public void updateContent(int pos) {
        vsync = false;
        pos = pos;
        vsync = true;
    }
    
}
