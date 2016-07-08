package com.example.yale.mydrawbrush.Brush;

import android.graphics.Path;

/**
 * Created by Yale on 16/7/8.
 */
public interface IBrush {
    /**
     * 触点接触时
     * @param path
     * @param x
     * @param y
     */
    void down(Path path, float x, float y);

    /**
     * 触点移动式
     * @param path
     * @param x
     * @param y
     */
    void move(Path path, float x, float y);

    /**
     * 触点离开时
     * @param path
     * @param x
     * @param y
     */
    void up(Path path, float x, float y);
}
