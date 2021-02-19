package andrey.first.playquestgaga;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Location4_3 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean oneQuestion;
    boolean twoQuestion;
    int coffee;
    int game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location4_3);
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        coffee = save.getInt("coffee", coffee);
        game = save.getInt("game", game);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 12);
        editor.apply();


        Button answer1 = findViewById(R.id.answer1);
        Button answer2 = findViewById(R.id.answer2);


           answer1.setOnClickListener(new View.OnClickListener() {
               @SuppressLint("SetTextI18n")
               @Override
               public void onClick(View view) {
                   setContentView(R.layout.location4_3_1);
                    Button answer1 = findViewById(R.id.answer1);
                    Button answer2 = findViewById(R.id.answer2);
                    Button answer3 = findViewById(R.id.answer3);

                   answer1.setOnClickListener(new View.OnClickListener() {
                       @SuppressLint("SetTextI18n")
                       @Override
                       public void onClick(View view) {
                           setContentView(R.layout.location4_3_2);
                           Button answer1 = findViewById(R.id.answer1);
                           Button answer2 = findViewById(R.id.answer2);
                           Button answer3 = findViewById(R.id.answer3);

                           answer1.setOnClickListener(new View.OnClickListener() {
                               @SuppressLint("SetTextI18n")
                               @Override
                               public void onClick(View view) {
                                   setContentView(R.layout.location4_3_3);
                                   Button cont = findViewById(R.id.cont);
                                   cont.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                               setContentView(R.layout.location4_3_4);
                                               Button answer1 = findViewById(R.id.answer1);
                                               Button answer2 = findViewById(R.id.answer2);
                                               Button answer3 = findViewById(R.id.answer3);

                                               answer1.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });
                                               answer2.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer3.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });
                                           }
                                   });
                               }
                           });

                           answer2.setOnClickListener(new View.OnClickListener() {
                               @SuppressLint("SetTextI18n")
                               @Override
                               public void onClick(View view) {
                                   setContentView(R.layout.location4_3_3);
                                   Button cont = findViewById(R.id.cont);
                                   cont.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                               setContentView(R.layout.location4_3_4);
                                               Button answer1 = findViewById(R.id.answer1);
                                               Button answer2 = findViewById(R.id.answer2);
                                               Button answer3 = findViewById(R.id.answer3);

                                               answer1.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer2.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer3.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });
                                       }
                                   });
                               }
                           });

                           answer3.setOnClickListener(new View.OnClickListener() {
                               @SuppressLint("SetTextI18n")
                               @Override
                               public void onClick(View view) {
                                   setContentView(R.layout.location4_3_3);
                                   Button cont = findViewById(R.id.cont);
                                   cont.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                               setContentView(R.layout.location4_3_4);
                                               Button answer1 = findViewById(R.id.answer1);
                                               Button answer2 = findViewById(R.id.answer2);
                                               Button answer3 = findViewById(R.id.answer3);

                                               answer1.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer2.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer3.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });
                                           }

                                   });
                               }
                           });
                       }
                   });

                   answer2.setOnClickListener(new View.OnClickListener() {
                       @SuppressLint("SetTextI18n")
                       @Override
                       public void onClick(View view) {
                           oneQuestion = true;
                           setContentView(R.layout.location4_3_2);
                           Button answer1 = findViewById(R.id.answer1);
                           Button answer2 = findViewById(R.id.answer2);
                           Button answer3 = findViewById(R.id.answer3);

                           answer1.setOnClickListener(new View.OnClickListener() {
                               @SuppressLint("SetTextI18n")
                               @Override
                               public void onClick(View view) {
                                   setContentView(R.layout.location4_3_3);
                                   Button cont = findViewById(R.id.cont);
                                   cont.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {

                                               setContentView(R.layout.location4_3_4);
                                               Button answer1 = findViewById(R.id.answer1);
                                               Button answer2 = findViewById(R.id.answer2);
                                               Button answer3 = findViewById(R.id.answer3);

                                               answer1.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer2.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer3.setOnClickListener(new View.OnClickListener() {

                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       twoQuestion =true;
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       Toast toast1 = Toast.makeText(Location4_3.this, "Игроластик", Toast.LENGTH_LONG);
                                                       toast1.setGravity(Gravity.CENTER, 0, 0);
                                                       //Создаем разметку для заполнения ее изображением:
                                                       LinearLayout linearLayout = (LinearLayout) toast1.getView();
                                                       //Создаем в теле Toast объект типа ImageView:
                                                       ImageView imageView = new ImageView(Location4_3.this);
                                                       //Привязываем к нему изображение:
                                                       imageView.setImageResource(R.drawable.gamemaster1);
                                                       //Добавляем изображение к разметке для его отображения и запускаем Toast сообщение:
                                                       assert linearLayout != null;
                                                       linearLayout.addView(imageView);
                                                       toast1.show();
                                                       editor.putBoolean("igrolastik", true);
                                                       editor.apply();
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });
                                           }
                                   });
                               }
                           });

                           answer2.setOnClickListener(new View.OnClickListener() {
                               @SuppressLint("SetTextI18n")
                               @Override
                               public void onClick(View view) {
                                   setContentView(R.layout.location4_3_3);
                                   Button cont = findViewById(R.id.cont);
                                   cont.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                               setContentView(R.layout.location4_3_4);
                                               Button answer1 = findViewById(R.id.answer1);
                                               Button answer2 = findViewById(R.id.answer2);
                                               Button answer3 = findViewById(R.id.answer3);

                                               answer1.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer2.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer3.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       twoQuestion =true;
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       Toast toast1 = Toast.makeText(Location4_3.this, "Игроластик", Toast.LENGTH_LONG);
                                                       toast1.setGravity(Gravity.BOTTOM, 0, 0);
                                                       //Создаем разметку для заполнения ее изображением:
                                                       LinearLayout linearLayout = (LinearLayout) toast1.getView();
                                                       //Создаем в теле Toast объект типа ImageView:
                                                       ImageView imageView = new ImageView(Location4_3.this);
                                                       //Привязываем к нему изображение:
                                                       imageView.setImageResource(R.drawable.gamemaster1);
                                                       //Добавляем изображение к разметке для его отображения и запускаем Toast сообщение:
                                                       assert linearLayout != null;
                                                       linearLayout.addView(imageView);
                                                       toast1.show();
                                                       editor.putBoolean("igrolastik", true);
                                                       editor.apply();
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });
                                       }
                                   });
                               }
                           });

                           answer3.setOnClickListener(new View.OnClickListener() {
                               @SuppressLint("SetTextI18n")
                               @Override
                               public void onClick(View view) {
                                   setContentView(R.layout.location4_3_3);
                                   Button cont = findViewById(R.id.cont);
                                   cont.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                               setContentView(R.layout.location4_3_4);
                                               Button answer1 = findViewById(R.id.answer1);
                                               Button answer2 = findViewById(R.id.answer2);
                                               Button answer3 = findViewById(R.id.answer3);

                                               answer1.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer2.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer3.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       twoQuestion =true;
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       Toast toast1 = Toast.makeText(Location4_3.this, "Игроластик", Toast.LENGTH_LONG);
                                                       toast1.setGravity(Gravity.BOTTOM, 0, 0);
                                                       //Создаем разметку для заполнения ее изображением:
                                                       LinearLayout linearLayout = (LinearLayout) toast1.getView();
                                                       //Создаем в теле Toast объект типа ImageView:
                                                       ImageView imageView = new ImageView(Location4_3.this);
                                                       //Привязываем к нему изображение:
                                                       imageView.setImageResource(R.drawable.gamemaster1);
                                                       //Добавляем изображение к разметке для его отображения и запускаем Toast сообщение:
                                                       assert linearLayout != null;
                                                       linearLayout.addView(imageView);
                                                       toast1.show();
                                                       editor.putBoolean("igrolastik", true);
                                                       editor.apply();
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });
                                           }
                                   });
                               }
                           });
                       }
                   });

                   answer3.setOnClickListener(new View.OnClickListener() {
                       @SuppressLint("SetTextI18n")
                       @Override
                       public void onClick(View view) {
                           setContentView(R.layout.location4_3_2);
                           Button answer1 = findViewById(R.id.answer1);
                           Button answer2 = findViewById(R.id.answer2);
                           Button answer3 = findViewById(R.id.answer3);

                           answer1.setOnClickListener(new View.OnClickListener() {
                               @SuppressLint("SetTextI18n")
                               @Override
                               public void onClick(View view) {
                                   setContentView(R.layout.location4_3_3);
                                   Button cont = findViewById(R.id.cont);
                                   cont.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                               setContentView(R.layout.location4_3_4);
                                               Button answer1 = findViewById(R.id.answer1);
                                               Button answer2 = findViewById(R.id.answer2);
                                               Button answer3 = findViewById(R.id.answer3);

                                               answer1.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer2.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });

                                               answer3.setOnClickListener(new View.OnClickListener() {
                                                   @SuppressLint("SetTextI18n")
                                                   @Override
                                                   public void onClick(View view) {
                                                       setContentView(R.layout.location4_3_5);
                                                       Button cont = findViewById(R.id.cont);
                                                       cont.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                                   editor.putBoolean("alone", true);
                                                                   editor.apply();
                                                                   exitFromLocation();
                                                           }
                                                       });
                                                   }
                                               });
                                           }
                                   });
                               }
                           });

                           answer2.setOnClickListener(new View.OnClickListener() {
                               @SuppressLint("SetTextI18n")
                               @Override
                               public void onClick(View view) {
                                   setContentView(R.layout.location4_3_3);
                                   Button cont = findViewById(R.id.cont);
                                   cont.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           setContentView(R.layout.location4_3_4);
                                           Button answer1 = findViewById(R.id.answer1);
                                           Button answer2 = findViewById(R.id.answer2);
                                           Button answer3 = findViewById(R.id.answer3);

                                           answer1.setOnClickListener(new View.OnClickListener() {
                                               @SuppressLint("SetTextI18n")
                                               @Override
                                               public void onClick(View view) {
                                                   setContentView(R.layout.location4_3_5);
                                                   Button cont = findViewById(R.id.cont);
                                                   cont.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {
                                                           editor.putBoolean("alone", true);
                                                           editor.apply();
                                                           exitFromLocation();
                                                       }
                                                   });
                                               }
                                           });

                                           answer2.setOnClickListener(new View.OnClickListener() {
                                               @SuppressLint("SetTextI18n")
                                               @Override
                                               public void onClick(View view) {
                                                   setContentView(R.layout.location4_3_5);
                                                   Button cont = findViewById(R.id.cont);
                                                   cont.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {
                                                           editor.putBoolean("alone", true);
                                                           editor.apply();
                                                           exitFromLocation();
                                                       }
                                                   });
                                               }
                                           });

                                           answer3.setOnClickListener(new View.OnClickListener() {
                                               @SuppressLint("SetTextI18n")
                                               @Override
                                               public void onClick(View view) {
                                                   setContentView(R.layout.location4_3_5);
                                                   Button cont = findViewById(R.id.cont);
                                                   cont.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {
                                                           editor.putBoolean("alone", true);
                                                           editor.apply();
                                                           exitFromLocation();
                                                       }
                                                   });
                                               }
                                           });
                                       }

                                   });

                               }
                           });

                           answer3.setOnClickListener(new View.OnClickListener() {
                               @SuppressLint("SetTextI18n")
                               @Override
                               public void onClick(View view) {
                                   setContentView(R.layout.location4_3_3);
                                   Button cont = findViewById(R.id.cont);
                                   cont.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           setContentView(R.layout.location4_3_4);
                                           Button answer1 = findViewById(R.id.answer1);
                                           Button answer2 = findViewById(R.id.answer2);
                                           Button answer3 = findViewById(R.id.answer3);

                                           answer1.setOnClickListener(new View.OnClickListener() {
                                               @SuppressLint("SetTextI18n")
                                               @Override
                                               public void onClick(View view) {
                                                   setContentView(R.layout.location4_3_5);
                                                   Button cont = findViewById(R.id.cont);
                                                   cont.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {
                                                           editor.putBoolean("alone", true);
                                                           editor.apply();
                                                           exitFromLocation();
                                                       }
                                                   });
                                               }
                                           });

                                           answer2.setOnClickListener(new View.OnClickListener() {
                                               @SuppressLint("SetTextI18n")
                                               @Override
                                               public void onClick(View view) {
                                                   setContentView(R.layout.location4_3_5);
                                                   Button cont = findViewById(R.id.cont);
                                                   cont.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {
                                                           editor.putBoolean("alone", true);
                                                           editor.apply();
                                                           exitFromLocation();
                                                       }
                                                   });
                                               }
                                           });

                                           answer3.setOnClickListener(new View.OnClickListener() {
                                               @SuppressLint("SetTextI18n")
                                               @Override
                                               public void onClick(View view) {
                                                   setContentView(R.layout.location4_3_5);
                                                   Button cont = findViewById(R.id.cont);
                                                   cont.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {
                                                           editor.putBoolean("alone", true);
                                                           editor.apply();
                                                           exitFromLocation();
                                                       }
                                                   });
                                               }
                                           });
                                       }
                                   });
                               }
                           });
                       }
                   });
               }
           });

        answer2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                            editor.putBoolean("alone", true);
                            editor.apply();
                            exitFromLocation();
                        }
                });
        }

    public void exitFromLocation() {
        try {
            Intent intent = new Intent(Location4_3.this, Location4_1.class);
            startActivity(intent);
            shouldPlay = true;
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored) {
        }
    }

    @Override
    protected void onPause() {
        if(!shouldPlay) {
            stopService(new Intent(this, MyService.class));
            stopService(new Intent(this, MyService2.class));
        }
        super.onPause();
    }


    @Override
    protected void onResume() {
        if(isMyServiceRunning() &!offVolume&!radioAnother)
            startService(new Intent(this, MyService.class));
        if(isMyServiceRunning() &!offVolume&radioAnother)
            startService(new Intent(this, MyService2.class));
        super.onResume();
    }

    private boolean isMyServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if ((MyService.class.getName().equals(service.service.getClassName()))&&(MyService2.class.getName().equals(service.service.getClassName()))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Location4_3.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}