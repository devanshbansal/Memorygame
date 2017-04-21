package com.example.bansal.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Interpolator;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Stack;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends Activity implements View.OnClickListener {


    Button v[] = new Button[6];
    String a;
    int[] num = new int[6];
    int hit;
    Stack mystack;
    Drawable d;
    int temp;
Thread [] thread= new Thread[6];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v[0] = (Button) findViewById(R.id.v1);
        v[1] = (Button) findViewById(R.id.v2);
        v[2] = (Button) findViewById(R.id.v3);
        v[3] = (Button) findViewById(R.id.v4);
        v[4] = (Button) findViewById(R.id.v5);
        v[5] = (Button) findViewById(R.id.v6);
        mystack=new Stack();
        hit=0;
        temp=0;
        Resources resources = MainActivity.this.getResources();
         d = resources.getDrawable(R.color.Green);
        int low=1;
        int high=3;
        int flag = 1;
         thread[5] = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {v[5].setText("");
                        v[5].setBackgroundColor(Color.LTGRAY);
                        v[temp-1].setText("");
                        v[temp-1].setBackgroundColor(Color.LTGRAY);
                        onStop();

                    }
                });
            }
        };

        thread[0] = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {v[0].setText("");
                        v[0].setBackgroundColor(Color.LTGRAY);
                        v[temp-1].setText("");
                        v[temp-1].setBackgroundColor(Color.LTGRAY);
                        onStop();

                    }
                });
            }
        };

        thread[1] = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {v[1].setText("");
                        v[1].setBackgroundColor(Color.LTGRAY);
                        v[temp-1].setText("");
                        v[temp-1].setBackgroundColor(Color.LTGRAY);
                        onStop();

                    }
                });
            }
        };

        thread[2] = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {v[2].setText("");
                        v[2].setBackgroundColor(Color.LTGRAY);
                        v[temp-1].setText("");
                        v[temp-1].setBackgroundColor(Color.LTGRAY);
                        onStop();

                    }
                });
            }
        };

        thread[3] = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {v[3].setText("");
                        v[3].setBackgroundColor(Color.LTGRAY);
                        v[temp-1].setText("");
                        v[temp-1].setBackgroundColor(Color.LTGRAY);
                        onStop();

                    }
                });
            }
        };

        thread[4] = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {v[4].setText("");
                        v[4].setBackgroundColor(Color.LTGRAY);
                        v[temp-1].setText("");
                        v[temp-1].setBackgroundColor(Color.LTGRAY);
                        onStop();

                    }
                });
            }
        };

//        LinearLayout ll= (LinearLayout) findViewById(R.id.ll);
//        LinearLayout sv= (LinearLayout) findViewById(R.id.scroll);


