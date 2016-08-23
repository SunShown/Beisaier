package text.liu.com.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hui on 2016/8/22.
 */
public class DrawQuto extends View {
    private Paint mPaint=null;
    public DrawQuto(Context context) {
        super(context);
        init();
    }

    public DrawQuto(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawQuto(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private float magicNum=0.555555f;

    private void init() {
        setWillNotDraw(false);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.triangle));
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(getVisibility()==GONE){
            return;
        }
        /**
         * 利用贝塞尔曲线
         */
        Path path=new Path();
        System.out.println(magicNum);
        path.moveTo(relativeXFromView(0.5f),relativeYFromView(0));
        path.cubicTo(relativeXFromView(0.5f+magicNum/2),relativeYFromView(0),relativeXFromView(1),relativeYFromView(0.5f-magicNum/2),relativeXFromView(1),relativeYFromView(0.5f));
        path.cubicTo(relativeXFromView(1),relativeYFromView(0.5f+magicNum/2),relativeXFromView(0.5f+magicNum/2),relativeYFromView(1),relativeXFromView(0.5f),relativeYFromView(1));
        path.cubicTo(relativeXFromView(0.5f-magicNum/2),relativeYFromView(1),relativeXFromView(0),relativeYFromView(0.5f+magicNum/2),relativeXFromView(0),relativeYFromView(0.5f));
        path.cubicTo(relativeXFromView(0),relativeYFromView(0.5f-magicNum/2),relativeXFromView(0.5f-magicNum/2),relativeYFromView(0),relativeXFromView(0.5f),relativeYFromView(0));
        path.close();
        canvas.drawPath(path,mPaint);

    }
    private float relativeXFromView(float percent){
        return percent*getWidth();
    }
    private float relativeYFromView(float percent){
        return percent*getHeight();
    }
    public void changeToRect(){
        magicNum=magicNum+0.05f;
        System.out.println(magicNum+"圆");
        postInvalidate();
    }
    public void changeToCircle(){
        magicNum=magicNum-0.05f;
        System.out.println(magicNum+"正方形");
        postInvalidate();
    }
    public float returnMagicNum(){
        return magicNum;
    }
    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if(visibility==VISIBLE){
            invalidate();
        }
    }
}
