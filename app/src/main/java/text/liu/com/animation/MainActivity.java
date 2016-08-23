package text.liu.com.animation;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button button=null;
    Button delete=null;
    RelativeLayout parent;
    DrawQuto circle=null;
    boolean isCircle=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circle= (DrawQuto) findViewById(R.id.draw);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                float magic=circle.returnMagicNum();
                if(isCircle){
                    circle.changeToRect();
                    if(magic>1.5)
                        isCircle=false;
                }else {
                    circle.changeToCircle();
                    if(magic<-2)
                        isCircle=true;
                }
            }
        },1000,500);
    }

}
