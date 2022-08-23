package com.example.quizcidades.Controller;

import android.content.Intent;
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
        count++;
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

        if(count == 4){
            Intent it = new Intent(this, Pontuacao.class);
            Bundle params = new Bundle();
            params.putString("pontos", String.valueOf(pontos));
            Toast.makeText(this.getBaseContext(),"Jogo Encerrado",
                    Toast.LENGTH_SHORT).show();
            it.putExtras(params);
            startActivity(it);
            return;
        }

        Picasso.get()
                .load(p.getUrl())
                .into(iv);
    }

    public void setPontosTuristicos(){
        this.pontosTuristicos.add(new PontoTuristico("https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABqA6Ju7LxbFK-xzv-LXz158C4ICFkZJDuxn0JFwOqy0dxoHbx2gDpu1yTUbmde40qZ3ynaaeQSsbkT6lFzAutJMo38c4mYBNN91za-qmCTFQ3EWKBb1ZCDm12J--26pwwRB6Vd1XScZMC0dh1AKpFtF7jjYab4zxLNjnCiQbrtU83FFUnTFa58TOBiSmAkCpXaw8MsZ1lqNc0Z6aOBTpyWV93PGuEeuOM5KHBl4Tc0WIqn1jUvNi31D9n_dpzHaRWMfZ0I7tl0ZFjnQnGI6Xa7wirH37BekqQNvqBhIPNZ6_PsyE8dabv_zG2gJ2ukQWbjnUU3kp391VDfhr0ZjueASVQFTyjCEBYDYLbBE_QreD0ADikZvHTinuvql0qipspqnQo-WOIoiEa0t3h2vVoTbioA9bIW_CNR6osuGh1IF8g/p.jpeg","Barcelona"));
        this.pontosTuristicos.add(new PontoTuristico("https://ucce1771f9689d071d21f115aa88.previews.dropboxusercontent.com/p/thumb/ABpe2quZHJgKSzs32K2RHly30n1xuxeiR82lk34KQY_-1lX6juXLcibNZK4h3a67x-ACabAB5uBOM9E0mt-mnZG3uwDwepWjQx2C3vOqSejPGvi6hndC7_wlI-BBEQWh9N968XJ1hDQ11LuqmJrEEwl_RAppXi8q1q5c45ywJKrhnVIraDHWG9QmrbxPmL3uWh7qoB_hciOb-fvX36jLi-p6GI5GtnvpIdOiMS2XmxB7rmqFfMiCYRg38NybdCrPs1RuwFiK-e3vWxsuwVtRaAHcbs6zeIm7nkZGyPztDPWpVBarIzelRvmClQUalUsrPnfgAZNEP16bEbj0Ycj9qnkkJsYhclsL5RDBg2zZ1IpBFX0pl8oHnteLt7ZCgOM7Dq25HB_qjcNN2Qft56CzEk2ziTnlCUhVRsgMyQXDq_G9Pg/p.jpeg","Brasilia"));
        this.pontosTuristicos.add(new PontoTuristico("https://uc9b50677e9b424c738eee33d367.previews.dropboxusercontent.com/p/thumb/ABogGpjzdCEspNU8BiuLHfhQJGdh0aAZu0AekWT2QVwOwwNigF-WjnAz3fvdz8d-AdpWsE0lyJ51vHUCVioBDCm0pfcsstAL0x_DcnBF7IVMUDqV8OtnnkujK7EVi6WMrTxHZeT5hy9R7JgjVYETYYByMZd6Ji1W1iYckNv0bsi_Ph2sgeFroISVkgcmht52n0Jdv5exof2lT4UqL8liD99g-PqNpwUlljQZ2v63M4XKaWUf-7hYqr9W6n7y5PXJzifqldXmHlQdDHemiIb3mMBZh9DvvohQHWSlTIcpWaMW0O5KrjZVp8iX7Z__oSmqXoryGgyEiN4TfKxzz7sQCIuVRJ1irbXBukFOt5nZvq7-AHwH99I8eMJuSujHvEvJIKgQMqSE8M7Gu_pp6Uax-otGLC5vvyp5oGBKqhHcmMxj9w/p.jpeg","Curitiba"));
        this.pontosTuristicos.add(new PontoTuristico("https://uca4fac2e442e066e9d332a9bc06.previews.dropboxusercontent.com/p/thumb/ABpzOJZhgvRDzRkQklq9HjiFXAHidA8bx2EeAsIuY-V4Mpuob7CnPouZikODcV09m3gQnS5oK7DhORq9ssE2mntW0s6sF2bgQVjdHgvhxw79YnMdNqenqqz01aEdLCmcHEVOvbeeZdqtUluFYuQKxFFAJ8efSXHW8JqGibiguY8bw4DL7r0H3XnVb9S1qF33opPVK2COlNZsPVAT-VVSwltvw_olDieUYuJhcPM121YUblzuvHHOJRyxu-MlTCa8ZX7CO1DAzvfoEY7ll5T2RGe07ZkGEb-aipobEd3vj7c3p39U1YG6WbOr2yMr3x8fJcxHnySvihzGHlzP46Ugw68ChxaCV_S1VbbeBwgecn0Lsch6HvnB86oozaFI22yZIYNw6_OQLvDfEVKhibzx1-wlyh33hyx76vV4ctM7HRWJBw/p.jpeg","Las Vegas"));
        this.pontosTuristicos.add(new PontoTuristico("https://uce02d491830a0502fbd4bf9a582.previews.dropboxusercontent.com/p/thumb/ABo5Y7IJvQ4MupS3n365oNMdDEGAS3Di08nr957R9J23RVcGuLsk6H-TVM7s74Q188weO-VFSp82SbOPjQLS-bg-4EjW3vJE6KNptXRPmo5aQ9l6cfwRuOnomVx-VjfmaNKQFKAtt1AA8f7D5c6NOYf1lSvzLxluMcmcTA9ZmXV6NOAEic_nbqfpBnQZCHfn9P89x9G7Qv0_nK-t7ZCpQv-Y-3wy5phe9uE4QNueJ43xPN2Ofvrl3Iw05q_9hScQl3niKTxvVOJoknAMci_eRCBHA_klaoMCKuyZiU3dz6hSscSzFgrc25GzcPq1VV_6JJ6tbrKBr0UZdOLtCCZ77iLdcfsVzICrkUWSLCstgGGPs_beotIYNa_ek8Q6172M9wt2TzAWXs2TbtHmPgr5mGIeU5nFjtEOvbkc0KD9DWIkJA/p.jpeg","Mont Real"));
        this.pontosTuristicos.add(new PontoTuristico("https://uc91c1aa6275273ca78e95ff3939.previews.dropboxusercontent.com/p/thumb/ABozJLO3ikzTCCdtQpUePu76CDIKO4MB8lCcPGOpXoXW8H4zOt2MH9X8ThkmvSxc5m9SwmC2ZVy8NYicqnVHwCcRW9P5XnruF8U7TpDda7nXpD2qVDCJpBJTx0sl6xHYmSgkaGR_hYVuWZRATZYI6Xx1Jp2CSWej3Ha-5VVNQAsIg5kEWuDTs3eoZcusfkc0ul7ooM2uCAWyTbp4f1bciRkD_sWlL9FcULbcmd6raSn7ip8fIn2ipMCgcTOlk-pIGLXgxIoD-fz1ThqGrEt5OswUAY3aeX_EPuHy8ZKEvE115RkJbIonKPW86mexysiLKVa0pw2cHP2lSabmaIfXovi5fcXy6M3PrhoNIkgMrEK1t24CI8ChxQPTWq8EAaaPc8VhiVTvZYCO95g2mt7sR2FX1-DmJQQEpWDvbxbvpXim2A/p.jpeg","Paris"));
        this.pontosTuristicos.add(new PontoTuristico("https://uc52498915a38081f9680290b262.previews.dropboxusercontent.com/p/thumb/ABpiynTENgYlHw6CL8ErpFNmm248TZw0zVmpZOJCBhCffIlAfP4luVhwHZdOWQOaHaqOPTg4YnlpPkZnmieJUdDCzf2PAMKQC6JgFWO3f495mGfhSASG4LYf9PTe85crjP-CiwDllBNXawWer7OousUOQ_TsyZR2c5zAKJy-nPWBrZmhfPXc84GekaZLI89gxQVGC4AZUF16W1YQuA4B6-zcfwU8OKOczceJ8gvTJVivJnssqJL5eSQWRAmV8JUYeewwHTnSJkhA_7DsJUcjQoNhv1Oll241pcUdZy64dcnAJsDl2aUVtWVUmbKef_8IP7hH8UB6yBaKHUN1EewIsp_25UKOt32Tt4Y4ZPmEEEiDWreaZ7ake3iY3PcKE05wfhNGtojyjY_YgOVHgfwySgX4kUzMXcMojhnGA5v5_WsAnw/p.jpeg","Rio de Janeiro"));
        this.pontosTuristicos.add(new PontoTuristico("https://uc77694ca850328f966a24b6adc3.previews.dropboxusercontent.com/p/thumb/ABpq6FLmbgGmTnIoX2HyIAUm0C66eYfkp4zhSYMP-iiESiR3NHzo2aWOXkJHt3lo8Y_IeF9wwUlaXUaBXrhzjOqNiyrywK2dQnTgP5nv3dC4CxQoGys7EKdznI6OGHrHdT6IYNQ5J4JY_i0BRAT4tCAA3EGKMvVDXXAD-WCVlmIWkyw0y2QoinU8ewgaw-cYI7bOVFbC4nhS9t-k41ioMCM5wd46Df-a1SuakOPQesP0Fq1MYV1iI6rSHU_uWfs5CyEKaRzNVt7zvgaZNil3my4UAJP4nWz_ZwUMu-lNEj0EcBK3UPecNbd7la6k5GXxbK70DSJCfNy7IWGDW5Sd2hOlo0mqmVRlqqiib29bzD8lbwNZ_sW1iJmqTQHqeWG4nVdrMvq7FkYLcMxYz9y_4b7H3Gg2souFm_i6zfaOmEZIMQ/p.jpeg","Salvador"));
        this.pontosTuristicos.add(new PontoTuristico("https://ucc3e47710c4b94ca001771d634d.previews.dropboxusercontent.com/p/thumb/ABoH9DSdCXovVHEyR0g-jej1B6l1aeXHFqOW3ZR4R_Mc6iQWFYzYgYOYhdr4WIzZ882C64PLToElhOz7xRpCgo0zg3Em1QJk6rvz7ugF3DbqBucB44n127c1EsLrcKMPT3pDBaOMQ5xZGltEBYJUbkS6tzCic6wKq3kFlO8cMOUacCY6CbDlaeFxlxbLE9chCcqIOwVUfJPgV5G46pp2FSAODhcnpbVBcp5zEpvFLhPzkX33JTYmlvHhJbO1W34YE92mC68TqxKfUEIhENieTRiRhlPi2MnPY47erWE54AppNa5xdhlwJ5T--EX82FFEIB05svD7AQjrv_8GiHuQvQkygdVtIWXD41zrRJajNYRn40uXSGqw2GFmvp6TzK_jrPq0izOHymC895yti_KSndHr184gXMyiqUCkbGHpmvaB3Q/p.jpeg","Sao Paulo"));
        this.pontosTuristicos.add(new PontoTuristico("https://uc123a32bb75be27dca6c40c28e6.previews.dropboxusercontent.com/p/thumb/ABqWGpvA1ZROJmHeF6SpBeIWtqmH0ABKWx6OYpxJOcmX_LbhW6pzauJS_b-H3P89HwYFcw81swrTlGw5pZHhPf_-MmCILQk7iR7v8EFSBrzSd6gHhqnoMsvzneO18xsa0H7eh0u_q612LPgks1Gq2NzAUPLbyinoMQyZTzfJQjDTnxChR16nVRuba9uKDfm4ISxyabUTakLPnBBfZBSI3ld8Iz31AcyL-v8flFjNmFUsJ01R2hQbPY6deJ9nr-qYHzXzGa2UuCUGZBY-5s0XIoSTOIOY8tyeyGqDqX5C7FsdyitL6ZVXLgUGTWCo7ZA4wzAoO-BFIL7txLQPhXYT-vPhEZYjCdKjhdUFkNqT6DqWTZGyCTQSbYtismqCD84sI9ciVwNeFzhybWNyx7FhvEe-1i5N83C8IyZwsSXtrAmKxA/p.jpeg","Toquio"));


    }

}