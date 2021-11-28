package com.example.lec1102_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingPaper extends View {

    private ArrayList<Path> pathList = new ArrayList<Path>();
    private ArrayList<Paint> paintList = new ArrayList<Paint>();   // 색이 추가되어도 저장할 수 있도록 배열로 관
    private int currentPath = 0;
    private int currentPaint = 0;

    public DrawingPaper(Context context) {
        super(context);
        initPaper();
    }

    public void initPaper() {
        pathList.add(new Path());
        paintList.add(new Paint());
        paintList.get(currentPaint).setAntiAlias(true);     // 현재 사용하고 있는 paint의 객체 참조 / 안티앨리언싱: 부드럽게
        paintList.get(currentPaint).setColor(Color.RED);
        paintList.get(currentPaint).setStrokeWidth(10f);
        paintList.get(currentPaint).setStyle(Paint.Style.STROKE);   //
        paintList.get(currentPaint).setStrokeJoin(Paint.Join.ROUND);
    }

    public void resetPaper() {
        pathList.clear();
        paintList.clear();   // 해당 구성요소를 쓰레기통으로
        currentPath = 0;
        currentPaint = 0;

        initPaper();
        invalidate();
    }

    public void setEraser() {   // 터치하고 있는 요소 지우기

        pathList.add(new Path());
        paintList.add(new Paint());
        currentPath++;
        currentPaint++;
        paintList.get(currentPaint).setAntiAlias(true);
        paintList.get(currentPaint).setColor(Color.WHITE);
        paintList.get(currentPaint).setStyle(Paint.Style.STROKE);
        paintList.get(currentPaint).setStrokeJoin(Paint.Join.ROUND);
        paintList.get(currentPaint).setStrokeWidth(30f);
    }

    public void setPaintColor(int color) {
        paintList.add(new Paint());
        pathList.add(new Path());
        currentPath++;
        currentPaint++;

        paintList.get(currentPaint).setColor(color);
        paintList.get(currentPaint).setAntiAlias(true);
        paintList.get(currentPaint).setStyle(Paint.Style.STROKE);
        paintList.get(currentPaint).setStrokeJoin(Paint.Join.ROUND);
        paintList.get(currentPaint).setStrokeWidth(10f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int i;
        for (i=0; i<pathList.size(); i++){
            canvas.drawPath(pathList.get(i), paintList.get(i));   // 0부터 Pathlis 추가된 요소 출력
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                pathList.get(currentPath).moveTo(x, y);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                pathList.get(currentPath).lineTo(x, y);
                invalidate();
            case MotionEvent.ACTION_UP:
                break;
            default:
                return true;
        }

        invalidate();
        return true;
    }
}