//        for( int i=0;i<5;i++) {
//            View inflatedView=getLayoutInflater().inflate(R.layout.activity_main,ll,false);
//            sv.addView(inflatedView);
//            sv.refreshDrawableState();
//
//        }


        int a, b, c, d, e, f, g, h;

        Random r = new Random();
        int count1, count2, count3;
        count1 = 0;
        count2 = 0;
        count3 = 0;
        for (int i = 0; i < 6; i++) {
            num[i] = r.nextInt(3) + low;
            switch (num[i]) {
                case 1: {
                    count1++;
                    if (count1 >2) {
                        i--;
                        continue;
                    }
                    break;

                }
                case 2: {
                    count2++;
                    if (count2 > 2) {
                        i--;
                        continue;
                    }
                    break;

                }
                case 3: {
                    count3++;
                    if (count3 > 2) {
                        i--;
                        continue;
                    }
                    break;

                }
            }

        }

        for (int i = 0; i < 5; i++) {
            v[i].setText("");
        }


    }

    @Override
    public void onClick(View e) {
        switch (e.getId()) {
            case R.id.v1: {
                if(hit==0)
                {
                     v[0].setText(Integer.toString(num[0]));
                    v[0].setBackgroundColor(Color.BLACK);
                    mystack.push(1);
                    hit=1;}
                else
                {    if(!mystack.isEmpty())
                    temp=(Integer)mystack.pop();
                    if(Integer.toString(num[0]).equals(v[temp-1].getText()))
                    {
                        v[0].setText(Integer.toString(num[0]));
                        v[0].setBackgroundColor(Color.BLACK);
                        v[0].setEnabled(false);
                        v[temp-1].setEnabled(false);
                        check();
                        hit=0;
                    }
                    else
                    {  mystack.push(temp);
                        v[0].setText(Integer.toString(num[0]));
                        v[0].setBackgroundColor(Color.RED);
                        if (thread[0].getState() == Thread.State.NEW)
                        {
                            thread[0].start();
                        }
                        else
                        {
                            thread[0] = new Thread() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                    }

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {v[0].setText("");
                                            v[0].setBackgroundColor(Color.LTGRAY);
                                            v[temp-1].setText("");
                                            v[temp-1].setBackgroundColor(Color.LTGRAY);
                                            onStop();

                                        }
                                    });
                                }

                            };
                            thread[0].start();
                        }
                        hit=0;
                    }

                }
                break;
            }
            case R.id.v2: {
                if(hit==0)
                {
                    v[1].setText(Integer.toString(num[1]));
                    v[1].setBackgroundColor(Color.BLACK);
                    mystack.push(2);
                    hit=1;}
                else
                {     if(!mystack.isEmpty())
                    temp=(Integer)mystack.pop();
                    if(Integer.toString(num[1]).equals(v[temp-1].getText()))
                    {
                        v[1].setText(Integer.toString(num[1]));
                        v[1].setBackgroundColor(Color.BLACK);
                        v[1].setEnabled(false);
                        check();
                        v[temp-1].setEnabled(false);
                        hit=0;
                    }
                    else
                    {    mystack.push(temp);
                        v[1].setText(Integer.toString(num[1]));
                        v[1].setBackgroundColor(Color.RED);
                        if (thread[1].getState() == Thread.State.NEW)
                        {
                            thread[1].start();
                        }
                        else
                        {
                            thread[1] = new Thread() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                    }

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {v[1].setText("");
                                            v[1].setBackgroundColor(Color.LTGRAY);
                                            v[temp-1].setText("");
                                            v[temp-1].setBackgroundColor(Color.LTGRAY);
                                            onStop();

                                        }
                                    });
                                }

                            };
                            thread[1].start();
                        }
                        hit=0;
                    }

                }
                break;
            }
            case R.id.v3: {
                if(hit==0)
                {
                    v[2].setText(Integer.toString(num[2]));
                    v[2].setBackgroundColor(Color.BLACK);
                    mystack.push(3);
                    hit=1;}
                else
                {if(!mystack.isEmpty())
                    temp=(Integer)mystack.pop();
                    if(Integer.toString(num[2]).equals(v[temp-1].getText()))
                    {
                        v[2].setText(Integer.toString(num[2]));
                        v[2].setBackgroundColor(Color.BLACK);
                        v[2].setEnabled(false);
                        v[temp-1].setEnabled(false);
                        check();
                        hit=0;
                    }
                    else
                    {
                        mystack.push(temp);
                        v[2].setText(Integer.toString(num[2]));
                        v[2].setBackgroundColor(Color.RED);
                        if (thread[2].getState() == Thread.State.NEW)
                        {
                            thread[2].start();
                        }
                        else
                        {
                            thread[2] = new Thread() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                    }

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {v[2].setText("");
                                            v[2].setBackgroundColor(Color.LTGRAY);
                                            v[temp-1].setText("");
                                            v[temp-1].setBackgroundColor(Color.LTGRAY);
                                            onStop();

                                        }
                                    });
                                }

                            };
                            thread[2].start();
                        }
                        hit=0;
                    }

                }
                break;
            }
            case R.id.v4: {
                if(hit==0)
                {
                    v[3].setText(Integer.toString(num[3]));
                    v[3].setBackgroundColor(Color.BLACK);
                    mystack.push(4);
                    hit=1;}
                else
                { if(!mystack.isEmpty())
                    temp=(Integer)mystack.pop();
                    if(Integer.toString(num[3]).equals(v[temp-1].getText()))
                    {
                        v[3].setText(Integer.toString(num[3]));
                        v[3].setBackgroundColor(Color.BLACK);
                        v[3].setEnabled(false);
                        v[temp-1].setEnabled(false);
                        check();
                        hit=0;
                    }
                    else
                    { mystack.push(temp);
                        v[3].setText(Integer.toString(num[3]));
                        v[3].setBackgroundColor(Color.RED);
                        if (thread[3].getState() == Thread.State.NEW)
                        {
                            thread[3].start();
                        }
                        else
                        {
                            thread[3] = new Thread() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                    }

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {v[3].setText("");
                                            v[3].setBackgroundColor(Color.LTGRAY);
                                            v[temp-1].setText("");
                                            v[temp-1].setBackgroundColor(Color.LTGRAY);
                                            onStop();

                                        }
                                    });
                                }

                            };
                            thread[3].start();
                        }
                        hit=0;
                    }

                }
                break;
            }
            case R.id.v5: {
                if(hit==0)
                {
                    v[4].setText(Integer.toString(num[4]));
                    v[4].setBackgroundColor(Color.BLACK);
                    mystack.push(5);
                    hit=1;}
                else
                {   if(!mystack.isEmpty())
                    temp=(Integer)mystack.pop();
                    if(Integer.toString(num[4]).equals(v[temp-1].getText()))
                    {
                        v[4].setText(Integer.toString(num[4]));
                        v[4].setBackgroundColor(Color.BLACK);
                        v[4].setEnabled(false);
                        v[temp-1].setEnabled(false);
                        check();
                        hit=0;
                    }
                    else
                       {
                           mystack.push(temp);
                           v[4].setText(Integer.toString(num[4]));
                           v[4].setBackgroundColor(Color.RED);
                           if (thread[4].getState() == Thread.State.NEW)
                           {
                               thread[4].start();
                           }
                           else
                           {
                               thread[4] = new Thread() {
                                   @Override
                                   public void run() {
                                       try {
                                           Thread.sleep(1000);
                                       } catch (InterruptedException e) {
                                       }

                                       runOnUiThread(new Runnable() {
                                           @Override
                                           public void run() {v[4].setText("");
                                               v[4].setBackgroundColor(Color.LTGRAY);
                                               v[temp-1].setText("");
                                               v[temp-1].setBackgroundColor(Color.LTGRAY);
                                               onStop();

                                           }
                                       });
                                   }

                               };
                               thread[4].start();
                           }
                        hit=0;
                    }

                }
                break;
            }
            case R.id.v6: {
                if(hit==0)
                {
                    v[5].setText(Integer.toString(num[5]));
                    v[5].setBackgroundColor(Color.BLACK);
                    mystack.push(6);
                    hit=1;}
                else
                {    if(!mystack.isEmpty())
                    temp=(Integer)mystack.pop();
                    if(Integer.toString(num[5]).equals(v[temp-1].getText()))
                    {
                        v[5].setText(Integer.toString(num[5]));
                        v[5].setBackgroundColor(Color.BLACK);
                        v[5].setEnabled(false);
                        v[temp-1].setEnabled(false);
                        check();
                        hit=0;
                    }
                    else
                    {    mystack.push(temp);
                        v[5].setText(Integer.toString(num[5]));
                        v[5].setBackgroundColor(Color.RED);
                        if (thread[5].getState() == Thread.State.NEW)
                        {
                            thread[5].start();
                        }
                        else
                        {
                            thread[5] = new Thread() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                    }

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {v[5].setText("");
                                            v[5].setBackgroundColor(Color.LTGRAY);
                                            v[temp-1].setText("");
                                            v[temp-1].setBackgroundColor(Color.LTGRAY);
                                            onStop();

                                        }
                                    });
                                }

                            };
                            thread[5].start();
                        }

                        hit=0;
                    }

                }
                break;
            }


            default:
                throw new RuntimeException("Unknow button ID");
        }
    }
    public void check()
    {
       if(v[0].getText().equals(Integer.toString(num[0]))&&v[1].getText().equals(Integer.toString(num[1]))&&v[2].getText().equals(Integer.toString(num[2]))&&v[3].getText().equals(Integer.toString(num[3]))&&v[4].getText().equals(Integer.toString(num[4]))&&v[5].getText().equals(Integer.toString(num[5])))
       {
           Toast t= Toast.makeText(getApplicationContext(),"WON!",Toast.LENGTH_LONG);
           t.show();
           Intent i= new Intent(getApplicationContext(),Main2Activity.class);
           startActivity(i);
           finish();


       }
    }
}