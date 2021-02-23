package andrey.first.playquestgaga;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Achieve {
    public void achievement(String s, Context n, int m) {
        try {
            Toast toast1 = Toast.makeText(n, s, Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER, 0, 0);
            //Создаем в теле Toast объект типа ImageView:
            ImageView imageView = new ImageView(n);
            //Привязываем к нему изображение:
            imageView.setImageResource(m);
            //Создаем разметку для заполнения ее изображением:
            LinearLayout linearLayout = (LinearLayout) toast1.getView();
            //Добавляем изображение к разметке для его отображения и запускаем Toast сообщение:
            assert linearLayout != null;
            linearLayout.addView(imageView,0);
            toast1.show();
        } catch (Exception ignored) {
            Toast.makeText(n, "Вы получили достижение "+s, Toast.LENGTH_SHORT).show();
        }
    }

}
