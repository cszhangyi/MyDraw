package com.example.yale.mydrawbrush.Brush;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Yale on 16/7/8.
 */
public class DrawPath implements IDraw {
    public Path path;
    public Paint paint;
    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public void undo() {

    }
}
