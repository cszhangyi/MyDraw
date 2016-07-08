package com.example.yale.mydrawbrush;

import android.graphics.Paint;
import android.graphics.Path;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.yale.mydrawbrush.Brush.CircleBrush;
import com.example.yale.mydrawbrush.Brush.DrawCanvas;
import com.example.yale.mydrawbrush.Brush.DrawPath;
import com.example.yale.mydrawbrush.Brush.IBrush;
import com.example.yale.mydrawbrush.Brush.NormalBrush;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

//    private DrawCanvas mCanvas;
    private DrawPath mPath;
    private Paint mPaint;
    private IBrush mBrush;

    @Bind(R.id.ac_draw_canvas)
    DrawCanvas mCanvas;
    @Bind(R.id.ac_draw_draw_operate_undo_btn)
    Button btnUndo;
    @Bind(R.id.ac_draw_draw_operate_redo_btn)
    Button btnRedo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPaint = new Paint();
        mPaint.setColor(0XFFFFFFFF);
        mPaint.setStrokeWidth(3);

        mCanvas.setOnTouchListener(new DrawTouchListener());

        mBrush = new NormalBrush();

        btnRedo.setEnabled(false);
        btnUndo.setEnabled(false);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.ac_draw_color_red_btn:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(0XFFFF0000);
                System.out.print("sfsfasfafd!$@#$!@#$!");
                break;
            case R.id.ac_draw_color_blue_btn:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(0XFF00FF00);
                break;
            case R.id.ac_draw_color_green_btn:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(0XFF0000FF);
                break;
            case R.id.ac_draw_draw_operate_undo_btn:
                mCanvas.undo();
                if(!mCanvas.canUndo()){
                    btnUndo.setEnabled(false);
                }
                btnRedo.setEnabled(true);
                break;
            case R.id.ac_draw_draw_operate_redo_btn:
                mCanvas.redo();
                if(!mCanvas.canRedo()){
                    btnUndo.setEnabled(false);
                }
                btnRedo.setEnabled(true);
                break;
            case R.id.ac_draw_operate_brush_circle_btn:
                mBrush = new CircleBrush();
                break;
            case R.id.ac_draw_operate_brush_normal_btn:
                mBrush = new NormalBrush();
                break;
            default:
                break;
        }
    }

    private class DrawTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                mPath = new DrawPath();
                mPath.paint = mPaint;
                mPath.path = new Path();
                mBrush.down(mPath.path, motionEvent.getX(), motionEvent.getY());
            }else if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                mBrush.move(mPath.path, motionEvent.getX(), motionEvent.getY());
            }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                mBrush.up(mPath.path, motionEvent.getX(), motionEvent.getY());
                mCanvas.add(mPath);
                mCanvas.isDrawing = true;
                btnUndo.setEnabled(true);
                btnRedo.setEnabled(false);
            }
            return true;
        }
    }
}
