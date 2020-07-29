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

import JFUtils.point.Point3D;
import static voxelrazr.core.Globals.l;
import voxelrazr.core.logging.logStatus;

/**
 *
 * @author Jonnelafin
 */
public class Logic {
    Thread logicThread;
    boolean running = false;
    public Logic(){
        System.out.println("=== Creating a new logic-object: " + this + " ===");
        System.out.println("Creating a new thread for the logic...");
        logicThread = new Thread(){
            @Override
            public void run() {
                super.run(); //To change body of generated methods, choose Tools | Templates.
                mainLoop();
            }
            
        };
        System.out.println("Starting the new thread...");
        logicThread.start();
        System.out.println("=== logic-object" + this.hashCode() + " created ===");
        running = true;
    }
    public void mainLoop(){
        while(true){
            tick();
        }
    }
    
    Point3D pos = new Point3D(0, 0, 0);
    
    public void tick(){
        //l.log("Tick!", logStatus.MISC  );
        boolean a = Globals.input.query("a");
        boolean d = Globals.input.query("d");
        if(a){
            //l.log("A", logStatus.MISC);
            pos.x = pos.x - 0.00001;
        }
        if(d){
            //l.log("D", logStatus.MISC);
            pos.x = pos.x + 0.00001;
        }
        Globals.renderer.updateContent(pos);
    }
}
