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

import java.util.LinkedList;
import voxelrazr.core.logging.LogListener;
import voxelrazr.core.logging.logStatus;

/**
 *
 * @author Jonnelafin
 */
public class Logger implements voxelrazr.core.logging.Logger{

    private LinkedList<LogListener> listeners = new LinkedList<>();
    
    private synchronized void aListener(LogListener l){
        listeners.add(l);
    }
    private synchronized void rListener(LogListener l){
        if(listeners.contains(l)){
            listeners.remove(l);
        }
    }
    
    @Override
    public void log(String info, logStatus status) {
        System.out.println(status + " | " + info);
            listeners.forEach(l -> {
                l.receive(info,status);
            }
        );
    }

    @Override
    public void addListener(LogListener l) {
        aListener(l);
    }

    @Override
    public void removeListener(LogListener l) {
        rListener(l);
    }

}
