package com.example.quizcidades.Controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizcidades.Model.PontoTuristico;
import com.example.quizcidades.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public List<PontoTuristico> pontosTuristicos = new ArrayList<PontoTuristico>();
    PontoTuristico p;
    Random rand = new Random();
    int pontos = 0;
    int count = 0;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPontosTuristicos();
        p = pontosTuristicos.get(rand.nextInt(pontosTuristicos.size()));
        iv = findViewById(R.id.CityId);
        Picasso.get()
                .load(p.getUrl())
                .into(iv);
    }

    public void guess(View view){
        if(count == 4){
            Toast.makeText(this.getBaseContext(),"Jogo Encerrado"+ p.getCidade(),
                    Toast.LENGTH_SHORT).show();
            return;
        }
        EditText t = findViewById(R.id.nomeCidade);
        if(t.getText().toString().equals(p.getCidade())){
            pontos += 25;
            Toast.makeText(this.getBaseContext(),"Acertou",
                    Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this.getBaseContext(),"Resposta correta era "+ p.getCidade(),
                    Toast.LENGTH_LONG).show();
        }
        pontosTuristicos.remove(p);
        p = pontosTuristicos.get(rand.nextInt(pontosTuristicos.size()));
        t.setText("");
        TextView point =  findViewById(R.id.points);
        point.setText("Pontos: " + String.valueOf(pontos));
        Picasso.get()
                .load(p.getUrl())
                .into(iv);
    }

    public void setPontosTuristicos(){
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Brasilia"));
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Brasilia"));
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Brasilia"));
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Brasilia"));
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Brasilia"));
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Brasilia"));
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Brasilia"));
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Brasilia"));
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Brasilia"));
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Brasilia"));


    }

}