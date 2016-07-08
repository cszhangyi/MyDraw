package com.example.yale.mydrawbrush.Brush;

/**
 * Created by Yale on 16/7/8.
 */

import android.graphics.Canvas;

/**
 * 对于每一次路径绘制,有两个命令:绘制命令和撤销命令
 */
public interface IDraw {

    /**
     * 绘制命令
     * @param canvas 画布对象
     */
    void draw(Canvas canvas);

    /**
     * 撤销命令
     */
    void undo();
}
