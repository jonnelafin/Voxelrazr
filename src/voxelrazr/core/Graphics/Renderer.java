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
package voxelrazr.core.Graphics;

/**
 *
 * @author Arno Elias Eskelinen
 */
public interface Renderer {
    
    /**
     * Returns the window-object, whatever class it'll be.
     * @return renderer's set window object, returns null if not set.
     */
    public Object getWindow();

    /**
     * Returns a string representation of the window-interface.
     * @return
     */
    public String getWindowType();

    /**
     * Returns the state of the renderer's window reference.
     * @return true if the window object is set, false otherwise.
     */
    public boolean isWindowSet();

    /**
     * Call to tell the implementing class to setup it's window.
     */
    public void setupWindow(String windowName);
   
    public void updateContent(int pos);
}
